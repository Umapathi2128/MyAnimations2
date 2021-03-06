package com.example.myapplication.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.myapplication.Adapters.ListFragments;
import com.example.myapplication.R;

import java.util.ArrayList;

//import com.example.myprojects.R;

//import com.example.umapa.myanimations2.R;


public class ListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    Spinner spinner;
    View view;

    ArrayList<String> list;

    private OnFragmentInteractionListener mListener;

    public ListFragment() {
        // Required empty public constructor
    }


    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

        list=new ArrayList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.custom_listview,container,false);
        ListView listView=view.findViewById(R.id.lv_lsfragment);
        list.add("Compindia");
        list.add("Android");
        list.add("IOS Team");
        list.add("Tiupathi");
        list.add("Chittor");
        list.add("Chennai");
        list.add("Bangloor");
        list.add("Hyderabad");
        list.add("Moto G5 Plus");
        list.add("Gionee");
        list.add("Samsung");
        list.add("Nokia ");
        list.add("Lenovo");
        list.add("Activities");
        list.add("Fragments");
        list.add("Components");
        list.add("BroadCast Receivers");
        list.add("Services");
        list.add("Some Thing");
        listView.setAdapter(new ListFragments(getActivity(),list));
        return view;
//        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
