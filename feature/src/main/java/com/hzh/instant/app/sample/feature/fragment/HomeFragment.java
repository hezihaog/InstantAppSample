package com.hzh.instant.app.sample.feature.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hzh.instant.app.sample.feature.R;

/**
 * @包名 com.hzh.instant.app.sample.feature.fragment
 * @类名 HomeFragment
 * @创建时间 on 2017/11/7  下午5:19
 * @作者 子和
 * @类的描述 TODO
 * Email hezihao@linghit.com
 * 最后更新者 HomeFragment
 * 最后修改时间：2017/11/7  下午5:19
 */

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
