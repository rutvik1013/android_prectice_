package com.example.tablayout;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_adapter extends FragmentPagerAdapter
{
    private List<String>titlelist=new ArrayList<>();
    private List<Fragment>fragmentslist=new ArrayList<>();


    public Fragment_adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentslist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentslist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }
    void addtitle(String title,Fragment fragment){
        titlelist.add(title);
        fragmentslist.add(fragment);
    }
}
