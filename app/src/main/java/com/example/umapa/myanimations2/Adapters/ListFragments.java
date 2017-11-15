package com.example.umapa.myanimations2.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by umapa on 11/15/2017.
 */

public class ListFragments extends FragmentPagerAdapter {

    ArrayList list;
    public ListFragments(FragmentManager fm,ArrayList list) {
        super(fm);
        this.list=list;

    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
