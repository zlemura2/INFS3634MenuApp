package com.example.android.infs3634menuapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemDetail extends AppCompatActivity {

    String itemNameHolder;
    ArrayList<MenuItem> menuList = MenuItemDatabase.getAllMenuItems();
    MenuItem thisItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        ImageView itemImage = findViewById(R.id.itemImageD);
        final TextView itemName = findViewById(R.id.itemNameD);
        TextView itemPrice = findViewById(R.id.itemPriceD);
        TextView itemDecrease = findViewById(R.id.itemDecrease);
        TextView itemIncrease = findViewById(R.id.itemIncrease);
        final TextView itemQuantity = findViewById(R.id.itemQuantityD);
        TextView itemDescription = findViewById(R.id.itemDescriptionD);
        Button itemAddBtn = findViewById(R.id.itemAddBtn);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        itemNameHolder = extras.getString("Item Name");

        for(int i=0;i<menuList.size();i++){
            if(menuList.get(i).getName().equals(itemNameHolder)){
                thisItem = menuList.get(i);
                break;
            }else {
                continue;
            }
        }

        //Image Handler
        itemImage.setImageResource(getResources().getIdentifier(thisItem.getName().replaceAll("\\s+", "_").toLowerCase(),
                "drawable", getPackageName()));
        //itemName
        itemName.setText(thisItem.getName());
        //itemPrice
        itemPrice.setText("$" + String.format("%.2f",thisItem.getPrice()) + " each");
        //itemDecrease
        itemDecrease.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int currentQuantity = Integer.parseInt(itemQuantity.getText().toString());
                if(currentQuantity == 0){
                }else{
                    itemQuantity.setText(String.valueOf(currentQuantity-1));
                }
            }
        });
        itemIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentQuantity = Integer.parseInt(itemQuantity.getText().toString());
                itemQuantity.setText(String.valueOf(currentQuantity+1));
            }
        });
        //itemDescription
        itemDescription.setText(thisItem.getDescription());

        //itemAddBtn
        itemAddBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int itemQuantityToAdd = Integer.parseInt(itemQuantity.getText().toString());
                if(itemQuantityToAdd>=1){
                    OrderList.setItemQuantity(itemName.getText().toString(),
                            OrderList.getItemQuantity(itemName.getText().toString()) +
                                    Integer.parseInt(itemQuantity.getText().toString()));
                    Toast.makeText(getApplicationContext(),"Item added to your order",Toast.LENGTH_LONG).show();
                    Log.d("Item Quantity:", String.valueOf(OrderList.getItemQuantity(itemName.getText().toString())));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please increase the quantity for this item to at least one",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
