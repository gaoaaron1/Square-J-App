package com.sqj.cpsc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {

    //Global Variables for username and password
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Retrieve from our activity_login.xml file.
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        Button loginbtn = (Button) findViewById(R.id.loginbtn);
        ImageView sqjlogo = (ImageView) findViewById(R.id.sqjlogo);


        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(loginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                openCustomerActivity();
            }
        });

        sqjlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }


    //Opens customer page
    public void openCustomerActivity() {

        //Convert our usernames to string for our background check
        String user = username.getText().toString();
        String pass = password.getText().toString();

        //Execute using background for our xampp connection
        background bg = new background(this);
        bg.execute(user, pass);

        //Used to scroll into customer activity.
        Intent i = new Intent(this, CustomerActivity.class);
        startActivity(i);
    }




}
