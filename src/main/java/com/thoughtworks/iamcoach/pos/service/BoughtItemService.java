package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.PrintItem;
import com.thoughtworks.iamcoach.pos.vo.BoughtItem;
import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.util.ArrayList;
import java.util.List;

public class BoughtItemService {
    public PrintItem calculatePrice(Item item){
        BoughtItem boughtItem = new BoughtItem(item, 4);
        PrintItem printItem = new PrintItem(boughtItem,40);
        List<PrintItem> printItems = new ArrayList<PrintItem>();
        for(Promotion promotion : item.getPromotionList()) {
            PrintItem pi = promotion.calculate(boughtItem);
            printItems.add(pi);
        }
        return printItem;
    }
}
