package com.thoughtworks.iamcoach.pos.vo;

public class Promotion {
    private String barcode;
    private int id;
    private String type;
    private int level;

    public Promotion(String barcode, String type) {
        this.barcode = barcode;
        this.type = type;
    }

    public Promotion(int id, String type, int level) {
        this.id = id;
        this.type = type;
        this.level = level;
    }

    public Promotion(String type) {
        this.type = type;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getType() {
        return type;
    }

}
