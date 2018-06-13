package com.androsys.snkt.letschat.chat;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androsys.snkt.letschat.R;
import com.androsys.snkt.letschat.app.LetsChat;
import com.androsys.snkt.letschat.chatlist.Chat;
import com.androsys.snkt.letschat.contactlist.Contact;

public class ChatActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();
    ImageView avtaarAB;
    private TextView shubhaNaamAB, onlineStatusAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ActionBar actionBar = getSupportActionBar();
        // add the custom view to the action bar
        actionBar.setCustomView(R.layout.actionbar_view);
        shubhaNaamAB = actionBar.getCustomView().findViewById(R.id.shubhanaamChatActionBar);
        onlineStatusAB = actionBar.getCustomView().findViewById(R.id.onlineStatus);
        avtaarAB = actionBar.getCustomView().findViewById(R.id.avtarChatActionBar);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
                | ActionBar.DISPLAY_SHOW_HOME);


        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        ChatFragment chatFragment = new ChatFragment();
        fragmentTransaction.replace(R.id.fragcontainer, chatFragment);
        Bundle extras = getIntent().getExtras();
        fragmentTransaction.commit();
        if (extras != null) {
            if (extras.containsKey("chat")) {

                Chat chat = (Chat) extras.getSerializable("chat");
                Log.d(TAG, "chat " + chat.getShubhNaam());
                if (chat.getAvtar() != null) {
                    avtaarAB.setImageBitmap(chat.getAvtar());
                } else {
                    avtaarAB.setImageResource(R.mipmap.ic_launcher_round);
                }
                shubhaNaamAB.setText(chat.getShubhNaam());
            } else if (extras.containsKey("contact")) {

                Contact contact = (Contact) extras.getSerializable("contact");
                Log.d(TAG, "contact " + contact.getShubhnaam());
                if (contact.getAvtar() != null) {
                    avtaarAB.setImageBitmap(contact.getAvtar());
                } else {
                    avtaarAB.setImageResource(R.mipmap.ic_launcher_round);
                }
                shubhaNaamAB.setText(contact.getShubhnaam());
            }

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, " onStart");

        if (LetsChat.wasInBackground) {
            Toast.makeText(getApplicationContext(), "Application came to foreground", Toast.LENGTH_LONG).show();
            LetsChat.wasInBackground = false;

        }
    }
}
