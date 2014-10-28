package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.vo.BoughtItem;

public class PrintItem {
    private String name;
    private String unit;
    private double price;
    private String barcode;
    private double number;
    private double subtotal;

    public PrintItem(BoughtItem boughtItem, double subtotal) {
        this.subtotal = subtotal;
        this.name = boughtItem.getName();
        this.unit = boughtItem.getUnit();
        this.price = boughtItem.getPrice();
        this.barcode = boughtItem.getBarcode();
        this.number = boughtItem.getNumber();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getNumber() {
        return number;
    }
}
