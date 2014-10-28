package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Item;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class DiscountPromotionTest {
  DiscountPromotion discountPromotion = new DiscountPromotion(2, "second_half_price", 50, 2);

  @Test
  public void calculate_test() {
    Item item = new Item("ITEM000002", "apple", "kg", 10.00);

    BoughtItem boughtItem = new BoughtItem(item, 5.0);
    assertThat(discountPromotion.calculate(boughtItem).getSubtotal()).isEqualTo(25.0);
  }
}
