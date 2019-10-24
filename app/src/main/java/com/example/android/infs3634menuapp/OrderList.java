package com.example.android.infs3634menuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class OrderList extends AppCompatActivity {

    RecyclerView recyclerView;
    OrderListAdapter orderListAdapter;

    double orderTotal = 0;

    private static LinkedHashMap<String,Integer> orderList = new LinkedHashMap<>();

    static{
        orderList.put("Burger",0);
        orderList.put("Burger Junior",0);
        orderList.put("Burger Senior", 0);
        orderList.put("Small Fries",0);
        orderList.put("Medium Fries",0);
        orderList.put("Large Fries",0);
        orderList.put("Nugget Six Pack",0);
        orderList.put("Nugget 12 Pack",0);
        orderList.put("Onion Rings Six Pack",0);
        orderList.put("Onion Rings 12 Pack",0);
        orderList.put("Chicken Burger",0);
        orderList.put("Deluxe Chicken Burger",0);
        orderList.put("Vegan Burger",0);
        orderList.put("Vegan Burger Deluxe",0);
        orderList.put("Soft Serve",0);
    }

    public static void setItemQuantity(String itemName, int itemQuantiy){
        orderList.put(itemName,itemQuantiy);
    }

    public static int getItemQuantity(String itemName){
        return orderList.get(itemName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        TextView noItemsSelectedText = findViewById(R.id.noItemsSelectedTV);

        ArrayList<MenuItem> menuItems = MenuItemDatabase.getAllMenuItems();

        HashMap<String,Integer> orderListToDisplay = new HashMap<>();

        //For loop to add name of item, and quantity into the list to display

        for(int i=0;i<menuItems.size();i++){
            Log.d("MENUITEMSARRAY:",menuItems.get(i).getName());
            String itemName = menuItems.get(i).getName();
            if(orderList.get(itemName) > 0){
                orderListToDisplay.put(menuItems.get(i).getName(),orderList.get(itemName));
                Log.d("Added to order list:",menuItems.get(i).getName());
            }else{
            }
        }

        Log.d("ORDERLISTTODISPLAY76",orderListToDisplay.toString());

        ArrayList<String> orderListToDisplayNames = new ArrayList<>(orderListToDisplay.keySet());

        Log.d("SUSPECT",orderListToDisplayNames.toString());

        if(orderListToDisplay.size() == 0){
            Toast.makeText(this,"You have not added any menu items to your order!",Toast.LENGTH_LONG);

        }else {
            MenuItem tempMenuItem;
            double tempPrice;
            for(int i=0;i<orderListToDisplayNames.size();i++){
                tempMenuItem = MenuItemDatabase.getMenuItemByName(orderListToDisplayNames.get(i));
                tempPrice = tempMenuItem.getPrice();
                Log.d("Temp Price:",String.format("%.2f", tempPrice));
                orderTotal+= tempPrice * orderListToDisplay.get(orderListToDisplayNames.get(i));
            }

            noItemsSelectedText.setVisibility(View.INVISIBLE);
            recyclerView = findViewById(R.id.orderRecyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            Log.d("BEFORE OL TO DISPLAY:",orderListToDisplay.toString());
            orderListAdapter = new OrderListAdapter(this, orderListToDisplay);
            recyclerView.setAdapter(orderListAdapter);
        }

        TextView orderTotalTV = findViewById(R.id.orderTotalTV);

        Log.d("Order Total: ", String.format("%.2f",orderTotal));

        orderTotalTV.setText(String.format("%.2f",orderTotal));

    }

}
