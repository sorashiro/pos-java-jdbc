package com.thoughtworks.iamcoach.pos.vo;

import com.thoughtworks.iamcoach.pos.PrintItem;

public class Promotion {
    //TODO should be delete
    private String barcode;
    private int id;
    private String type;
    private int discount;
    private int level;
    //TODO should be delete

    public Promotion(String barcode, String type) {
        this.barcode = barcode;
        this.type = type;
    }

    public Promotion(int id, String type, int level) {
        this.id = id;
        this.type = type;
        this.level = level;
    }

    public Promotion(int id, String type, int discount, int level) {
        this.id = id;
        this.type = type;
        this.discount = discount;
        this.level = level;
    }

    //TODO should be delete
    public String getBarcode() {
        return barcode;
    }

    public int getDiscount() {
        return discount;
    }

    public String getType() {
        return type;
    }

    public PrintItem calculate(BoughtItem boughtItem) {
        Double subtotal = boughtItem.getPrice() * boughtItem.getNumber();
        return new PrintItem(boughtItem, subtotal);
    }
}
