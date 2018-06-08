package com.androsys.snkt.letschat;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.androsys.snkt.letschat.model.Chat;

public class ChatActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();
    private Chat chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        ChatFragment chatFragment = new ChatFragment();
        fragmentTransaction.replace(R.id.fragcontainer, chatFragment);
        Bundle extras = getIntent().getExtras();
        fragmentTransaction.commit();
        if (extras != null) {
            chat = (Chat) extras.getSerializable("chat");
            Log.d(TAG, "chat " + chat.getShubhNaam());
        }
    }
}
