package com.thoughtworks.iamcoach.pos;


import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;


public class BoughtItemTest {
    private Item item = new Item(1, "ITEM000001", "雪碧", "瓶", 3.50, "饮料");
    private List<Promotion> promotionList = new ArrayList<Promotion>();
    private Promotion buyTwoGetOneFreePromotion = new Promotion(1, "buy_two_get_one_free", 1);
    private Promotion secondHalfPricePromotion = new Promotion(1, "second_half_price", 2);
    private Promotion discountPromotion = new Promotion(1, "discount", 3);

    @Test
    public void calculate_price_test() {
        promotionList.add(buyTwoGetOneFreePromotion);
        promotionList.add(secondHalfPricePromotion);
        promotionList.add(discountPromotion);
        item.setPromotionList(promotionList);
        BoughtItem boughtItem = new BoughtItem(item, 2.00);
        assertThat(boughtItem.calculatePrice().getSubtotal()).isEqualTo(40.0);
    }
}
