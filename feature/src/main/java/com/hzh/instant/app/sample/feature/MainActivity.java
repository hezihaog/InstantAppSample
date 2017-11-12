package com.hzh.instant.app.sample.feature;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hzh.fast.permission.FastPermission;
import com.hzh.fast.permission.callback.PermissionCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.hello);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FastPermission.getInstance().request(getActivity(), new PermissionCallback() {
                    @Override
                    public void onGranted() {
                        toast("success");
                    }

                    @Override
                    public void onDenied(List<String> perms) {
                        toast("fail");
                    }
                }, new String[]{
                        Manifest.permission.CALL_PHONE});
            }
        });
    }

    private void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private AppCompatActivity getActivity() {
        return this;
    }
}