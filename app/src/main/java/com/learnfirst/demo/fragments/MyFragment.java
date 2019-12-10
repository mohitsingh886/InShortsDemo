package com.learnfirst.demo.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learnfirst.demo.CustomViewPager;
import com.learnfirst.demo.R;

public class MyFragment extends Fragment {

    public int number = 0;
    private Activity mActivity;
    private CustomViewPager viewPager;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.container_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = (CustomViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new NewAdapter(getChildFragmentManager()));


    }

    private class NewAdapter extends FragmentPagerAdapter {

        public NewAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Fragment getItem(int i) {

            return new PostFragment();
        }


    }
}
