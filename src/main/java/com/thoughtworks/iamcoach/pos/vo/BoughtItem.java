package com.thoughtworks.iamcoach.pos.vo;

import com.thoughtworks.iamcoach.pos.PrintItem;

import java.util.ArrayList;
import java.util.List;

public class BoughtItem {
    private Item item;
    private double number;

    public BoughtItem(Item item, double number) {
        this.item = item;
        this.number = number;
    }

    public String getBarcode() {
        return item.getBarcode();
    }

    public double getPrice() {
        return item.getPrice();
    }

    public double getNumber() {
        return number;
    }

    public String getName() {
        return item.getName();
    }

    public String getUnit() {
        return item.getUnit();
    }

    public List<Promotion> getPromotionList() {
        return item.getPromotionList();
    }

    public PrintItem calculatePrice(){
        BoughtItem boughtItem = new BoughtItem(item, 4);
        PrintItem printItem = new PrintItem(boughtItem,40);
        List<PrintItem> printItems = new ArrayList<PrintItem>();
        for(Promotion promotion : item.getPromotionList()) {
            PrintItem pi = calculatePrintItem(promotion);
            printItems.add(pi);
        }
        return printItem;
    }

    private PrintItem calculatePrintItem(Promotion promotion) {

        PrintItem printItem = null;
        return  printItem;
    }

    public PrintItem calculate(BoughtItem boughtItem) {
        Double subtotal = boughtItem.getPrice() * boughtItem.getNumber();
        return new PrintItem(boughtItem, subtotal);
    }
}
