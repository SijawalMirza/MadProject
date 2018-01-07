package com.example.sijaw.madproject.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sijaw.madproject.MyFirebaseMessagingService;
import com.example.sijaw.madproject.R;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startService(new Intent(this,MyFirebaseMessagingService.class));
        PusherOptions options = new PusherOptions();
        options.setCluster("APP_CLUSTER");

        Pusher pusher = new Pusher("APP_KEY", options);

        Channel channel = pusher.subscribe("my-channel");

        channel.bind("my-event", new SubscriptionEventListener() {
            @Override
            public void onEvent(String channelName, String eventName, final String data) {
                System.out.println(data);
            }
        });

        pusher.connect();



        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        },1000);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
