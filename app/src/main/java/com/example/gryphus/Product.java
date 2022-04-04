package com.example.gryphus;

import android.graphics.drawable.Drawable;

public class Product {

    private int itemID;
    private String name;
    private int quantity;
    private int price;
    private boolean inStock;
    private boolean favourite;
    private Drawable icon;


    public boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }


    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public Product(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public Product(String name, int itemID, int quantity, int price){
        this.name = name;
        this.quantity = quantity;
        this.itemID = itemID;
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }



    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
}
