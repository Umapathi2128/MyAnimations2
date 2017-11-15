package com.example.umapa.myanimations2.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.view.LayoutInflater;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.umapa.myanimations2.R;

import java.util.ArrayList;

/**
 * Created by umapa on 11/14/2017.
 */

public class AdapterFragments extends BaseAdapter
{
    Context context;
    ArrayList list;
    public AdapterFragments(Context context,ArrayList list) {

        this.list=list;
        this.context=context;
    }

//    @Override
//    public Fragment getItem(int position) {
//        return (Fragment) list.get(position);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
////        LayoutInflater inflater =getA.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////        LayoutInflater layoutInflater=getActivity.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        return view;
//    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(R.layout.custom_listview,viewGroup,false);
        return view;
    }




}
