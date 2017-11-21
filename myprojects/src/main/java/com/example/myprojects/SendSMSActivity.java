package com.example.myprojects;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMSActivity extends AppCompatActivity {

    EditText mobileno,message;
    Button sendsms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        mobileno = (EditText) findViewById(R.id.to_number);
        message = (EditText) findViewById(R.id.txtmsg);
        sendsms = (Button) findViewById(R.id.btn_send);

        //Performing action on button click
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, 1);
//            }
//            int result = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS);
//            if (result == 0) {
//            }
//            // function which uses the permission
//            else {
                sendsms.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        String no = mobileno.getText().toString();
                        String msg = message.getText().toString();

                        //Getting intent and PendingIntent instance


                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                        //Get the SmsManager instance and call the sendTextMessage method to send message
                        SmsManager sms = SmsManager.getDefault();
                        sms.sendTextMessage(no, null, msg, pi, null);

                        Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                                Toast.LENGTH_LONG).show();
                    }

                });
            }


        }
//    }

