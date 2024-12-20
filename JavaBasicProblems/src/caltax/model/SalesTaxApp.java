package caltax.model;


import java.util.Arrays;
import java.util.List;

public class SalesTaxApp {
    public static void main(String[] args) {
        // Basket 1
        List<Product> basket1 = Arrays.asList(
                new Product("book", 12.49, false, true),
                new Product("music CD", 14.99, false, false),
                new Product("chocolate bar", 0.85, false, true)
        );

        // Basket 2
        List<Product> basket2 = Arrays.asList(
                new Product("imported box of chocolates", 10.00, true, true),
                new Product("imported bottle of perfume", 47.50, true, false)
        );

        // Basket 3
        List<Product> basket3 = Arrays.asList(
                new Product("imported bottle of perfume", 27.99, true, false),
                new Product("bottle of perfume", 18.99, false, false),
                new Product("packet of headache pills", 9.75, false, true),
                new Product("box of imported chocolates", 11.25, true, true)
        );

        // Print Receipts
        System.out.println("Output 1:");
        ReceiptService.printReceipt(basket1);

        System.out.println("\nOutput 2:");
        ReceiptService.printReceipt(basket2);

        System.out.println("\nOutput 3:");
        ReceiptService.printReceipt(basket3);
    }
}


