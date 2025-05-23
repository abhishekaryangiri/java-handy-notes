package caltax.model;


public class TaxCalculator {

    public static double calculateTax(Product item) {
        double tax = 0.0;

        if (!item.isExempt()) {
            tax += item.getPrice() * 0.10;
            // Basic sales tax
        }
        if (item.isImported()) {
            tax += item.getPrice() * 0.05; 
            // Import duty
        }

        return roundToNearestFiveCents(tax);
    }

    public static double calculatePriceWithTax(Product item) {
        return item.getPrice() + calculateTax(item);
    }

    private static double roundToNearestFiveCents(double amount) {
        return Math.ceil(amount * 20) / 20.0;
    }
}
