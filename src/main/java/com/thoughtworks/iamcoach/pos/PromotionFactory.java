package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.vo.Promotion;


public class PromotionFactory {

    static final String BUY_TWO_GET_ONE_FREE = "buy_two_get_one_free";
    static final String SECOND_HALF_PRICE = "second_half_price";
    static final String DISCOUNT = "discount";

    public static Promotion createPromotion(int id, String type, int discount, int level) {
        Promotion promotion = new Promotion();

        if (type.equals(BUY_TWO_GET_ONE_FREE)) {
            promotion = new BuyTwoGetOneFreePromotion(id, type, level);
        } else if (type.equals(SECOND_HALF_PRICE)) {
            promotion = new SecondHalfPricePromotion(id, type, level);
        } else if (type.equals(DISCOUNT)) {
            promotion = new DiscountPromotion(id, type, discount, level);
        }

        return promotion;
    }
}