package com.sharma.shubham.quoteking;

/**
 * Created by hp on 9/29/2016.
 */

public class Category {
    private String name;
    private String image;

    public Category(){

    }

    public Category(String n, String i){
        name = n;
        image = i;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image =  image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
