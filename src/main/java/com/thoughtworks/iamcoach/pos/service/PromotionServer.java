package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.PrintItem;
import com.thoughtworks.iamcoach.pos.PromotionType;
import com.thoughtworks.iamcoach.pos.StorageServer;
import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.util.ArrayList;
import java.util.List;

public class PromotionServer {
    private PromotionType promotionType;
    private StorageServer storageServer = new StorageServer();

    public void setPromotionType(String barcode) {
        this.promotionType = PromotionType.newPromotionType(barcode);
    }

    public List<PrintItem> calculatePromotion(List<BoughtItem> boughtItems) {
        List<PrintItem> printItemList = new ArrayList<PrintItem>();
        for (BoughtItem boughtItem : boughtItems) {

            setPromotionType(boughtItem.getBarcode());
            printItemList.add(promotionType.calculate(boughtItem));
        }
        return printItemList;
    }

    public  List<Promotion> getPromotionByBarcode(String barcode) {
        List<Promotion> promotionList = new ArrayList<Promotion>();
        List<Promotion> promotions = storageServer.getPromotions();

        for (Promotion promotion : promotions) {
            if (barcode.equals(promotion.getBarcode())) {
                promotionList.add(promotion);
            }
        }

        return promotionList;
    }

}
