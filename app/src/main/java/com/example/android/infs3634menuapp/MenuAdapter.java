package com.example.android.infs3634menuapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    private List<MenuItem> menuItemList;
    Context context;

    MenuAdapter(Context context, List<MenuItem> menuItemList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.menuItemList = menuItemList;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.chunk, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder viewHolder, int i) {
        //String menuItemName = menuItemList.get(i).getDescription();
        viewHolder.listPos = i;
        viewHolder.menuItemName.setText(menuItemList.get(i).getName());
        String itemResourceName = menuItemList.get(i).getName().replaceAll("\\s+", "_").toLowerCase();
        viewHolder.menuItemImage.setImageResource(context.getResources().getIdentifier(itemResourceName,"drawable",context.getPackageName()));
        //viewHolder.menuItemImage.setImageResource(R.drawable.burger);
        //Log.d("Item Resource Name: ",itemResourceName);

    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int listPos;
        TextView menuItemName;
        ImageView menuItemImage;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            menuItemName = itemView.findViewById(R.id.menuItemNameC);
            menuItemImage = itemView.findViewById(R.id.menuItemImageC);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                   Intent intent = new Intent(v.getContext(),ItemDetail.class);
                   Bundle bundle = new Bundle();
                   bundle.putString("Item Name", menuItemList.get(listPos).getName());
                   intent.putExtras(bundle);
                   Context context = v.getContext();
                   context.startActivity(intent);
                }
            });
        }
        /*Intent intent = new Intent(v.getContext(), DetailActivity.class);
        Bundle bundle = new Bundle();
                    bundle.putInt("ID",articleID);
                    bundle.putString("Type","Article");
                    intent.putExtras(bundle);
        Context context = v.getContext();
                    context.startActivity(intent);*/
    }

        }

