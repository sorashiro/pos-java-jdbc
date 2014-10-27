package com.thoughtworks.iamcoach.pos;

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
