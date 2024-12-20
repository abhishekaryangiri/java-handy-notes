package caltax.model;


import java.util.List;

public class ReceiptService {
    public static void printReceipt(List<Product> products) {
        Receipt receipt = new Receipt(products);

        receipt.getProducts().forEach(System.out::println);
        System.out.printf("Sales Taxes: %.2f%n", receipt.getTotalTax());
        System.out.printf("Total: %.2f%n", receipt.getTotalCost());
    }
}

