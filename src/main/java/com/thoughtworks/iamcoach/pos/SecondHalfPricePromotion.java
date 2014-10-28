package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

public class SecondHalfPricePromotion extends Promotion {

    public SecondHalfPricePromotion(int id, String type, int level) {
        super(id, type, level);
    }

    public PrintItem calculate(BoughtItem boughtItem) {
        double number = boughtItem.getNumber();

        double total = boughtItem.getPrice() * number;
        double discountTotal = (0.5 * boughtItem.getPrice()) * (int) (number / 2);

        double subtotal = total - discountTotal;
        return new PrintItem(boughtItem, subtotal);
    }
}
