
Pod::Spec.new do |spec|
  spec.name         = 'TXIMSDK_Plus_AdvancedEncryptionPlugin'
  spec.version      = '8.1.6905'
  spec.platform     = :ios 
  spec.ios.deployment_target = '8.0'
  spec.license      = { :type => 'Proprietary',
      :text => <<-LICENSE
        copyright 2017 tencent Ltd. All rights reserved.
        LICENSE
       }
  spec.homepage     = 'https://cloud.tencent.com/document/product/269/3794'
  spec.documentation_url = 'https://cloud.tencent.com/document/product/269/9147'
  spec.authors      = 'tencent video cloud'
  spec.summary      = 'TXIMSDK_Plus_AdvancedEncryptionPlugin'
  
  spec.requires_arc = true

  spec.source = { :http => 'https://im.sdk.cloud.tencent.cn/download/plus/8.1.6905/TIMAdvancedEncryptionPlugin_8.1.6905.framework.zip'}
  spec.preserve_paths = '**/TIMAdvancedEncryptionPlugin.framework'
  spec.vendored_frameworks = '**/TIMAdvancedEncryptionPlugin.framework'
  spec.pod_target_xcconfig = {
    'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'arm64'
  }
  spec.user_target_xcconfig = { 
    'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'arm64'
  } 

end
