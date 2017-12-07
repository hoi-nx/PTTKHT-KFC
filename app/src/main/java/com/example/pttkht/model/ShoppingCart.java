package com.example.pttkht.model;

import io.realm.RealmObject;

/**
 * Created by Heart Of Dead on 11/1/2017.
 */

public class ShoppingCart extends RealmObject{
    private int idFood;
    private int idCategory;
    private int totalPrices;
    private int number;

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public ShoppingCart(int idFood, int idCategory, int totalPrices, int number) {
        this.idFood = idFood;
        this.idCategory = idCategory;
        this.totalPrices = totalPrices;
        this.number = number;
    }

    public ShoppingCart() {
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public int getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(int totalPrices) {
        this.totalPrices = totalPrices;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
