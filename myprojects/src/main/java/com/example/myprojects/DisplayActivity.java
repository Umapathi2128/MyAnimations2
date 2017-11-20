package com.example.myprojects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myprojects.ModelClass.ListAdapters;

public class DisplayActivity extends AppCompatActivity {

    ListAdapters list;
//    int position;
    private TextView mName,mEmail,mAge,mPhone,mAddress;
    ImageView mProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

//        position=getIntent().getExtras().getInt("value");
//        list=(ArrayList<ListAdapters>)getIntent().getExtras().getSerializable("array");
        Intent intent=getIntent();
        if (intent!=null)
        {
            list= (ListAdapters) getIntent().getExtras().getSerializable("array");
        }

        init();

    }

    public void init()
    {

                    mName= findViewById(R.id.tv_name1);
                    mPhone= findViewById(R.id.tv_phone1);
                    mEmail= findViewById(R.id.tv_email1);
                    mAddress=findViewById(R.id.tv_address1);
                    mAge=findViewById(R.id.tv_age1);
                    mProfile=findViewById(R.id.img_profile1);



                    mName.setText(list.getNAME());
                    mAge.setText(list.getAGE());
                    mEmail.setText(list.getEMAIL());
                    mAddress.setText(list.getADDRESS());
                    mPhone.setText(list.getPHONE());
                    mProfile.setBackgroundResource(list.getIMAGE());


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
