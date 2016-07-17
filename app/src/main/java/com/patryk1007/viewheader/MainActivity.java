package com.patryk1007.viewheader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPager();
    }

    private void initViewPager() {
        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        if (pager != null) {
            pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        }
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {

                case 0:
                    return PageFragment.newInstance("Frag1", "#00ff00");
                case 1:
                    return PageFragment.newInstance("Frag2", "#ff5050");
                case 2:
                    return PageFragment.newInstance("Frag3", "#ff9900");
                case 3:
                    return PageFragment.newInstance("Frag4", "#0066ff");
                case 4:
                    return PageFragment.newInstance("Frag5", "#cc33ff");
                default:
                    return PageFragment.newInstance("Frag6", "#ffff66");
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Title1";
                case 1:
                    return "Title2";
                case 2:
                    return "Title3";
                default:
                    return "Title default";

            }
        }

        @Override
        public int getCount() {
            return 5;
        }

    }
}
