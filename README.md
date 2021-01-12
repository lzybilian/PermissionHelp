# PermissionHelp
权限申请帮助

使用示例

   if (!PermissionsHelper.getInstance(this).checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
       requestPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE});
    } else {
       textView.setText("已拥有读写权限");
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