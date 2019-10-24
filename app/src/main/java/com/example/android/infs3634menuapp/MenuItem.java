package com.example.android.infs3634menuapp;

import android.graphics.drawable.Drawable;

public class MenuItem {

    private String name;
    private double price;
    private String description;
    private int imageRef;

    public MenuItem(){

    }

    public MenuItem(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
