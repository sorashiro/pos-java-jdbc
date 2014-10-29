package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Item;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SecondHalfPricePromotionTest {

  SecondHalfPricePromotion secondHalfPricePromotion = new SecondHalfPricePromotion(2, "second_half_price", 2);

  @Test
  public void calculate_test() {
    Item item = new Item("ITEM000002", "apple", "kg", 10.00);
    assertThat(secondHalfPricePromotion.calculate(item, 5.0)).isEqualTo(40.0);

    assertThat(secondHalfPricePromotion.calculate(item, 3.0)).isEqualTo(25.0);

    assertThat(secondHalfPricePromotion.calculate(item, 1.0)).isEqualTo(10.0);

    assertThat(secondHalfPricePromotion.calculate(item, 0)).isEqualTo(0.0);
  }
}
