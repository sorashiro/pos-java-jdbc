package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

public class BuyTwoGetOneFreePromotion extends Promotion {

    public BuyTwoGetOneFreePromotion(int id, String type, int discount, int level) {
        super(id, type, discount, level);
    }

    public BuyTwoGetOneFreePromotion(String barcode, String type) {
        super(barcode, type);
    }

    public BuyTwoGetOneFreePromotion(int id, String type, int level) {
        super(id, type, level);
    }

    public PrintItem calculate(BoughtItem boughtItem) {

        double number = boughtItem.getNumber();
        double payNumber = number - (int) (number / 3);

        double subtotal = boughtItem.getPrice() * payNumber;
        return new PrintItem(boughtItem, subtotal);
    }
}
