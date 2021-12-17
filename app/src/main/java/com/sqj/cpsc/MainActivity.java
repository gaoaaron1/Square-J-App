package com.sqj.cpsc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//--------------------------------- CUSTOMER BUTTON -----------------------------------------------------//

        ImageView customerbtn = findViewById(R.id.customerbtn);

        //customer button
        customerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomerLogin();
            }
        });


//--------------------------------- STAFF BUTTON -----------------------------------------------------//

        ImageView staffbtn = findViewById(R.id.staffbtn);

        //customer button
        staffbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStaffLogin();
            }
        });
//------------------------------ END OF FUNCTION ----------------------------------------//
    }



    //Opens customer page
    public void openCustomerLogin() {
        Intent i = new Intent(this, loginActivity.class);
        startActivity(i);
    }

    //Opens staff page
    public void openStaffLogin() {
        Intent i = new Intent(this, loginActivity.class);
        startActivity(i);
    }






}
