[English](./README_EN.md) | 简体中文

公告：TUIKit Android 与 iOS 端开放 Pull Request，merge 成功后会在 README.md 上留下您的大名并超链到您的 Github 主页！

## 镜像下载

腾讯云分流下载地址： [DOWNLOAD](https://im.sdk.qcloud.com/download/github/TIMSDK.zip)

## SDK下载

<table>
<tr>
<th width="94px" style="text-align:center" >终端 SDK</td>
 <th width="0px" style="text-align:center" >下载地址</td>
<th width="0px"  style="text-align:center">集成指引文档</td>
<th width="175px" style="text-align:center">更新日志</td>
</tr>
<tr>
<td style="text-align:center">Android  </td>
<td style="text-align:center" ><a href="https://github.com/tencentyun/TIMSDK/tree/master/Android/IMSDK">Github(推荐)</a></td>
<td style="text-align:left" ><a href="https://cloud.tencent.com/document/product/269/37059">【极速集成】导入TUIKit (Android)</a><br><a href="https://cloud.tencent.com/document/product/269/32679">【常规集成】快速导入到工程 (Android)</a></td>
<td style="text-align:center" rowspan='4'><a href="https://cloud.tencent.com/document/product/269/1606">更新日志(终端)</a> </td>
</tr>
<tr>
<td style="text-align:center">iOS  </td>
<td style="text-align:center" ><a href="https://github.com/tencentyun/TIMSDK/tree/master/iOS/IMSDK">Github(推荐)</a></td>
<td style="text-align:left" ><a href="https://cloud.tencent.com/document/product/269/37060">【极速集成】导入TUIKit (iOS)</a><br><a href="https://cloud.tencent.com/document/product/269/32675">【常规集成】快速导入到工程  (iOS)</a></td>
</tr>
<tr>
<td style="text-align:center">Mac  </td>
<td style="text-align:center" ><a href="https://github.com/tencentyun/TIMSDK/tree/master/Mac/IMSDK">Github(推荐)</a></td>
<td style="text-align:left" ><a href="https://cloud.tencent.com/document/product/269/32676">【常规集成】快速导入到工程 (Mac)</a></td>
</tr>
<tr>
<td style="text-align:center">Windows  </td>
<td style="text-align:center" ><a href="https://github.com/tencentyun/TIMSDK/tree/master/Windows/IMSDK">Github(推荐)</a></td>
<td style="text-align:left" ><a href="https://cloud.tencent.com/document/product/269/33489">【常规集成】快速导入到工程 (Windows)</a></td>
</tr>
</table>

## TUIKit集成

<table >
  <tr>
    <th width="180px" style="text-align:center">功能模块</th>
    <th width="180px" style="text-align:center">平台</th>
    <th width="500px" style="text-align:center">文档链接</th>
  </tr>

  <tr >
​    <td rowspan='2' style="text-align:center">快速集成</td>
​    <td style="text-align:center">iOS</td>
​    <td style="text-align:center"><a href="https://cloud.tencent.com/document/product/269/37060">TUIKit-iOS快速集成</a></td>
  </tr>

  <tr>
​    <td style="text-align:center">Android</td>
​    <td style="text-align:center"><a href="https://cloud.tencent.com/document/product/269/37059">TUIKit-Android快速集成</a></td>
  </tr>

  <tr>
​    <td rowspan='2' style="text-align:center">修改界面样式</td>
​    <td style="text-align:center">iOS</td>
​    <td style="text-align:center"><a href="https://cloud.tencent.com/document/product/269/37065">TUIKit-iOS修改界面样式</a></td>

  </tr>

  <tr>
​    <td style="text-align:center">Android</td>
​    <td style="text-align:center"><a href="https://cloud.tencent.com/document/product/269/37064">TUIKit-Android修改界面样式</a></td>
  </tr>

  <tr>
​    <td rowspan='2' style="text-align:center">自定义消息</td>
​    <td style="text-align:center">iOS</td>
​    <td style="text-align:center"><a href="https://cloud.tencent.com/document/product/269/37067">TUIKit-iOS自定义消息</a></td>
  </tr>

  <tr>
​    <td style="text-align:center">Android</td>
​    <td style="text-align:center"><a href="https://cloud.tencent.com/document/product/269/37066">TUIKit-Android自定义消息</a></td>
  </tr>

</table>

## 基础版与增强版差异对比
- SDK 从 5.4 版本开始，原有精简版改名为增强版，原有标准版改名为基础版。
- 增强版与基础版同时支持 [V2 API](https://cloud.tencent.com/document/product/269/44498)；但增强版不再支持旧版 API，基础版继续支持旧版 API。
- 如果您没有接入过旧版 API，建议您直接使用 [V2 API](https://cloud.tencent.com/document/product/269/44498)，选择增强版 SDK。
- 如果您已经接入了旧版 API，推荐您升级到 [V2 API](https://cloud.tencent.com/document/product/269/44498)，逐步切换到增强版 SDK。
- 在 SDK 体积和安装包增量上，增强版与基础版相比有大幅度缩减。
- 在 SDK 功能支持上，增强版与基础版相比提供了更多新功能特性。
- 后续新功能开发，只在增强版上提供支持；基础版后续只做例行维护与现有问题修复。

### SDK 体积大小对比
<table>
  <tr>
    <th width="200px" style="text-align:center">平台</th>
    <th width="260px" style="text-align:center">对比项</th>
    <th width="200px" style="text-align:center">基础版</th>
    <th width="200px" style="text-align:center">增强版</th>
  </tr>
  <tr>
    <td style="text-align:center">Android</td>
    <td style="text-align:center">aar 大小</td>
    <td style="text-align:center">7.8 MB</td>
    <td style="text-align:center">3.1 MB</td>
  </tr>
  <tr>
    <td style="text-align:center">iOS</td>
    <td style="text-align:center">framework 大小</td>
    <td style="text-align:center">57.7 MB</td>
    <td style="text-align:center">11.2 MB</td>
  </tr>
</table>

### App 体积增量对比
<table>
  <tr>
    <th width="200px" style="text-align:center">平台</th>
    <th width="260px" style="text-align:center">架构</th>
    <th width="200px" style="text-align:center">基础版</th>
    <th width="200px" style="text-align:center">增强版</th>
  </tr>
  <tr>
    <td rowspan='2' style="text-align:center">apk 增量</td>
    <td style="text-align:center">armeabi-v7a</td>
    <td style="text-align:center">3.2 MB</td>
    <td style="text-align:center">1.1 MB</td>
  </tr>
  <tr>
    <td style="text-align:center">arm64-v8a</td>
    <td style="text-align:center">5.2 MB</td>
    <td style="text-align:center">1.7 MB</td>
  </tr>
  <tr>
    <td style="text-align:center">ipa 增量</td>
    <td style="text-align:center">arm64</td>
    <td style="text-align:center">2.1 MB</td>
    <td style="text-align:center">1.1 MB</td>
  </tr>
</table>

## IMSDK 升级 V2API 接口指引

[接口升级指引](https://docs.qq.com/sheet/DS3lMdHpoRmpWSEFW)

## 最新增强版 6.5.2803 @2022.07.15

### SDK

- 新增[会话标记](https://cloud.tencent.com/document/product/269/77389)支持
- 新增[会话分组](https://cloud.tencent.com/document/product/269/77392)支持
- 新增会话自定义字段支持
- 新增[拉取会话高级接口](https://cloud.tencent.com/document/product/269/75366#.E8.8E.B7.E5.8F.96.E4.BC.9A.E8.AF.9D.E5.88.97.E8.A1.A8.E9.AB.98.E7.BA.A7.E6.8E.A5.E5.8F.A3)
- 支持接收直播群广播消息
- 支持加群选项变更的通知下发
- 支持群消息接收选项变更的多端同步
- 优化长连接选路逻辑，支持策略轮转
- 预埋日本站支持
- 升级 HttpDNS 选路请求的授权 ID
- 国际站支持 HttpDNS 选路方式
- 优化直播群长轮询请求的起始 Sequence
- 优化话题资料中 lastMessage 在某些条件下的缺失问题
- 优化会话置顶顺序逻辑
- 优化消息端到端时间的统计逻辑
- 修复重发失败的消息导致历史消息里偶现重复消息的问题
- 修复在低版本手机上发送 emoj 表情显示乱码的问题
- 修复 onRecvMessageModified 返回的消息中 faceURL 为空的问题
- 修复登录后偶现收不到离线期间的群邀请信令的问题


### TUIKit & Demo

- C2C 单聊支持“正在输入中......”
- 会话和通讯录增加好友在线状态功能
- 发送的消息超过2分钟后，不再显示“撤回”选项
- 多端自定义消息互通兼容
- Android 解决特定场景下会话不重排的问题
- 离线推送组件移除 TPNS 通道


## 最新基础版 5.1.66 @2021.09.22

### Android

- 去掉 WiFi 信息的获取

## 问题反馈
- 为了更好的了解您使用TIMSDK所遇到的问题，方便快速有效定位解决TIMSDK问题，希望您按如下反馈指引反馈issue，方便我们尽快解决您的问题
- [TIMSDK issue反馈指引](https://github.com/tencentyun/TIMSDK/wiki/TIMSDK-issue%E6%9C%89%E6%95%88%E5%8F%8D%E9%A6%88%E6%A8%A1%E6%9D%BF)
