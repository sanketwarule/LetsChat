package com.androsys.snkt.letschat.chat;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.androsys.snkt.letschat.R;
import com.androsys.snkt.letschat.chatlist.Chat;
import com.androsys.snkt.letschat.contactlist.Contact;

public class ChatActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();

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
            if (extras.containsKey("chat")) {

                Chat chat = (Chat) extras.getSerializable("chat");
                Log.d(TAG, "chat " + chat.getShubhNaam());
            } else if (extras.containsKey("contact")) {

                Contact contact = (Contact) extras.getSerializable("contact");
                Log.d(TAG, "contact " + contact.getShubhnaam());
            }

        }
    }
}
