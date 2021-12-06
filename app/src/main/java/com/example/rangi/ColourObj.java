package com.example.rangi;

import android.graphics.Color;

public class ColourObj {
    Color color;
    String name;
    int rgb;


    public ColourObj(String name, int rgb){
        this.setName(name);
        this.setRGB(rgb);
    }

    public ColourObj() {

    }

    public void setName(String name){
        this.name=name;
    }
    public void setRGB(int rgb){
        this.rgb=rgb;
    }
    public String getName(){
        return name;
    }
    public int getRGB(){
        return rgb;
    }
}
