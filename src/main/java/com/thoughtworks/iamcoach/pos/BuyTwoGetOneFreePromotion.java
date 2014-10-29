package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

public class BuyTwoGetOneFreePromotion extends Promotion {

    public BuyTwoGetOneFreePromotion(int id, String type, int level) {
        super(id, type, level);
    }

    public double calculate(BoughtItem boughtItem) {

        double number = boughtItem.getNumber();
        double payNumber = number - (int) (number / 3);

        return boughtItem.getPrice() * payNumber;
    }
}
