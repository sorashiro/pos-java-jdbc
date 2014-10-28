package com.thoughtworks.iamcoach.pos.serviceTest;

import com.thoughtworks.iamcoach.pos.service.ItemService;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ItemServiceTest {
  ItemService itemService = new ItemService();

  @Test
  public void find_item_test() {
    String barcode = "ITEM000001";
    assertThat(itemService.findItem(barcode).getBarcode()).isEqualTo("ITEM000001");
    assertThat(itemService.findItem(barcode).getName()).isEqualTo("可口可乐");
    assertThat(itemService.findItem(barcode).getPrice()).isEqualTo(3.50);
    assertThat(itemService.findItem(barcode).getUnit()).isEqualTo("瓶");
  }

    @Test
    public void find_item_by_id_test() {
        int id = 1;
        assertThat(itemService.findItemById(id).getBarcode()).isEqualTo("ITEM000001");
    }

    @Test
    public void find_items_test() {
        assertThat(itemService.findItems().size()).isEqualTo(9);
    }

    @Test
    public void get_promotions_by_item_id_test() {
        int id = 1;
        assertThat(itemService.findItemById(id).getPromotionList().size()).isEqualTo(2);
    }
}

