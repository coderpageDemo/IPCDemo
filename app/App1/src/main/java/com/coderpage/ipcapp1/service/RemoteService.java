package com.coderpage.ipcapp1.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.coderpage.ipcapp1.IpcInterface;

/**
 * @author abner-l
 * @since  2015-10-28.
 */
public class RemoteService extends Service {
    private String userName = "Abner-L";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        // 被绑定成功后，将 Binder 对象返回给绑定方
        return new ReturnBinder();
    }

    /**
     * ReturnBinder 继承自 IpcInterface.Stub，这个类由我们创建的 IcpInterface.aidl 文件自动生成
     * ReturnBinder 也将会作为进程间通信数据传递的载体返回给对方
     */
    public class ReturnBinder extends IpcInterface.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getUserName() throws RemoteException {
            return userName;
        }
    }
}
