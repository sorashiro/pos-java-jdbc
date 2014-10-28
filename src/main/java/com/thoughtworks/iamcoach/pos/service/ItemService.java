package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.ItemDao;
import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.util.List;

public class ItemService {

    ItemDao itemDao = new ItemDao();
    StorageService storageService = new StorageService();
    PromotionService promotionService = new PromotionService();
    public Item findItem(String barcode) {
        List<Item> items = storageService.getItems();

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

    public Item findItemById(int id) {
        Item item = itemDao.getItemById(id);
        item.setPromotionList(itemDao.getItemPromotionList(id));
        return item;
    }

    public List<Item> findItems() {
        return itemDao.getItems();
    }

    public Item findItemByBarcode(String barcode) {

        return itemDao.getItemByBarcode(barcode);
    }

}
