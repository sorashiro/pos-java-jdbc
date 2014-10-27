package com.thoughtworks.iamcoach.pos;

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

    public  Promotion getPromotionByBarcode(String barcode) {
        Promotion result = null;
        List<Promotion> promotions = storageServer.getPromotions();

        for (Promotion promotion : promotions) {
            if (barcode.equals(promotion.getBarcode())) {
                result = promotion;
            }
        }

        return result;
    }

}
