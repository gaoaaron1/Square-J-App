package com.sqj.cpsc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sqj.cpsc.adapter.ItemAdapter;
import com.sqj.cpsc.model.Category;

import java.util.ArrayList;
import java.util.List;

import static com.sqj.cpsc.R.drawable.*;

public class CustomerActivity extends AppCompatActivity {

    RecyclerView categoryRecyclerView;

    ItemAdapter categoryAdapter;
    List<Category> categoryList;


    TextView allCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);

        //--------------------------------- SET ID -----------------------------------------------------//

        ImageView homeJ = findViewById(R.id.homeJ);

        //--------------------------------- BUTTON ----------------------------------------------------------//

        homeJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CustomerActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inn = new Intent(CustomerActivity.this, AllCategory.class);
                startActivity(inn);
            }
        });

        // adding data to model
        categoryList = new ArrayList<>();

        categoryList.add(new Category(1, ic_home_fruits));
        categoryList.add(new Category(2, ic_home_fish));
        categoryList.add(new Category(3, ic_home_meats));
        categoryList.add(new Category(4, ic_home_veggies));
        categoryList.add(new Category(5, ic_home_fruits));
        categoryList.add(new Category(6, ic_home_fish));
        categoryList.add(new Category(7, ic_home_meats));
        categoryList.add(new Category(8, ic_home_veggies));

        setCategoryRecycler(categoryList);

    }



    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new ItemAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

}
