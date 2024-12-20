package caltax.model;

import java.util.List;

public class Receipt {
    private final List<Product> products;
    private final double totalTax;
    private final double totalCost;

    public Receipt(List<Product> products) {
        this.products = products;
        this.totalTax = products.stream().mapToDouble(Product::calculateTax).sum();
        this.totalCost = products.stream().mapToDouble(Product::getPriceWithTax).sum();
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
