package cn.zph.eshop.goods.entity;

import cn.zph.eshop.common.entity.Entity;

public class Goods extends Entity {
    private String name;//商品名
    private String brand;//品牌
    private int number;//数量

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;//价格

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
