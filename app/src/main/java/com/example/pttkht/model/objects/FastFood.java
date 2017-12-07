package com.example.pttkht.model.objects;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Heart Of Dead on 11/1/2017.
 */

public class FastFood implements Serializable{
    private int idFastFood;
    private String linkImage;
    private String nameFood;
    private int prices;

    public int getIdFastFood() {
        return idFastFood;
    }

    public void setIdFastFood(int idFastFood) {
        this.idFastFood = idFastFood;
    }

    public FastFood(int idFastFood, String linkImage, String nameFood, int prices) {
        this.idFastFood = idFastFood;
        this.linkImage = linkImage;
        this.nameFood = nameFood;
        this.prices = prices;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }
}
