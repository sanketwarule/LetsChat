package com.androsys.snkt.letschat;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] pageTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initialization();

    }

    private void initialization() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.pager);

        pageTitle = getResources().getStringArray(R.array.title);




        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        tabPagerAdapter.addFragment(new ChatListFragment() , pageTitle[0]);
        tabPagerAdapter.addFragment(new ContactFragment() , pageTitle[1]);
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){



        }
    }
}
