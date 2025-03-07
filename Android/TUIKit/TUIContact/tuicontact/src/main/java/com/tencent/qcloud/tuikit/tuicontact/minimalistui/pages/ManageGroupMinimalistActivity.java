package com.tencent.qcloud.tuikit.tuicontact.minimalistui.pages;

import static com.tencent.qcloud.tuikit.tuicontact.TUIContactConstants.GROUP_PROFILE_BEAN;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.GroupProfileBean;
import com.tencent.qcloud.tuikit.timcommon.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuikit.timcommon.component.MinimalistLineControllerView;
import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.activities.BaseMinimalistLightActivity;
import com.tencent.qcloud.tuikit.timcommon.component.gatherimage.ShadeImageView;
import com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.TUIContactConstants;
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuicontact.presenter.GroupManagerPresenter;
import java.util.ArrayList;
import java.util.List;

public class ManageGroupMinimalistActivity extends BaseMinimalistLightActivity {
    private TitleBarLayout titleBarLayout;
    private MinimalistLineControllerView muteAllView;
    private View addMuteMemberView;
    private RecyclerView mutedList;
    private MutedMemberAdapter mutedMemberAdapter;

    private GroupManagerPresenter presenter;
    private GroupProfileBean profileBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_minimalist_manager);
        presenter = new GroupManagerPresenter();
        titleBarLayout = findViewById(R.id.group_manage_title_bar);
        muteAllView = findViewById(R.id.group_manage_mute_all);
        addMuteMemberView = findViewById(R.id.group_manage_add_mute_member);
        mutedList = findViewById(R.id.group_manage_muted_member_list);
        mutedList.setLayoutManager(new CustomLinearLayoutManager(this));
        mutedMemberAdapter = new MutedMemberAdapter();
        mutedList.setAdapter(mutedMemberAdapter);

        profileBean = (GroupProfileBean) getIntent().getSerializableExtra(GROUP_PROFILE_BEAN);

        muteAllView.setChecked(profileBean.isAllMuted());
        if (profileBean.isAllMuted()) {
            addMuteMemberView.setVisibility(View.GONE);
            mutedList.setVisibility(View.GONE);
        }

        titleBarLayout.setTitle(getString(R.string.group_manager), ITitleBarLayout.Position.MIDDLE);
        setClickListener();
        loadMutedMember();
    }

    private void setClickListener() {
        titleBarLayout.getLeftIcon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        muteAllView.setCheckListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                presenter.muteAll(profileBean.getGroupID(), isChecked, new IUIKitCallback<Void>() {
                    @Override
                    public void onSuccess(Void data) {
                        if (isChecked) {
                            addMuteMemberView.setVisibility(View.GONE);
                            mutedList.setVisibility(View.GONE);
                        } else {
                            addMuteMemberView.setVisibility(View.VISIBLE);
                            mutedList.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onError(String module, int errCode, String errMsg) {
                        ToastUtil.toastShortMessage(errCode + ", " + errMsg);
                    }
                });
            }
        });

        addMuteMemberView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.equals(profileBean.getGroupType(), GroupInfo.GROUP_TYPE_AVCHATROOM)
                    || TextUtils.equals(profileBean.getGroupType(), GroupInfo.GROUP_TYPE_WORK)) {
                    ToastUtil.toastShortMessage(getString(R.string.group_not_support_mute_member));
                    return;
                }

                Intent intent = new Intent(ManageGroupMinimalistActivity.this, GroupMemberMinimalistActivity.class);
                intent.putExtra(TUIConstants.TUIContact.IS_SELECT_MODE, true);
                intent.putExtra(TUIConstants.TUIContact.FILTER, GroupInfo.GROUP_MEMBER_FILTER_COMMON);
                if (mutedMemberAdapter.getGroupMemberInfoList() != null) {
                    ArrayList<String> selectedList = new ArrayList<>();
                    for (GroupMemberInfo memberInfo : mutedMemberAdapter.getGroupMemberInfoList()) {
                        selectedList.add(memberInfo.getUserId());
                    }
                    intent.putExtra(TUIConstants.TUIContact.SELECTED_LIST, selectedList);
                }
                intent.putExtra(TUIConstants.TUIContact.GROUP_ID, profileBean.getGroupID());
                startActivityForResult(intent, 1);
            }
        });

        mutedMemberAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public void onClick(View view, GroupMemberInfo memberInfo) {
                Drawable drawable = view.getBackground();
                if (drawable != null) {
                    drawable.setColorFilter(0xd9d9d9, PorterDuff.Mode.SRC_IN);
                }
                View itemPop = LayoutInflater.from(ManageGroupMinimalistActivity.this).inflate(R.layout.group_manager_pop_menu, null);
                PopupWindow popupWindow = new PopupWindow(itemPop, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        if (drawable != null) {
                            drawable.clearColorFilter();
                        }
                    }
                });
                TextView popText = itemPop.findViewById(R.id.pop_text);
                popText.setText(R.string.group_cancel_mute_label);
                popText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        presenter.cancelMuteGroupMember(profileBean.getGroupID(), memberInfo.getUserId(), new IUIKitCallback<Void>() {
                            @Override
                            public void onSuccess(Void data) {
                                mutedMemberAdapter.onItemRemoved(memberInfo);
                            }

                            @Override
                            public void onError(String module, int errCode, String errMsg) {
                                ToastUtil.toastShortMessage(errCode + ", " + errMsg);
                            }
                        });
                    }
                });
                int x = view.getWidth() / 2;
                int y = -view.getHeight() / 3;
                int popHeight = ScreenUtil.dip2px(45) * 3;
                if (y + popHeight + view.getY() + view.getHeight() > mutedList.getBottom()) {
                    y = y - popHeight;
                }
                popupWindow.showAsDropDown(view, x, y, Gravity.TOP | Gravity.START);
            }
        });
    }

    private void loadMutedMember() {
        presenter.loadMutedMembers(profileBean.getGroupID(), new IUIKitCallback<List<GroupMemberInfo>>() {
            @Override
            public void onSuccess(List<GroupMemberInfo> data) {
                mutedMemberAdapter.setGroupMemberInfoList(data);
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                ToastUtil.toastShortMessage(errCode + ", " + errMsg);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null) {
            List<String> selectedList = data.getStringArrayListExtra(TUIContactConstants.Selection.LIST);
            if (selectedList != null && !selectedList.isEmpty()) {
                for (String userId : selectedList) {
                    presenter.muteGroupMember(profileBean.getGroupID(), userId, new IUIKitCallback<Void>() {
                        @Override
                        public void onSuccess(Void data) {
                            loadMutedMember();
                        }

                        @Override
                        public void onError(String module, int errCode, String errMsg) {
                            ToastUtil.toastShortMessage(errCode + ", " + errMsg);
                        }
                    });
                }
            }
        }
    }

    class MutedMemberAdapter extends RecyclerView.Adapter<MutedMemberAdapter.MutedMemberViewHolder> {
        private List<GroupMemberInfo> groupMemberInfoList;

        private OnItemLongClickListener onItemLongClickListener;

        public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
            this.onItemLongClickListener = onItemLongClickListener;
        }

        public void onItemRemoved(GroupMemberInfo memberInfo) {
            int index = groupMemberInfoList.indexOf(memberInfo);
            groupMemberInfoList.remove(memberInfo);
            notifyItemRemoved(index);
        }

        public void setGroupMemberInfoList(List<GroupMemberInfo> groupMemberInfoList) {
            this.groupMemberInfoList = groupMemberInfoList;
            notifyDataSetChanged();
        }

        public List<GroupMemberInfo> getGroupMemberInfoList() {
            return groupMemberInfoList;
        }

        @NonNull
        @Override
        public MutedMemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_minimalist_manager_item, parent, false);
            return new MutedMemberViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MutedMemberViewHolder holder, int position) {
            GroupMemberInfo groupMemberInfo = groupMemberInfoList.get(position);
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onItemLongClickListener != null) {
                        onItemLongClickListener.onClick(v, groupMemberInfo);
                    }
                    return false;
                }
            });
            holder.managerName.setText(groupMemberInfo.getDisplayName());
            GlideEngine.loadUserIcon(holder.faceIcon, groupMemberInfo.getFaceUrl());
        }

        @Override
        public int getItemCount() {
            if (groupMemberInfoList == null || groupMemberInfoList.isEmpty()) {
                return 0;
            }
            return groupMemberInfoList.size();
        }

        class MutedMemberViewHolder extends RecyclerView.ViewHolder {
            ShadeImageView faceIcon;
            TextView managerName;

            public MutedMemberViewHolder(@NonNull View itemView) {
                super(itemView);
                faceIcon = itemView.findViewById(R.id.group_manager_face);
                faceIcon.setRadius(ScreenUtil.dip2px(25));
                managerName = itemView.findViewById(R.id.group_manage_name);
            }
        }
    }

    interface OnItemLongClickListener {
        void onClick(View view, GroupMemberInfo groupMemberInfo);
    }
}