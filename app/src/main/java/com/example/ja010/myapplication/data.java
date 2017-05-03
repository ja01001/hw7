package com.example.ja010.myapplication;

/**
 * Created by ja010 on 17-05-01.
 */

public class data {
    private String name ;
    private int imgno;
    private int price ;
    static int image[] = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry, R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi, R.drawable.orange, R.drawable.watermelon};
    static int priceno[] = {100,200,300,400,500,600,700,800};

    public data(String name,int imgno,int price){
        this.name = name;
        this.imgno = imgno;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getImage(){
        return imgno;
    }
    public int getPrice(){
        return price;
    }
    public void setImage(int imgno) {
        this.imgno = imgno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
