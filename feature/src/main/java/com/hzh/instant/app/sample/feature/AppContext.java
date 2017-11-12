package com.hzh.instant.app.sample.feature;

import android.app.Application;

import com.hzh.easy.cache.CacheManager;

/**
 * @包名 com.hzh.instant.app.sample.feature
 * @类名 AppContext
 * @创建时间 on 2017/11/8  下午6:40
 * @作者 子和
 * @类的描述 TODO
 * Email hezihao@linghit.com
 * 最后更新者 AppContext
 * 最后修改时间：2017/11/8  下午6:40
 */

public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CacheManager.getInstance().init(getApplicationContext());
    }
}
