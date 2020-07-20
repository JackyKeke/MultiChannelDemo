# MultiChannelDemo
Multi-Channel build sample（多渠道构建范例）


### 主工程代码
##### 主工程的 build.gradle
```` groovy
   
  各种的渠道包首先要写好  signingConfigs 并置于 buildTypes 和 productFlavors  之前 
  signingConfigs {
        sbGoogle {
            keyAlias RELEASE_KEY_ALIAS
            keyPassword RELEASE_KEY_PASSWORD
            storeFile file(RELEASE_STORE_FILE)
            storePassword RELEASE_STORE_PASSWORD
        }
    }
````



