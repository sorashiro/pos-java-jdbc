package com.thoughtworks.iamcoach.pos;

import java.util.List;

public class ItemServer {

    StorageServer storageServer = new StorageServer();
    PromotionServer promotionServer = new PromotionServer();
    public Item findItem(String barcode) {
        List<Item> items = storageServer.getItems();

        Item result = new Item();
        for (Item item : items) {
            if (barcode.equals(item.getBarcode())) {
                List<Promotion> promotionList = promotionServer.getPromotionByBarcode(barcode);
                result = item;
                result.setPromotionList(promotionList);
                break;
            }
        }

        return result;
    }
}
