package com.androsys.snkt.letschat;

import android.app.Application;
import android.widget.Spinner;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class LetsChat extends Application {

    private static Socket socket;

    public static Socket getSocket() throws URISyntaxException {

        if (socket == null){
            socket = IO.socket("http://192.168.43.218:4000");
            return socket;
        }
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            getSocket().connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
