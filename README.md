# InstantAppSample

### 文章地址
- [简书地址](https://www.jianshu.com/p/4522f69c3199)

### 一、什么是Instant App，使用场景是什么？

- Instant Apps概念，Instant Apps 是 16 年的 IO 大会上被提出来。

- 它的使用场景：你和一群小伙伴出去吃饭，吃完饭后AA制，你要下载一个付款的App，付完款，这个App就要卸载了，就是用完即弃的场景。如果App非常大，40M多，你身边又没有WIFI，流量又没多少，这就是一种浪费了。

- 优化，有没有可能，打开一个链接，就能付款，不用下载App，但是性能和效果又和App相差无几呢？这种需求下，google大大就推出了Instant App的概念。

- 还有一个场景，如果你使用GooglePay下载一个付费游戏，但是你不知道好不好，这时候你只能依靠评论、评分和网上搜索来判断这款游戏，付款前，你会有这种顾虑而去做这种准备。

- 如果商店提供一个试用功能该多好啊，能试玩游戏前几关，觉得不错再解锁，但是下载的包有的甚至几G，看到这大小，手机的机身存储，还有自己的宿舍渣网速，又没有玩的欲望。（当然有的游戏，后面的关卡使用下载游戏包的方式拓展，但是如果App也想用这种方式呢？不好做吧）

![image.png](http://upload-images.jianshu.io/upload_images/1641428-ec79cec96bf15a3b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


### 二、Instant App能怎么解决这种问题呢？
- Instant App 的 mini SDK必须是23以上，即6.0以上。

- 开发Instant App无须另起项目，只需在原有的App项目，新建一个Instant app的module，分拆出一个 “base” 和 一个“feature”的module。将公用代码和资源放在base，feature放置需要提供出去的模块。

- 既然是链接，就要配置后台啦，Instant App需要在域或子域的根目录托管一个JSON文件，/.well-known/assetlinks.json。

```java
[
  {
    "relation": [
      "delegate_permission/common.handle_all_urls"
    ],
    "target": {
      "namespace": "android_app",
      "package_name": "com.myapp.packagename",
      "sha256_cert_fingerprints": [
        "96:14:26:30:CC:E3:C0:9B:05:12:7B:9A:31:9E:88:36:82:12:84:27:4C:52:2F:05:FE:66:A8:AB:B9:F0:F5:F0"
      ]
    }
  }
]
```

- 在feature模块的清单文件，给需要跳转的Activity配置上一个intent-filter，加入一个链接节点。

```java
<activity android:name="com.hzh.instant.app.sample.feature.MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>

            //---------- start ----------
            <intent-filter android:order="1">
                <action android:name="android.intent.action.VIEW" />

                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />

                <data
                    android:host="hzh.com"
                    android:pathPattern="/hello"
                    android:scheme="https" />
            </intent-filter>
        </activity>
       //---------- end ----------
```

### 三、和原生App的不同

- 权限,Instant App只支持如下权限，并且不需要申请，直接就可以使用，如果按照原生的6.0请求，全部都默认返回不允许。坑。。那怎么解决呢，其实只要加上判断是不是instant app就默认允许就可以啦。
￼￼![image.png](http://upload-images.jianshu.io/upload_images/1641428-6edb06b3e903eb61.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 请求限制，必须是必须使用HTTPS等TLS协议进行加密（如果是http，加载不出来...）。

- 每个Feature Module大小必须小于4M，大于就必须再进行拆分啦。

- 必须有google service和google account。（国内，嗯，你懂的）

- 最后怎么判断运行的是Instant App呢，Google已经给我们准备好啦，直接gradle依赖。

```java
compile 'com.google.android.instantapps:instantapps:1.1.0'
```

- 在代码里面调用

```java
if (InstantApps.isInstantApp(this)) {
       ......//Instant的操作
} else {
       ......//原生的操作
}
```

### 四、项目架构
- Apk，常规项目application module，引用所有feature module。
- Instant ，即时应用module，引用base和所有feature moudle。
- base，用feature标记所有feature module，application project标记整体apk module。

### Sample地址

- [Github链接](https://github.com/hezihaog/InstantAppSample)

