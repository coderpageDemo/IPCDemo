package com.coderpage.ipcapp2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.coderpage.ipcapp1.IpcInterface;
import com.coderpage.ipcapp1.R;

public class MainActivity extends AppCompatActivity {
    private TextView showIpcDataTV;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IpcInterface ipcInterface = IpcInterface.Stub.asInterface(service);
            try {
                String userName = ipcInterface.getUserName();
                showIpcDataTV.setText("DataFromApp1: " + userName);
                Log.d("onServiceConnected", "ipcdata:" + userName);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showIpcDataTV = (TextView) findViewById(R.id.tv_show_ipc_data);
    }

    public void getIpcData(View view) {
        Intent bindINT = new Intent("com.coderpage.ipcapp1.service.RemoteService");
        bindINT.setPackage("com.coderpage.ipcapp1");
        bindINT.setAction("com.coderpage.service.REMOTE_CLIENT");
        bindService(bindINT, connection, Context.BIND_AUTO_CREATE);
    }


}
