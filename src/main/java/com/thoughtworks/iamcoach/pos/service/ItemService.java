package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.util.List;

public class ItemService {

    StorageServer storageServer = new StorageServer();
    PromotionService promotionService = new PromotionService();
    public Item findItem(String barcode) {
        List<Item> items = storageServer.getItems();

        Item result = new Item();
        for (Item item : items) {
            if (barcode.equals(item.getBarcode())) {
                List<Promotion> promotionList = promotionService.getPromotionByBarcode(barcode);
                result = item;
                result.setPromotionList(promotionList);
                break;
            }
        }

        return result;
    }
}
