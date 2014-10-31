package com.thoughtworks.iamcoach.pos.vo.promotion;

import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

public class DiscountPromotion extends Promotion {

    public DiscountPromotion(int id, String type, int discount, int level) {
        super(id, type, discount, level);
    }

    @Override
    public double calculate(Item item, double number) {
        return item.getPrice() * number * getDiscount() / 100;
    }
}
