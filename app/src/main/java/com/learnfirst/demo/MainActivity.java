package com.learnfirst.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.learnfirst.demo.fragments.CatFragment;
import com.learnfirst.demo.fragments.DetailsFragment;
import com.learnfirst.demo.fragments.MyFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments = new ArrayList<>();
        fragments.add(new CatFragment());
        fragments.add(new MyFragment());
        fragments.add(new DetailsFragment());
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new NewAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(1,true);


    }

    private class NewAdapter extends FragmentStatePagerAdapter {

        public NewAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public Fragment getItem(int i) {

            return fragments.get(i);
        }


    }

}
