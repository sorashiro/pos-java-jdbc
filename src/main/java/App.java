import com.thoughtworks.iamcoach.pos.*;
import com.thoughtworks.iamcoach.pos.service.PromotionService;
import com.thoughtworks.iamcoach.pos.service.StorageService;
import com.thoughtworks.iamcoach.pos.vo.BoughtItem;

import java.util.List;

public class App {
    public static void main(String[] args) {

        StorageService storageService = new StorageService();
        List<String> cartBarcodes = storageService.getCartBarcodes();

        Pos pos = new Pos();
        List<BoughtItem> boughtItems = pos.handleBarcodes(cartBarcodes);

        PromotionService promotionService = new PromotionService();
        List<PrintItem> printItemList = promotionService.calculatePromotion(boughtItems);
        Output.printShoppingList(printItemList);
    }

}
