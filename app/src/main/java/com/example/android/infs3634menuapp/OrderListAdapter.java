package com.example.android.infs3634menuapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static android.view.View.*;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    private HashMap<String, Integer> orderItemList;
    Context context;

    private ArrayList<String> orderItemNames;

    OrderListAdapter(Context context, HashMap<String, Integer> orderItemList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.orderItemList = orderItemList;
        orderItemNames= new ArrayList<>(orderItemList.keySet());
        this.context=context;
    }

    @NonNull
    @Override
    public OrderListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.chunkorder, viewGroup, false);
        return new OrderListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.listPos = i;

        Log.d("ORDER ITEM LSIT",orderItemList.keySet().toString());
        Log.d("ORDER ITEM NAMES:",orderItemNames.toString());

        Log.d("ITEM ADDING TO LIST:",orderItemNames.get(i));

        String itemOrderResourceName = orderItemNames.get(i).replaceAll("\\s+", "_").toLowerCase();
        viewHolder.itemImage.setImageResource(context.getResources().getIdentifier(
                itemOrderResourceName,"drawable",context.getPackageName()));;

        viewHolder.itemName.setText(orderItemNames.get(i));

        viewHolder.itemQuantity.setText("x" + orderItemList.get(orderItemNames.get(i).toString()).toString());

        double itemSubtotal = MenuItemDatabase.getMenuItemByName(orderItemNames.get(i)).getPrice() *
                orderItemList.get(orderItemNames.get(i));
        viewHolder.itemSubtotal.setText("$" + String.format("%.2f",itemSubtotal) + " @ $" +
                String.format("%.2f", MenuItemDatabase.getMenuItemByName(orderItemNames.get(i)).getPrice()) + " ea");

    }

    @Override
    public int getItemCount() {
        return orderItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        int listPos;
        ImageView itemImage;
        TextView itemName;
        TextView itemQuantity;
        TextView itemSubtotal;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            itemImage = itemView.findViewById(R.id.orderItemImageC);
            itemName = itemView.findViewById(R.id.orderItemNameC);
            itemQuantity = itemView.findViewById(R.id.orderItemQuantityC);
            itemSubtotal = itemView.findViewById(R.id.orderItemSubtotalC);
        }

    }

}


