package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.Barcode;
import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoughtItemService {
    private Barcode barcode = new Barcode();

    public List<BoughtItem> barcodesToBoughtItems(List<String> cartBarcodes) {
        ItemService itemService = new ItemService();
        List<BoughtItem> boughtItemList = new ArrayList<BoughtItem>();
        List<String> uniqueBarcodes = barcode.uniqueBarcode(cartBarcodes);

        for (String uniqueBarcode : uniqueBarcodes) {
            int times = barcode.getBarcodeTimes(cartBarcodes, uniqueBarcode);
            String itemBarcode = barcode.getItemBarcode(uniqueBarcode);
            BoughtItem boughtItem = determineBoughtItem(itemService.findItemByBarcode(itemBarcode),
                    barcode.getBarcodeNumber(uniqueBarcode, times));
            boughtItemList.add(boughtItem);
        }
        return boughtItemList;
    }

    private BoughtItem determineBoughtItem(Item item, double number) {
        List<Promotion> promotionList = item.getPromotionList();
        List<BoughtItem> boughtItems = new ArrayList<BoughtItem>();
        for (Promotion promotion : promotionList) {
            double subtotal = promotion.calculate(item, number);
            BoughtItem boughtItem = new BoughtItem(item, number, promotion, subtotal);
            boughtItems.add(boughtItem);
        }
        return findMinSubtotal(boughtItems);
    }

    private BoughtItem findMinSubtotal(List<BoughtItem> boughtItems) {
        Collections.sort(boughtItems);
        return boughtItems.get(0);
    }
}
