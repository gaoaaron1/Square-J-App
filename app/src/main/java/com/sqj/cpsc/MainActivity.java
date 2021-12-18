package com.sqj.cpsc;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

//--------------------------- REQUEST FOR REST API ------------------------------//

        String URL="http://192.168.1.133:8000/api/employee/123456";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //JSON OBJECT REQUEST
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Rest Response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }

        );

        requestQueue.add(objectRequest);




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
        Intent i = new Intent(this, loginActivity2.class);
        startActivity(i);
    }






}
