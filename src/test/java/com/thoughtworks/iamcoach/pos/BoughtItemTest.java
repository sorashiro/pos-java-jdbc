package com.thoughtworks.iamcoach.pos;


import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


public class BoughtItemTest {
    private BoughtItem boughtItem = new BoughtItem();
    @Test
    public void calculate_price_test() {
        assertThat(boughtItem.calculatePrice().getSubtoal()).isEqualTo(40.0);
    }
}
