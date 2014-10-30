package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.service.ItemService;
import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pos {

    public List<BoughtItem> barcodesToBoughtItems(List<String> cartBarcodes) {
        List<BoughtItem> boughtItemList = new ArrayList<BoughtItem>();
        List<String> uniqueBarcodes = uniqueArray(cartBarcodes);

        for (String uniqueBarcode : uniqueBarcodes) {
            int times = getBarcodeTimes(cartBarcodes, uniqueBarcode);
            BoughtItem boughtItem = toBoughtItem(uniqueBarcode, times);
            boughtItemList.add(boughtItem);
        }
        return boughtItemList;
    }

    private BoughtItem toBoughtItem(String cartBarcode, int times) {
        ItemService itemService = new ItemService();
        String[] barcodes = cartBarcode.split("-");

        Double number = 1.00;
        if (barcodes.length == 2) {
            number = Double.parseDouble(barcodes[1]);
        }

        return determinePromotionType(itemService.findItemByBarcode(barcodes[0]), number * times);
    }

    private BoughtItem determinePromotionType(Item item, double number) {
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
        for (BoughtItem boughtItem : boughtItems) {
            System.out.print(boughtItem.getSubtotal() + "---------");
        }
        System.out.print("\n");
        Collections.sort(boughtItems);
        for (BoughtItem boughtItem : boughtItems) {
            System.out.print(boughtItem.getSubtotal() + "++++++");
        }
        System.out.print("\n");
        return boughtItems.get(0);
    }

    private List<String> uniqueArray(List<String> cartBarcodes) {
        List<String> tempArray = new ArrayList<String>();

        for (String barcode : cartBarcodes) {
            if (!tempArray.contains(barcode)) {
                tempArray.add(barcode);
            }
        }
        return tempArray;
    }

    private int getBarcodeTimes(List<String> cartBarcodes, String barcode) {
        int result = 0;

        for (String cartBarcode : cartBarcodes) {
            if (cartBarcode.equals(barcode)) {
                result++;
            }
        }
        return result;
    }
}
