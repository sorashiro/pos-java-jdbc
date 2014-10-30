import com.thoughtworks.iamcoach.pos.*;
import com.thoughtworks.iamcoach.pos.service.StorageService;
import com.thoughtworks.iamcoach.pos.vo.BoughtItem;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        StorageService storageService = new StorageService();
        List<String> cartBarcodes = storageService.getCartBarcodes();

        Pos pos = new Pos();
        List<BoughtItem> boughtItems = pos.barcodesToBoughtItems(cartBarcodes);

        List<PrintItem> printItemList = new ArrayList<PrintItem>();
        for(BoughtItem boughtItem : boughtItems) {
            PrintItem printItem = new PrintItem(boughtItem);
            printItemList.add(printItem);
        }
        Output.printShoppingList(printItemList);
    }

}
