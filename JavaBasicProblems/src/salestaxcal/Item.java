package salestaxcal;

public class Item {
    String name;
    double price;
    boolean isImported;
    boolean isExempt;

    // Constructor
    public Item(String name, double price, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    // Method to calculate the sales tax for the item
    public double calculateTax() {
        double tax = 0.0;
        // Apply 10% basic sales tax if not exempt
        if (!isExempt) {
            tax += price * 0.10;
        }
        // Apply 5% import duty if the item is imported
        if (isImported) {
            tax += price * 0.05;
        }
        return roundToNearestFiveCents(tax);
    }

    // Method to round tax to the nearest 0.05
    private double roundToNearestFiveCents(double amount) {
        return Math.ceil(amount * 20) / 20.0;
    }

    // Method to get the final price including tax
    public double getPriceWithTax() {
        return price + calculateTax();
    }
}
