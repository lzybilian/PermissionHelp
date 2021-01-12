# PermissionHelp
权限申请帮助   当初推这个库主要是为了尝试在github上创建自己可以维护的库，并在后续的项目中更加快速的使用。  
依赖：  
  
 	Add it in your root build.gradle at the end of repositories:  
  
  	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}  
	
  Add the dependency  
  
	  dependencies {
	        implementation 'com.github.lzybilian:PermissionHelp:1.01'
  	}
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
