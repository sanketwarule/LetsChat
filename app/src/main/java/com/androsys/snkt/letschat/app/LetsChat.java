package com.androsys.snkt.letschat.app;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class LetsChat extends Application implements Application.ActivityLifecycleCallbacks {


    public static String stateOfLifeCycle = "";
    public static boolean wasInBackground = false;
    private static Socket socket = null;
    ScreenOffReceiver screenOffReceiver = new ScreenOffReceiver();
    private String TAG = getClass().getSimpleName();

    public static Socket getSocket() throws URISyntaxException {

        if (socket == null){
            socket = IO.socket("http://192.168.0.114:3000");
        }
        return socket;
    }

    public static boolean disconnectSocket() {

        if (socket != null) {
            socket = null;
            return true;
        }
        return false;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        registerActivityLifecycleCallbacks(this);
        registerReceiver(screenOffReceiver, new IntentFilter("android.intent.action.SCREEN_OFF"));

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "onTerminate");

    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated");

        wasInBackground = false;
        stateOfLifeCycle = "Create";

    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.d(TAG, "onActivityStarted");
        stateOfLifeCycle = "Start";

    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.d(TAG, "onActivityResumed");
        stateOfLifeCycle = "Resume";

    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.d(TAG, "onActivityPaused");
        stateOfLifeCycle = "Pause";

    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.d(TAG, "onActivityStopped");
        stateOfLifeCycle = "Stop";

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.d(TAG, "onActivitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.d(TAG, "onActivityDestroyed");
        wasInBackground = false;
        stateOfLifeCycle = "Destroy";

    }

    @Override
    public void onTrimMemory(int level) {
        if (stateOfLifeCycle.equals("Stop")) {
            wasInBackground = true;
        }
        super.onTrimMemory(level);
    }


    class ScreenOffReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            wasInBackground = true;
        }
    }

}
