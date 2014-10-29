package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Item;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class BuyTwoGetOneFreePromotionTest {
  BuyTwoGetOneFreePromotion buyTwoGetOneFree = new BuyTwoGetOneFreePromotion(1, "buy_two_get_one_free", 1);

  @Test
  public void calculate_test() {
    Item item = new Item("ITEM000002", "apple", "kg", 10.00);
    BoughtItem boughtItem = new BoughtItem(item, 5.0);
    assertThat(buyTwoGetOneFree.calculate(boughtItem)).isEqualTo(40.0);

    BoughtItem boughtItem1 = new BoughtItem(item, 3.0);
    assertThat(buyTwoGetOneFree.calculate(boughtItem1)).isEqualTo(20.0);

    BoughtItem boughtItem2 = new BoughtItem(item, 1.0);
    assertThat(buyTwoGetOneFree.calculate(boughtItem2)).isEqualTo(10.0);

    BoughtItem boughtItem3 = new BoughtItem(item, 0.0);
    assertThat(buyTwoGetOneFree.calculate(boughtItem3)).isEqualTo(0.0);
  }
}
