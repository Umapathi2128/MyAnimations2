package com.example.umapa.myanimations2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.CubeInTransformer;
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.ToxicBakery.viewpager.transforms.ScaleInOutTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.ToxicBakery.viewpager.transforms.TabletTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer;
import com.example.umapa.myanimations2.Adapters.AdapterFragments;
import com.example.umapa.myanimations2.Adapters.ListFragments;
import com.example.umapa.myanimations2.Fragments.Fragment1;
import com.example.umapa.myanimations2.Fragments.Fragment2;
import com.example.umapa.myanimations2.Fragments.Fragment3;
import com.example.umapa.myanimations2.Fragments.Fragment4;
import com.example.umapa.myanimations2.Fragments.Fragment5;
import com.example.umapa.myanimations2.Fragments.Fragment6;
import com.example.umapa.myanimations2.Fragments.ListFragment;
import com.example.umapa.myanimations2.Fragments.WidgetsFragment;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ListFragment.OnFragmentInteractionListener,
        Fragment2.OnFragmentInteractionListener, Fragment1.OnFragmentInteractionListener,Fragment4.OnFragmentInteractionListener,
        Fragment3.OnFragmentInteractionListener,Fragment5.OnFragmentInteractionListener,Fragment6.OnFragmentInteractionListener
        ,Animation.AnimationListener,AdapterView.OnItemSelectedListener,View.OnClickListener {
    RelativeLayout content_layout;
    //    ViewPager viewPager;
    TextView f1TextView1, f1TextView2, f1TextView3, ls_textview;
    ArrayList listview_list, viewpager_list;
    ViewPager viewPager;
    AdapterFragments adapterFragments;
    Animation animation;
    ListView listView;
    Button apply;
    ArrayList animList;
    String animationList[] = {"Fade_in", "Fade_out", "Blink", "Rotate", "Zoom_in","zoom_out"};
    ArrayList widgetList;
    LinearLayout linearLayout;
    int animationSelectedItem;
    Spinner spinner;
    GifImageView gifImageView;
    LinearLayout gif_layout;
    boolean isListView = true, isViewPager = true,isWidgets=true;

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        init();
        setFragments();
        setClickListeners();
        addingAdapeters(animationList);
        spinner.setVisibility(View.GONE);
//    viewPagerAnimations();


    }
    /*
    *  all inititlizations are done here....
     */

    public void init() {
        f1TextView1 = findViewById(R.id.f1textview);
        f1TextView2 = findViewById(R.id.f2textview);
        f1TextView3 = findViewById(R.id.f3textview);
        viewPager = findViewById(R.id.view_pager);
        listView = findViewById(R.id.lstview);
        linearLayout=findViewById(R.id.widgets);
        gifImageView= (GifImageView) findViewById(R.id.gif);
        spinner= findViewById(R.id.spin);

        animList = new ArrayList();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    /*
    *  In this method all Array_list and ViewPager are added here....
     */
    public void setFragments() {
        listview_list = new ArrayList();
        listview_list.add(new ListFragment());
        listview_list.add(new ListFragment());
        listview_list.add(new ListFragment());
        listview_list.add(new ListFragment());
        listview_list.add(new ListFragment());
        listview_list.add(new ListFragment());
        listview_list.add(new ListFragment());
        listview_list.add(new ListFragment());
        listview_list.add(new ListFragment());

        viewpager_list = new ArrayList();

        viewpager_list.add(new Fragment1());
        viewpager_list.add(new Fragment2());
        viewpager_list.add(new Fragment3());
        viewpager_list.add(new Fragment4());
        viewpager_list.add(new Fragment5());
        viewpager_list.add(new Fragment6());
        viewpager_list.add(new Fragment1());
        viewpager_list.add(new Fragment2());
        viewpager_list.add(new Fragment3());


        animList.add(R.anim.fade_in);
        animList.add(R.anim.fade_out);
        animList.add(R.anim.blink);
        animList.add(R.anim.rotate);
        animList.add(R.anim.zoom_in);
        animList.add(R.anim.zoom_out);
    }

    // All click Listeners will done here...

    public void setClickListeners() {
//        apply.setOnClickListener(this);
    }

    /*
    * Spiner adapter is done here....
     */
    public void addingAdapeters( String animationList1[]) {


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, animationList1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Select Animation");
        spinner.setOnItemSelectedListener(this);


    }

       @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        String[] names={"RotateUpTransformer","CubeInTransformation","ScaleInOutTransformer","BackgroundToForegroundTransformer",
                "StackTransformer","TabletTransformer","ZoomInTransformer",
                "CubeOutTransformation","AccordionTransformer"};
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_list:
                addingAdapeters(animationList);
                viewPager.setVisibility(View.GONE);
                gifImageView.setVisibility(View.GONE);
//                Toast.makeText(this, "check", Toast.LENGTH_LONG).show();
                adapterFragments = new AdapterFragments(this, listview_list);

                listView.setAdapter(adapterFragments);
                listView.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.VISIBLE);

                break;
            case R.id.nav_gallery:
                gifImageView.setVisibility(View.GONE);
                listView.setVisibility(View.GONE);
                addingAdapeters(names);
//                viewPager.removeAllViews()

//                Toast.makeText(this, "check", Toast.LENGTH_LONG).show();
//                adapterFragments=new AdapterFragments(this,viewpager_list);
//               viewPager.setAdapter(adapterFragments);
//                adapterFragments=new AdapterFragments(this,viewpager_list);
//                viewPager.setAdapter(adapterFragments);
                ListFragments listFragment = new ListFragments(getSupportFragmentManager(), viewpager_list);
                viewPager.setAdapter(listFragment);
                viewPager.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.VISIBLE);

                break;
            case R.id.nav_img:
                listView.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
                gifImageView.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.GONE);
                break;


//            case R.id.nav_img:
//                listView.setVisibility(View.GONE);
//                viewPager.setVisibility(View.GONE);
//                LayoutInflater layoutInflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//                View view=layoutInflater.inflate(R.layout.fragment_widgets,null,false);
//                linearLayout.addView(view);
//                linearLayout.setVisibility(View.VISIBLE);
//                break;



        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
    /*
    *
    *   All animations methods are implemented here...
    *
     */
    //this method for fade_in animation....

    public void fade_inAnimation(View view) {
        this.view = view;
        animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        view.startAnimation(animation);

    }

    //this method for FADE_OUT animation....
    public void fade_outAnimation(View view) {
        this.view = view;
        animation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        view.startAnimation(animation);
        animation.setAnimationListener(this);

    }

    //this method for  BLINK animation....

    public void blink_Animation(View view) {
        this.view = view;
        animation = AnimationUtils.loadAnimation(this, R.anim.blink);
        view.startAnimation(animation);
        animation.setAnimationListener(this);

    }
    //this method for ROTATE animation....

    public void rotate_Animation(View view) {
        this.view = view;
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        view.startAnimation(animation);
        animation.setAnimationListener(this);

    }
    //this method for ZOOM_IN animation....

    public void zoom_inAnimation(View view) {
        this.view = view;
        animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        view.startAnimation(animation);
        animation.setAnimationListener(this);

    }
    //this method for ZOOM_OUT animation....

    public void zoom_outAnimation(View view) {
        this.view = view;
        animation = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        view.startAnimation(animation);
        animation.setAnimationListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        Spinner spinner=findViewById(R.id.spin);
        animationSelectedItem = i;
//        Toast.makeText(this,animationSelectedItem,Toast.LENGTH_LONG).show();
        switch (i) {
            case 0:
               animationProvider(R.anim.fade_in);
               animationProvider3(R.anim.fade_in);
               animationProvider2();
                break;
            case 1:
               animationProvider(R.anim.fade_out);
               animationProvider3(R.anim.fade_out);
               animationProvider2();
                break;
            case 2:
                animationProvider(R.anim.blink);
                animationProvider3(R.anim.blink);
                animationProvider2();
////                blink_Animation(listView);
////                blink_Animation(viewPager);
//                animation = AnimationUtils.loadAnimation(this, R.anim.blink);
//                viewPager.startAnimation(animation);
//                animation.setAnimationListener(this);
                break;
            case 3:
                animationProvider(R.anim.rotate);
                animationProvider3(R.anim.rotate);
                animationProvider2();
//                rotate_Animation(listView);
//                rotate_Animation(viewPager);
                break;
            case 4:
                animationProvider(R.anim.zoom_in);
                animationProvider3(R.anim.zoom_in);
                animationProvider2();
//                zoom_inAnimation(listView);
//                zoom_inAnimation(viewPager);
                break;
            case 5:
                animationProvider(R.anim.zoom_out);
                animationProvider3(R.anim.zoom_out);
                animationProvider2();
//                zoom_outAnimation(listView);
//                zoom_outAnimation(viewPager);
                break;
            case 6:
                animationProvider(R.anim.zoom_out);
                animationProvider3(R.anim.zoom_out);
                animationProvider2();
//                zoom_outAnimation(listView);
//                zoom_outAnimation(viewPager);
                break;
            case 7:
                animationProvider(R.anim.zoom_out);
                animationProvider3(R.anim.zoom_out);
                animationProvider2();
//                zoom_outAnimation(listView);
//                zoom_outAnimation(viewPager);
                break;
            case 8:
                animationProvider(R.anim.zoom_out);
                animationProvider3(R.anim.zoom_out);
                animationProvider2();
//                zoom_outAnimation(listView);
//                zoom_outAnimation(viewPager);
                break;
            case 9:
                animationProvider(R.anim.zoom_out);
                animationProvider3(R.anim.zoom_out);
                animationProvider2();
//                zoom_outAnimation(listView);
//                zoom_outAnimation(viewPager);
                break;
            default:
                break;
        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
//        animation= AnimationUtils.loadAnimation(this,R.anim.rotate);
//        viewPager.startAnimation(animation);
//        animation.setAnimationListener(this);

    }

    /*
    *
    * This method for listview Animations....
     */
    public void animationProvider(int efffect)
    {
        LayoutAnimationController controller=new LayoutAnimationController(AnimationUtils.loadAnimation(getApplicationContext(),
                efffect),0.5f);
        listView.setLayoutAnimation(controller);
        listView.startLayoutAnimation();
    }
    /*
   *
   * This method for listview Animations....
    */
    public void animationProvider3(int efffect)
    {
        LayoutAnimationController controller=new LayoutAnimationController(AnimationUtils.loadAnimation(getApplicationContext(),
                efffect),0.5f);
        linearLayout.setLayoutAnimation(controller);
        linearLayout.startLayoutAnimation();
    }

    /*
    *
    * This method for ViewPager Animations....
     */
    public void animationProvider2()
    {

       switch (animationSelectedItem)
       {
           case 0:
//               viewPager.setPageTransformer(true,new ViewPager.PageTransformer() {
//                   @Override
//                   public void transformPage(@NonNull View view, float position)
//                   {
//                       final float width = view.getWidth();
//                       float ROT_MOD = -15f;
//                       final float rotation = ROT_MOD * position;
//
//                       view.setPivotX(width * 0.5f);
//                       view.setPivotY(0f);
//                       view.setTranslationX(0f);
//                       view.setRotation(rotation);
//                   }
//               });
               viewPager.setPageTransformer(true,new RotateUpTransformer());
               break;


           case 1:
//               viewPager.setPageTransformer(true,new ViewPager.PageTransformer() {
//                   @Override
//                   public void transformPage(@NonNull View view, float position)
//                   {
//                       final float rotation = 180f * position;
//
//                       view.setVisibility(rotation > 90f || rotation < -90f ? View.INVISIBLE : View.VISIBLE);
//                       view.setPivotX(view.getWidth() * 0.5f);
//                       view.setPivotY(view.getHeight() * 0.5f);
//                       view.setRotationY(rotation);
//                   }
//               });
               viewPager.setPageTransformer(true,new CubeInTransformer());
               break;

           case 2:
//               viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
//                   @Override
//                   public void transformPage(View view, float position) {
//                       view.setTranslationX(position < 0 ? 0f : -view.getWidth() * position);
//                   }
//               });
               viewPager.setPageTransformer(true,new ScaleInOutTransformer());
               break;
           case 3:
//               viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
//                   @Override
//                   public void transformPage(View view, float position) {
//                       final float height = view.getHeight();
//                       final float width = view.getWidth();
//                       final float scale = min(position < 0 ? 1f : Math.abs(1f - position), 0.5f);
//
//                       view.setScaleX(scale);
//                       view.setScaleY(scale);
//                       view.setPivotX(width * 0.5f);
//                       view.setPivotY(height * 0.5f);
//                       view.setTranslationX(position < 0 ? width * position : -width * position * 0.25f);
//                   }
//               });
               viewPager.setPageTransformer(true,new BackgroundToForegroundTransformer());
               break;
           case 4:

//               viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
//                   @Override
//                   public void transformPage(View view, float position) {
//                       int pageWidth = view.getWidth();
//
//
//                       if (position <=0) { // [-Infinity,-1)
//                           // This page is way off-screen to the left.
//                           view.setAlpha(1);
//
//
//                       } else if (position == 1) { // [-1,1]
//
//                           view.setTranslationX(-position * (pageWidth)); //Half the normal speed
//
//                       } else { // (1,+Infinity]
//                           // This page is way off-screen to the right.
//                           view.setAlpha(1);
//
//                       }
//                   }
//               });
               viewPager.setPageTransformer(true,new StackTransformer());
               break;
           case 5:
//               viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
//                   @Override
//                   public void transformPage(View view, float position) {
//                       float ROT_MOD = -15f;
//                       final float width = view.getWidth();
//                       final float height = view.getHeight();
//                       final float rotation = ROT_MOD * position * -1.25f;
//
//                       view.setPivotX(width * 0.5f);
//                       view.setPivotY(height);
//                       view.setRotation(rotation);
//                   }
//               });
               viewPager.setPageTransformer(true,new TabletTransformer());
               break;
           case 6:

//               viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
//                   @Override
//                   public void transformPage(View view, float position) {
//                       final float height = view.getHeight();
//                       final float width = view.getWidth();
//                       final float scale = min(position < 0 ? 1f : Math.abs(1f - position), 0.5f);
//
//                       view.setScaleX(scale);
//                       view.setScaleY(scale);
//                       view.setPivotX(width * 0.5f);
//                       view.setPivotY(height * 0.5f);
//                       view.setTranslationX(position < 0 ? width * position : -width * position * 0.25f);
//                   }
//               });
               viewPager.setPageTransformer(true,new ZoomInTransformer());
               break;
           case 7:
//               viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
//                   @Override
//                   public void transformPage(View view, float position) {
//
//                       final float scale = 1f + Math.abs(position);
//                       view.setScaleX(scale);
//                       view.setScaleY(scale);
//                       view.setPivotX(view.getWidth() * 0.5f);
//                       view.setPivotY(view.getHeight() * 0.5f);
//                       view.setAlpha(position < -1f || position > 1f ? 0f : 1f - (scale - 1f));
//                       if(position == -1){
//                           view.setTranslationX(view.getWidth() * -1);
//                   }
//                  }
//               });
               viewPager.setPageTransformer(true,new CubeOutTransformer());
               break;
           case 8:
//               viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
//                   @Override
//                   public void transformPage(View view, float position) {
//                       int pageWidth = view.getWidth();
//
//
//                       if (position <=0) { // [-Infinity,-1)
//                           // This page is way off-screen to the left.
//                           view.setAlpha(1);
//
//                       } else if (position == 1) { // [-1,1]
//
//                           view.setTranslationX(-position * (pageWidth / 2)); //Half the normal speed
//
//                       } else { // (1,+Infinity]
//                           // This page is way off-screen to the right.
//                           view.setAlpha(1);
//                       }
//                   }
//               });
               viewPager.setPageTransformer(true,new AccordionTransformer());
               break;


       }

    }
    private static final float min(float val, float min) {
        return val < min ? min : val;
    }
}

