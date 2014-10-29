package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.util.FileUtil;
import java.util.List;

public class StorageService {
    private static final String CART_FILE = "src/main/resources/cart.txt";

    public List<String> getCartBarcodes() {
        return FileUtil.textToList(CART_FILE);
    }

}
