package com.example.android.infs3634menuapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MenuItem> menuItemList;
    RecyclerView recyclerView;
    MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuItemList = MenuItemDatabase.getAllMenuItems();

        recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuAdapter = new MenuAdapter(this, menuItemList);
        recyclerView.setAdapter(menuAdapter);
        int itemViewType = 0;
        recyclerView.getRecycledViewPool().setMaxRecycledViews(itemViewType, 0);

        Button viewOrderBtn = findViewById(R.id.viewOrderBtn);
        viewOrderBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),OrderList.class);
                Context context = v.getContext();
                context.startActivity(intent);
            }
        });
    }
}
