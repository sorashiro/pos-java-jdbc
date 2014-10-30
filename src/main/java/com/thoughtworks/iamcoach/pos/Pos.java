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
        ItemService itemService = new ItemService();
        List<BoughtItem> boughtItemList = new ArrayList<BoughtItem>();
        List<String> uniqueBarcodes = uniqueArray(cartBarcodes);

        for (String uniqueBarcode : uniqueBarcodes) {
            int times = getBarcodeTimes(cartBarcodes, uniqueBarcode);
            String itemBarcode = getItemBarcode(uniqueBarcode);
            BoughtItem boughtItem = determineBoughtItem(itemService.findItemByBarcode(itemBarcode),
                    getBarcodeNumber(uniqueBarcode, times));
            boughtItemList.add(boughtItem);
        }
        return boughtItemList;
    }
    private String getItemBarcode(String cartBarcode) {
        String[] barcodes = cartBarcode.split("-");
        return barcodes[0];
    }

    private double getBarcodeNumber(String cartBarcode, int times) {
        String[] barcodes = cartBarcode.split("-");
        Double number = 1.00;
        if (barcodes.length == 2) {
            number = Double.parseDouble(barcodes[1]);
        }

        return number * times;
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
