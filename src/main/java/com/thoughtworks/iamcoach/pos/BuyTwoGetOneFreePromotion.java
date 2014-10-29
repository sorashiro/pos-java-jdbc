package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

public class BuyTwoGetOneFreePromotion extends Promotion {

    public BuyTwoGetOneFreePromotion(int id, String type, int level) {
        super(id, type, level);
    }

    @Override
    public double calculate(Item item, double number) {

        double payNumber = number - (int) (number / 3);

        return item.getPrice() * payNumber;
    }
}
