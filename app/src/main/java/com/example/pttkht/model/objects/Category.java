package com.example.pttkht.model.objects;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Heart Of Dead on 11/1/2017.
 */

public class Category implements Serializable{
    private int idCategory;
    private String linkImg;
    private String name;
    private List<FastFood> fastFoodList;

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Category(int idCategory, String linkImg, String name) {
        this.idCategory = idCategory;
        this.linkImg = linkImg;
        this.name = name;
    }


    public String getLinkImg() {
        return linkImg;
    }

    public String getName() {
        return name;
    }
}
