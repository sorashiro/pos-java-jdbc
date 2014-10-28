package com.thoughtworks.iamcoach.pos.serviceTest;

import com.thoughtworks.iamcoach.pos.service.StorageService;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


public class StorageServiceTest {
  StorageService storageService = new StorageService();

  @Test
  public void get_items_test() {
    assertThat(storageService.getItems().size()).isEqualTo(9);
  }

  @Test
  public void get_cart_barcodes_test() {
    assertThat(storageService.getCartBarcodes().size()).isEqualTo(9);
  }

  @Test
  public void get_promotions_test() {
    assertThat(storageService.getPromotions().size()).isEqualTo(9);
  }
}