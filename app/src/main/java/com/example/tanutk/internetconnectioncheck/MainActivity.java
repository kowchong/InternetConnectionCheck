package com.example.tanutk.internetconnectioncheck;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox wifiCheckbox = (CheckBox) findViewById(R.id.wifi_checkBox);
        CheckBox connectedCheckbox = (CheckBox) findViewById(R.id.connected_checkBox);
        CheckBox dataCheckbox = (CheckBox) findViewById(R.id.data_checkBox);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);


        NetworkInfo activeConnection = connectivityManager.getActiveNetworkInfo();
        boolean isOnline = (activeConnection != null) && activeConnection.isConnected();
        NetworkInfo wifiInfo = connectivityManager.getNetworkInfo(connectivityManager.TYPE_WIFI);
        NetworkInfo dataInfo = connectivityManager.getNetworkInfo(connectivityManager.TYPE_MOBILE);

        if (isOnline) {
            connectedCheckbox.setChecked(true);
        } else {
            connectedCheckbox.setChecked(false);
        }

        if (wifiInfo.isConnected()) {
            //Log.Debug(TAG, "Wifi connected.");
            wifiCheckbox.setChecked(true);
        } else {
            //Log.Debug(TAG, "Wifi disconnected.");
            wifiCheckbox.setChecked(false);
        }

        if (dataInfo.isConnected()) {
            //Log.Debug(TAG, "Wifi connected.");
            dataCheckbox.setChecked(true);
        } else {
            //Log.Debug(TAG, "Wifi disconnected.");
            dataCheckbox.setChecked(false);
        }


    }
}
