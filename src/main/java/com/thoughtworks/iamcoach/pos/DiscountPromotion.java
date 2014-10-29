package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

public class DiscountPromotion extends Promotion {

    public DiscountPromotion(int id, String type, int discount, int level) {
        super(id, type, discount, level);
    }

    @Override
    public double calculate(BoughtItem boughtItem) {
        double number = boughtItem.getNumber();
        double subtotal = boughtItem.getPrice() * number * getDiscount() / 100;
        return subtotal;
    }
}
