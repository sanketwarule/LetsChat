package com.androsys.snkt.letschat.app;

import android.app.Application;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class LetsChat extends Application {

    private static Socket socket;

    public static Socket getSocket() throws URISyntaxException {

        if (socket == null){
            socket = IO.socket("http://192.168.0.103:3000");
            return socket;
        } else if (socket != null) {
            return socket;
        }
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }
}
