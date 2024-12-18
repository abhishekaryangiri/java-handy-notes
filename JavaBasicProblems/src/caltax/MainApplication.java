package caltax;

import java.util.ArrayList;
import java.util.List;


public class MainApplication {

    public static void main(String[] args) {
        System.out.println("Output 1:");
        ReceiptPrinter.printReceipt(createBasket1());
        System.out.println();

        System.out.println("Output 2:");
        ReceiptPrinter.printReceipt(createBasket2());
        System.out.println();

        System.out.println("Output 3:");
        ReceiptPrinter.printReceipt(createBasket3());
    }

    private static List<Item> createBasket1() {
        List<Item> basket = new ArrayList<>();
        basket.add(new Item("book", 12.49, false, true));
        basket.add(new Item("music CD", 14.99, false, false));
        basket.add(new Item("chocolate bar", 0.85, false, true));
        return basket;
    }

    private static List<Item> createBasket2() {
        List<Item> basket = new ArrayList<>();
        basket.add(new Item("imported box of chocolates", 10.00, true, true));
        basket.add(new Item("imported bottle of perfume", 47.50, true, false));
        return basket;
    }

    private static List<Item> createBasket3() {
        List<Item> basket = new ArrayList<>();
        basket.add(new Item("imported bottle of perfume", 27.99, true, false));
        basket.add(new Item("bottle of perfume", 18.99, false, false));
        basket.add(new Item("packet of headache pills", 9.75, false, true));
        basket.add(new Item("box of imported chocolates", 11.25, true, true));
        return basket;
    }
}
