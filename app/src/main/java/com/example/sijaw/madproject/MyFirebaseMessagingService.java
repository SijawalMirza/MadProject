package com.example.sijaw.madproject;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by sijaw on 12/11/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String SENDER_ID = "MyId";
    public final String TAG = "Mytag";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
        NotificationCompat.Builder compat = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.mypic)
                .setContentText(remoteMessage.getNotification().getBody())
                .setContentTitle("FireBase Message");

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, compat.build());


    }


}