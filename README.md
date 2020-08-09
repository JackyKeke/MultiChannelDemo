# MultiChannelDemo
Multi-Channel build sample（多渠道构建范例）


## 主工程代码拓展不同渠道包

### 主工程的 build.gradle
```` groovy
   
  各种的渠道包首先要写好 signingConfigs 并置于 buildTypes 和 productFlavors 之前 
  signingConfigs {
        sbGoogle {
            keyAlias RELEASE_KEY_ALIAS
            keyPassword RELEASE_KEY_PASSWORD
            storeFile file(RELEASE_STORE_FILE)
            storePassword RELEASE_STORE_PASSWORD
        }
  }
````


## 不同渠道包的 buildTypes
### 主工程的 buildTypes

```groovy
 
 buildTypes {

        debug {
            applicationIdSuffix ".debug"  //后缀
            minifyEnabled false   //是否混淆
            zipAlignEnabled true  //是否压缩 对齐
            shrinkResources false  //是否抛弃不用的资源
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }

        release {
        }

//       可以debug 的 release版又称 preview版
        preview {
            debuggable true // 是否保留debug信息
            jniDebuggable true  // 是否保留native debug信息
        
            //matchingFallbacks 其他作用
            //matchingFallbacks 不仅可以用于配置 productFlavors, 还可以配置 build type, 比如, 如果module B 有一个特殊的 build type, 然后 module A 中只有 debug 和 release 两种 build type, 会有同样类似的编译错误. 该问题依然可以通过 matchingFallbacks 指定 build type 类型来解决, 如 :
            //
            //    buildTypes {
            //        releaseQA {
            //            matchingFallbacks = ['release']
            //        }
            //    }
            //
            //作者：bangelua
            //链接：https://www.jianshu.com/p/7e2d0e59a2bb
            matchingFallbacks = ['release', 'debug']
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }

    }


```


### 其他模块在打包的时候的 proguardFiles 必须用 consumerProguardFiles 替代
否则就会主模块对子模块的混淆造成干扰

```groovy
   consumerProguardFiles "consumer-rules.pro"

```



### 主工程的 productFlavors 来了
```groovy

 productFlavors {
        dev {
//            applicationId "com.jackykeke.dev"
            signingConfig signingConfigs.sbGoogle   // 引用的打包配置
            dimension "funfunzone"
            // 对resValue在java代码中的使用：String app_id = getResources().getString(R.string.app_id);
            resValue("string", "app_name", "开发版")       // 生成 resource 资源
            buildConfigField  "String", "app_server", "\"http://www.dev.com\"" // 生成编译时 BuildConfig 资源

            // 对manifestPlaceholders中资源的使用：在AndroidManifest.xml文件中的application节点下
            // andorid:icon="${icon}"
            // android:label="${app_name}"
            manifestPlaceholders = [app_name: "@string/app_name", icon: "@drawable/dev"]
        }


        xiaomiVersion {
            applicationId "com.multichannel.xiaomi"    //可以修改每一个模块的 applicationId
            signingConfig signingConfigs.sbGoogle    //可以修改打包配置
          
        }

        playVersion {
            applicationId "com.multichannel.play"
            signingConfig signingConfigs.sbGoogle
           
        }

//        //这里的flavor名如果是数字开头，必须用引号引起来。
        qihu360 {
            //360为不签名版
        }
    }

```

### 主工程引用子模块的资源 布局
DifferentActivity
```java
        setContentView(R.layout.activity_different);
```

在主工程引用xiaomi模块时
```groovy
 debugImplementation project(":xiaomi")
```
会出现
pic


在主工程引用play模块时
```groovy
 debugImplementation project(":play")
```
会出现
pic

完成了主工程引用子模块的资源 布局



