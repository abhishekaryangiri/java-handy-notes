package salestaxcal;

import java.util.*;

public class SalesTaxCalculator {

    // Method to print the receipt for the shopping basket
    public static void printReceipt(List<Item> items) {
        double totalTax = 0.0;
        double totalCost = 0.0;

        // Print item details
        for (Item item : items) {
            System.out.println(item.name + ": " + String.format("%.2f", item.getPriceWithTax()));
            totalTax += item.calculateTax();
            totalCost += item.getPriceWithTax();
        }

        // Print the total sales taxes and total cost
        System.out.println("Sales Taxes: " + String.format("%.2f", totalTax));
        System.out.println("Total: " + String.format("%.2f", totalCost));
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test Input 1
        List<Item> basket1 = new ArrayList<>();
        basket1.add(new Item("book", 12.49, false, true));
        basket1.add(new Item("music CD", 14.99, false, false));
        basket1.add(new Item("chocolate bar", 0.85, false, true));
        System.out.println("Output  1:");
        printReceipt(basket1);
        System.out.println();

        // Test Input 2
        List<Item> basket2 = new ArrayList<>();
        basket2.add(new Item("imported box of chocolates", 10.00, true, true));
        basket2.add(new Item("imported bottle of perfume", 47.50, true, false));
        System.out.println("Output  2:");
        printReceipt(basket2);
        System.out.println();

        // Test Input 3
        List<Item> basket3 = new ArrayList<>();
        basket3.add(new Item("imported bottle of perfume", 27.99, true, false));
        basket3.add(new Item("bottle of perfume", 18.99, false, false));
        basket3.add(new Item("packet of headache pills", 9.75, false, true));
        basket3.add(new Item("box of imported chocolates", 11.25, true, true));
        System.out.println("Output 3:");
        printReceipt(basket3);
    }
}
