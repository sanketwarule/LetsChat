package com.androsys.snkt.letschat.app;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androsys.snkt.letschat.R;
import com.androsys.snkt.letschat.chatlist.ChatListFragment;
import com.androsys.snkt.letschat.contactlist.ContactFragment;

import java.net.URISyntaxException;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = getClass().getSimpleName();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] pageTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_modified);
        initialization();
    }

    private void initialization() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.pager);

        pageTitle = getResources().getStringArray(R.array.title);


        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        tabPagerAdapter.addFragment(new ChatListFragment(), pageTitle[0]);
        tabPagerAdapter.addFragment(new ContactFragment(), pageTitle[1]);
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        try {
            LetsChat.getSocket().connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, " onStart");

        if (LetsChat.wasInBackground) {
            Toast.makeText(getApplicationContext(), "Application came to foreground", Toast.LENGTH_SHORT).show();
            LetsChat.wasInBackground = false;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LetsChat.disconnectSocket();
    }
}
