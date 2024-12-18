package caltax.model;

import java.util.List;

// Responsible for generating and printing receipts for shopping baskets.

public class ReceiptPrinter {

    public static void printReceipt(List<Item> items) {
        double totalTax = 0.0;
        double totalCost = 0.0;

        // Print item details and calculate totals
        for (Item item : items) {
            double priceWithTax = TaxCalculator.calculatePriceWithTax(item);
            System.out.printf("1 %s: %.2f%n", item.getName(), priceWithTax);

            totalTax += TaxCalculator.calculateTax(item);
            totalCost += priceWithTax;
        }

        // Print totals
        System.out.printf("Sales Taxes: %.2f%n", totalTax);
        System.out.printf("Total: %.2f%n", totalCost);
    }
}
