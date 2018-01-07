package com.example.sijaw.madproject.BroadcastReciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by sijaw on 11/30/2017.
 */

public class MyReceiver extends BroadcastReceiver {
    String TAG="Mtag";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: "+intent.getBooleanExtra("state",false));

    }
}
