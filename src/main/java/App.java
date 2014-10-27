import com.thoughtworks.iamcoach.pos.*;
import com.thoughtworks.iamcoach.pos.service.PromotionService;
import com.thoughtworks.iamcoach.pos.service.StorageServer;
import com.thoughtworks.iamcoach.pos.vo.BoughtItem;

import java.util.List;

public class App {
    public static void main(String[] args) {

        StorageServer storageServer = new StorageServer();
        List<String> cartBarcodes = storageServer.getCartBarcodes();

        Pos pos = new Pos();
        List<BoughtItem> boughtItems = pos.handleBarcodes(cartBarcodes);

        PromotionService promotionService = new PromotionService();
        List<PrintItem> printItemList = promotionService.calculatePromotion(boughtItems);
        Output.printShoppingList(printItemList);
    }

}
