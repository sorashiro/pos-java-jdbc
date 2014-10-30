import com.thoughtworks.iamcoach.pos.*;
import com.thoughtworks.iamcoach.pos.util.FileUtil;
import com.thoughtworks.iamcoach.pos.vo.BoughtItem;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String CART_FILE = "src/main/resources/cart.txt";

    public static void main(String[] args) {

        List<String> cartBarcodes = FileUtil.textToList(CART_FILE);;

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
