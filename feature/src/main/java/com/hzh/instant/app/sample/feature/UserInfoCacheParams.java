package com.hzh.instant.app.sample.feature;

import com.hzh.easy.cache.base.BaseCacheParams;

/**
 * @包名 com.hzh.instant.app.sample.feature
 * @类名 UserInfoCacheParams
 * @创建时间 on 2017/11/4  下午9:53
 * @作者 子和
 * @类的描述 TODO
 * Email hezihao@linghit.com
 * 最后更新者 UserInfoCacheParams
 * 最后修改时间：2017/11/4  下午9:53
 */

public class UserInfoCacheParams extends BaseCacheParams {
    private static final String KEY = "params_user_info";

    public void putUserId(String userId) {
        put(KEY, userId);
    }

    public String getUserId() {
        return get(KEY);
    }
}
