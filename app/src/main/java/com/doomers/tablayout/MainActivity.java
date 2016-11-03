package com.doomers.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity implements OnTabSelectedListener{

        //This is our tablayout
        private TabLayout tabLayout;

        //This is our viewPager
        private ViewPager viewPager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Adding toolbar to the activity
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            //Initializing the tablayout
            tabLayout = (TabLayout) findViewById(R.id.tabLayout);

            //Adding the tabs using addTab() method
            tabLayout.addTab(tabLayout.newTab());
            tabLayout.addTab(tabLayout.newTab());
            tabLayout.addTab(tabLayout.newTab());
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            //Initializing viewPager
            viewPager = (ViewPager) findViewById(R.id.pager);

            //Creating our pager adapter
            Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

            //Adding adapter to pager
            viewPager.setAdapter(adapter);
              viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            //Adding onTabSelectedListener to swipe views
            tabLayout.addOnTabSelectedListener(this);
            for(int i = 0;i<tabLayout.getTabCount();i++){
                tabLayout.getTabAt(i).setIcon(R.drawable.ic_android_black_24dp);
            }

        }

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

