package caltax.model;


public class Product {
    private final String name;
    private final double price;
    private final boolean isImported;
    private final boolean isExempt;

    public Product(String name, double price, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public double calculateTax() {
        double tax = 0.0;
        if (!isExempt) {
            tax += price * 0.10; // Basic sales tax
        }
        if (isImported) {
            tax += price * 0.05; // Import duty
        }
        return roundToNearestFiveCents(tax);
    }

    public double getPriceWithTax() {
        return price + calculateTax();
    }

    private double roundToNearestFiveCents(double amount) {
        return Math.ceil(amount * 20) / 20.0;
    }

    @Override
    public String toString() {
        return String.format("1 %s: %.2f", name, getPriceWithTax());
    }
}

