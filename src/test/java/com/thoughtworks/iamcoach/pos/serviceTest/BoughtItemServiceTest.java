package com.thoughtworks.iamcoach.pos.serviceTest;

import com.thoughtworks.iamcoach.pos.service.BoughtItemService;
import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class BoughtItemServiceTest {
    private BoughtItemService boughtItemService = new BoughtItemService();
    private Item item = new Item(1, "ITEM000001", "雪碧", "瓶", 3.50, "饮料");
    private List<Promotion> promotionList = new ArrayList<Promotion>();
    private Promotion buyTwoGetOneFreePromotion = new Promotion(1, "buy_two_get_one_free", 1);
    private Promotion secondHalfPricePromotion = new Promotion(1, "second_half_price", 2);
    private Promotion discountPromotion = new Promotion(1, "discount", 3);

    @Test
    public void handle_barcodes_test() {
        List<String> cartBarcodes = new ArrayList<String>();
        cartBarcodes.add("ITEM000001");
        cartBarcodes.add("ITEM000001");
        cartBarcodes.add("ITEM000001");
        cartBarcodes.add("ITEM000001");
        cartBarcodes.add("ITEM000006-2.00");
        cartBarcodes.add("ITEM000006-2.00");


        List<BoughtItem> boughtItemList = boughtItemService.barcodesToBoughtItems(cartBarcodes);
        BoughtItem boughtItem1 = boughtItemList.get(0);
        BoughtItem boughtItem2 = boughtItemList.get(1);

        assertThat(boughtItem1.getNumber()).isEqualTo(4.00);
        assertThat(boughtItem1.getBarcode()).isEqualTo("ITEM000001");

        assertThat(boughtItem2.getNumber()).isEqualTo(4.00);
        assertThat(boughtItem2.getBarcode()).isEqualTo("ITEM000006");

    }

}
