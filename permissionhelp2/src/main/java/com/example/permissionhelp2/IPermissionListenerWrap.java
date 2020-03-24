package com.example.permissionhelp2;

/**
 * Created by jun xu on 19-1-9.
 */
public interface IPermissionListenerWrap {

     interface IEachPermissionListener {

        void onAccepted(Permission permission);

        void onException(Throwable throwable);
    }

     interface IPermissionListener {

        void onAccepted(boolean isGranted);

        void onException(Throwable throwable);
    }
}
