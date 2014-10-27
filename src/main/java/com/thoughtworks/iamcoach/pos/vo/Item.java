package com.thoughtworks.iamcoach.pos.vo;

import java.util.List;

public class Item {
    private String barcode;
    private String name;
    private String unit;
    private double price;
    private List<Promotion> promotionList;

    public Item() {
    }


    public Item(String barcode, String name, String unit, double price) {
        this.setBarcode(barcode);
        this.setName(name);
        this.setUnit(unit);
        this.setPrice(price);
    }

    public void setPromotionList(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }
}
