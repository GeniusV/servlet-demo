package com.hjc.entity;

/**
 * Created by GeniusV on 5/15/18.
 */
public class Good {
    private int id;
    private String name;
    private String info;
    private String imgPath;
    private int category;
    private float price;
    private int num;

    public Good() {

    }

    public Good(int id, String name, String info, String imgPath, int category, float price, int num) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.imgPath = imgPath;
        this.category = category;
        this.price = price;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
