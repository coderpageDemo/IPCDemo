// IpcInterface.aidl
package com.coderpage.ipcapp1;


interface IpcInterface {

    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    String getUserName();
}
