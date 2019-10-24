package com.example.android.infs3634menuapp;

import android.util.Log;
import android.view.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MenuItemDatabase {

    public static ArrayList<MenuItem> getAllMenuItems() {
        //return new ArrayList<MenuItem>((ArrayList) Arrays.asList(menuItems.values().toArray()));
        ArrayList<MenuItem> tempMenuList = new ArrayList<>();
        for(int i=1;i <= menuItems.size();i++){
            tempMenuList.add(menuItems.get(i));
        }
        return tempMenuList;

    }

    public static MenuItem getMenuItemByName(String itemName){

        MenuItem item = new MenuItem();

        for (int i=1;i<=menuItems.size();i++){
            if(menuItems.get(i).getName() == itemName){
                item = menuItems.get(i);
                break;
            }else{
                continue;
            }
        }
        return item;
    }

    private static final HashMap<Integer, MenuItem> menuItems = new HashMap<>();

    static{
        menuItems.put(1, new MenuItem("Burger", 5.50,
        "A plain ol' burger"));
        menuItems.put(2, new MenuItem("Burger Junior",4.00,"Just like a " +
        "normal burger, but smaller"));
        menuItems.put(3,new MenuItem("Burger Senior",7.00,
        "Just like a normal burger,but bigger"));
        menuItems.put(4, new MenuItem("Small Fries",2.00,"Just like normal" +
        "fries, but smaller"));
        menuItems.put(5, new MenuItem("Medium Fries",3.00, "Just like small fries," +
        "but bigger"));
        menuItems.put(6,new MenuItem("Large Fries",4.00,"Just like a medium fries," +
        "but bigger"));
        menuItems.put(7, new MenuItem("Nugget Six Pack",5.50,
        "A six pack of nuggs"));
        menuItems.put(8, new MenuItem("Nugget 12 Pack", 7.50, "Just like the six pack," +
        "but double the size"));
        menuItems.put(9, new MenuItem("Onion Rings Six Pack", 5.00,
        "Onion rings ... for when you don't feel like fries"));
        menuItems.put(10, new MenuItem("Onion Rings 12 Pack",7.50,
        "The big boys of onion rings"));
        menuItems.put(11, new MenuItem("Chicken Burger", 5.50,
        "Just a plain ol' chicken burger'"));
        menuItems.put(12, new MenuItem("Deluxe Chicken Burger", 9.00,
        "A big boy chicken burger"));
        menuItems.put(13, new MenuItem("Vegan Burger", 2.00,
        "Don't order this..."));
        menuItems.put(14, new MenuItem("Vegan Burger Deluxe", 5.00,
        "Seriously, we won't make it"));
        menuItems.put(15, new MenuItem("Soft Serve", 0.30,
        "Good ol' 30 cent cone, the way it should be"));
        }

}
