package com.example.finalstitch.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.finalstitch.Fragments.F1Fragment;
import com.example.finalstitch.Fragments.F2Fragment;
import com.example.finalstitch.Fragments.F3Fragment;
import com.example.finalstitch.Fragments.F4Fragment;
import com.example.finalstitch.Fragments.M1Fragment;

public class CustomViewPagerAdapter extends FragmentStatePagerAdapter {

    public CustomViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;

        if (position == 0) {
            fragment = new F1Fragment();
        } else if (position == 1) {
            fragment = new F2Fragment();
        }
        else if (position == 2) {
            fragment = new F3Fragment();
        }
        else if (position == 3) {
            fragment = new F4Fragment();
        }
        else {
            fragment = new M1Fragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        // return the number of your fragments,
        // we have 3 fragments
        return 3;
    }
}

