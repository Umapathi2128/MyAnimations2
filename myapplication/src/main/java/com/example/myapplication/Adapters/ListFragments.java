package com.example.myapplication.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * Created by umapa on 11/15/2017.
 */

public class ListFragments extends BaseAdapter {

    ArrayList<String> list;
    Context context;
    LayoutInflater inflater;

 public ListFragments(Context context,ArrayList<String> list)
 {
//     this.context=context;
     inflater=LayoutInflater.from(context);
     this.list=list;
 }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

     view=inflater.inflate(R.layout.custom_listview,viewGroup,false);
        @SuppressLint("WrongViewCast") TextView textView=view.findViewById(R.id.tv_list);
        textView.setText(list.get(i));
        return view;
    }
}
