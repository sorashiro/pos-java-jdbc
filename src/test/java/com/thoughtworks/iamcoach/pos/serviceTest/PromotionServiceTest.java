package com.thoughtworks.iamcoach.pos.serviceTest;


import com.thoughtworks.iamcoach.pos.service.PromotionService;
import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionServiceTest {
  PromotionService promotionService = new PromotionService();

  @Test
  public void calculate_promotion_test() {
    List<BoughtItem> boughtItems = new ArrayList<BoughtItem>();
    Item item1 = new Item("ITEM000002", "apple", "kg", 10.00);
    Item item2 = new Item("ITEM000001", "book", "本", 10.00);
    Item item3 = new Item("ITEM000007", "milk", "盒", 10.00);

    boughtItems.add(new BoughtItem(item1, 4.00));
    boughtItems.add(new BoughtItem(item2, 3.00));
    boughtItems.add(new BoughtItem(item3, 2.00));

//    assertThat(promotionService.calculatePromotion(boughtItems).size()).isEqualTo(3);
  }
}
