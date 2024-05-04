package com.example.cricinfo.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CskFragmentpageradapter extends FragmentPagerAdapter {
    private Context context;
    private List<String> titlelist = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    public CskFragmentpageradapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }

    public void addFragment(String title, Fragment fragment) {
        titlelist.add(title);
        fragmentList.add(fragment);
    }
}
