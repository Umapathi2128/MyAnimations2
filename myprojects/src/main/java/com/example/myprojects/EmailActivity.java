package com.example.myprojects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by umapa on 11/21/2017.
 */

public class EmailActivity extends AppCompatActivity {
    EditText editTextTo,editTextSubject,editTextMessage;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        editTextTo=(EditText)findViewById(R.id.to_mail);
        editTextSubject=(EditText)findViewById(R.id.sub);
        editTextMessage=(EditText)findViewById(R.id.msg);

        send=(Button)findViewById(R.id.btn_send);

        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String to=editTextTo.getText().toString();
                String subject=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");
//                Toast.makeText(EmailActivity.this,"Email sent"+emai,Toast.LENGTH_LONG).show();

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }

        });
    }


}
