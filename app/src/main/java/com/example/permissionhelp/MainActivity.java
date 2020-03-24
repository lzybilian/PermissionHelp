package com.example.permissionhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.TextView;

import com.example.permissionhelp2.IPermissionListenerWrap;
import com.example.permissionhelp2.Permission;
import com.example.permissionhelp2.PermissionsHelper;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.permission);
        if (!PermissionsHelper.getInstance(this).checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            requestPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE});
        } else {
            textView.setText("已拥有读写权限");
        }
    }

    private void requestPermission(final String[] permissions) {
        PermissionsHelper.getInstance(MainActivity.this).requestEachPermissions(permissions, new IPermissionListenerWrap.IEachPermissionListener() {
            @Override
            public void onAccepted(Permission permission) {
                if(permission.granted){
                    textView.setText("已拥有读写权限");
                }
                textView.setText("权限申请失败");
            }

            @Override
            public void onException(Throwable throwable) {
                textView.setText("权限申请失败");
            }
        });
    }
}
