package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

public class DiscountPromotion extends Promotion {


    public DiscountPromotion(String barcode, String type) {
        super(barcode, type);
    }

    public DiscountPromotion(int id, String type, int level) {
        super(id, type, level);
    }

    public DiscountPromotion(String barcode, int id, String type, int discount, int level) {
        super(barcode, id, type, discount, level);
    }

    public PrintItem calculate(BoughtItem boughtItem) {
        double number = boughtItem.getNumber();
        double subtotal = boughtItem.getPrice() * number * getDiscount() / 100;
        return new PrintItem(boughtItem, subtotal);
    }
}
