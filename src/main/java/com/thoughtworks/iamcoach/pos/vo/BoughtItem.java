package com.thoughtworks.iamcoach.pos.vo;

public class BoughtItem {
    private int id;
    private String barcode;
    private String name;
    private String unit;
    private double price;
    private String category;
    private double number;
    private Promotion promotion;
    private double subtotal;

    public BoughtItem(int id, String barcode, String name, String unit,
                      double price, String category, double number, Promotion promotion) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.category = category;
        this.number = number;
        this.promotion = promotion;
    }

    public BoughtItem(Item item, double number, Promotion promotion, double subtotal) {
        this.id = item.getId();
        this.barcode = item.getBarcode();
        this.name = item.getName();
        this.unit = item.getUnit();
        this.price = item.getPrice();
        this.category = item.getCategory();
        this.number = number;
        this.promotion = promotion;
        this.subtotal = subtotal;
    }
    
    public int getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
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

    public String getCategory() {
        return category;
    }

    public double getNumber() {
        return number;
    }

    public Promotion getPromotion() {
        return promotion;
    }
}
