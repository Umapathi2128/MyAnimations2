package com.example.myprojects;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.myprojects.Adapters.ListViewAdapter;
import com.example.myprojects.ModelClass.ListAdapters;

import java.util.ArrayList;
import java.util.Collections;

//import java.io.Serializable;

public class RecyclerViewMainActivity extends AppCompatActivity implements MyInterface,SwipeRefreshLayout.OnRefreshListener{

//    LinearLayout linearLayout;
    SwipeRefreshLayout layout;
    ArrayList<ListAdapters> list;
    RecyclerView recyclerView;
    ListViewAdapter adapter;
    MenuItem linearLayout;
    MenuItem linearLayout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        init();
        addToArrayList();

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ListViewAdapter(this,list,1);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new ListViewAdapter(this,list,1));


    }

    private void addToArrayList() {
        list=new ArrayList<>();
        list.add(new ListAdapters(this,R.drawable.img11,R.string.bird,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.img1,R.string.adam,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.img3,R.string.baby,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.img2,R.string.brothers,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.allu,R.string.crt_img11,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.pk,R.string.crt_img21,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.crt_img3,R.string.crt_img31,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.img5,R.string.crt_img41,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.mukundha,R.string.crt_img51,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.uma,R.string.crt_img61,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.f8,R.string.f8,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.img4,R.string.film,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.hangover,R.string.hangover,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.heaters,R.string.haters,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.bombay,R.string.jaws,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
        list.add(new ListAdapters(this,R.drawable.uma,R.string.the_eye,R.string.adam_gm,R.string.the_eye1,R.string.the_eye01,R.string.adam1));
    }

    public void init()
    {
        layout=findViewById(R.id.ll_layout);
        recyclerView=findViewById(R.id.recycler_view);
//        adapter=new ListViewAdapter(list);
//        layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//
//            }
//        });
        layout.setOnRefreshListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_resourefile,menu);
        return super.onCreateOptionsMenu(menu);

//        linearLayout1=menu.findItem(R.id.grid_view);
//        linearLayout=menu.findItem(R.id.list_view);
//        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        View parentLayout = findViewById(android.R.id.content);
       switch (item.getItemId())
       {
           case R.id.list_view:
//               Snackbar.make(parentLayout,"listview",Snackbar.LENGTH_LONG).setAction("yes", new View.OnClickListener() {
//                   @Override
//                   public void onClick(View view) {
//
//                   }
//               }).setActionTextColor(getResources().getColor(R.color.colorAccent)).show();

               RecyclerView.LayoutManager manager=new LinearLayoutManager(getApplicationContext());
               recyclerView.setLayoutManager(manager);
               recyclerView.setItemAnimator(new DefaultItemAnimator());
               recyclerView.setAdapter(new ListViewAdapter(this,list,0));


//               linearLayout.setVisibility(View.GONE);
//               linearLayout1.setVisibility(View.VISIBLE);
//               linearLayout1.setVisible(true);

//                adapter.notifyDataSetChanged();
               break;
           case R.id.grid_view:
//               Snackbar.make(parentLayout,"GridView",Snackbar.LENGTH_LONG).setAction("yes", new View.OnClickListener() {
//                   @Override
//                   public void onClick(View view) {
//
//                   }
//               }).setActionTextColor(getResources().getColor(R.color.colorAccent)).show();

//               DisplayMetrics displayMetrics = new DisplayMetrics();
//               getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//               int height = displayMetrics.heightPixels;
//               int width = displayMetrics.widthPixels;

//               linearLayout1.setVisible(false);
//               linearLayout.setVisible(true);
//               linearLayout.setVisibility(View.VISIBLE);
//               linearLayout1.setVisibility(View.GONE);

               RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),2);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(new ListViewAdapter(this,list,1));
//               adapter.notifyDataSetChanged();
               break;
           case R.id.settings:
               Snackbar.make(parentLayout,"settings", Snackbar.LENGTH_LONG).setAction("yes", new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                   }
               }).setActionTextColor(getResources().getColor(R.color.colorAccent)).show();
               break;
           case R.id.logout:
               Snackbar.make(parentLayout,"You want to Close the APPLICATION?", Snackbar.LENGTH_LONG).setAction("yes", new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                    finish();
                   }
               }).setActionTextColor(getResources().getColor(R.color.colorAccent)).show();
               break;
               default:break;
       }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getPosition(int position,View view) {
        try{
            Intent intent=new Intent(this,DisplayActivity.class);
            ActivityOptionsCompat optionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(this,view,"photo");
//            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//            getWindow().setEnterTransition(new Explode());
//            getWindow().setExitTransition(new Explode());
            intent.putExtra("array", list.get(position));
            startActivity(intent,optionsCompat.toBundle());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onRefresh() {
        Collections.shuffle(list);
        adapter.notifyDataSetChanged();
        layout.setRefreshing(false);
    }
}
