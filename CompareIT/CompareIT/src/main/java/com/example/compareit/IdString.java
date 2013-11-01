package com.example.compareit;

/**
 * Created by Nacho on 10/31/13.
 */

import android.graphics.Bitmap;
public class IdString {


    // Representamos un producto para usar en listViews

    public int id;
    public String name;
    public double price;
    public String url;
    public Boolean imgLoaded;
    public Bitmap image;

    public IdString(int id, String name){
        this.id = id;
        this.name = name;
        this.imgLoaded = false;
        this.image=null;
    }


    public IdString(int id, String name,  double price, String url){
        this.id = id;
        this.name = name;
        this.price = price;
        this.url = url;
        this.imgLoaded = false;
        this.image=null;
    }


    public String toString(){
        return this.name;
    }
}