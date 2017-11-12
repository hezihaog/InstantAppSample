package com.hzh.instant.app.sample.feature;

import android.support.annotation.Nullable;

import com.hzh.easy.cache.base.BaseCache;

import java.io.Serializable;

/**
 * @包名 com.hzh.instant.app.sample.feature
 * @类名 UserInfoCache
 * @创建时间 on 2017/11/4  下午9:53
 * @作者 子和
 * @类的描述 TODO
 * Email hezihao@linghit.com
 * 最后更新者 UserInfoCache
 * 最后修改时间：2017/11/4  下午9:53
 */

public class UserInfoCache extends BaseCache<UserInfoCacheParams> {
    private static final String KEY = "cache_key_user_info";

    @Override
    public void removeCache(@Nullable UserInfoCacheParams params) {
        getOperate().removeCache(KEY + params.getUserId());
    }

    @Override
    public void put(@Nullable UserInfoCacheParams params, Serializable target) {
        getOperate().putData(KEY + params.getUserId(), target);
    }

    @Override
    public <T extends Serializable> T get(@Nullable UserInfoCacheParams params) {
        return (T) getOperate().getData(KEY + params.getUserId(), "");
    }
}
