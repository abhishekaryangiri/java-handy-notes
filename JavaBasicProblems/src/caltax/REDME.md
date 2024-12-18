# CalTax Application Workflow

This application calculates the sales tax and total price of items in a shopping basket, considering both basic sales tax and import duties.

## Workflow Overview

1. **Item Creation**: 
   - Items are created using the `Item` class. Each item has a name, price, and two flags: one for import status (`isImported`) and one for exemption from tax (`isExempt`).
   
2. **Basket Creation**:
   - Three different baskets of items are created using `createBasket1()`, `createBasket2()`, and `createBasket3()`. These baskets consist of various items with different tax and import statuses.

3. **Tax Calculation**:
   - For each item, the `TaxCalculator` class calculates the applicable tax:
     - A 10% sales tax is applied to non-exempt items.
     - A 5% import duty is applied to imported items.
     - Taxes are rounded to the nearest 0.05 using the `roundToNearestFiveCents()` method.

4. **Receipt Printing**:
   - The `ReceiptPrinter` class prints the receipt for each basket, showing:
     - The item name and price with tax.
     - The total sales tax and total price of all items in the basket.

## How the Output is Generated

1. The `main()` method in `MainApplication` runs, calling `ReceiptPrinter.printReceipt()` for each basket.
2. The `printReceipt()` method iterates over each item in the basket and calls the `TaxCalculator.calculatePriceWithTax()` method to get the price including tax.
3. The total sales tax and total price are accumulated and printed at the end of each receipt.

### Sample Output (for Basket 1)

Output 1: 1 book: 12.49 1 music CD: 16.49 1 chocolate bar: 0.85 Sales Taxes: 1.50 Total: 29.83
```vbnet
Each basket's receipt is printed with the item details, sales taxes, and the final total cost.
```

---


- **Items**: 
  - A book (exempt from sales tax)
  - A music CD (taxed)
  - A chocolate bar (exempt from sales tax)
- **Sales Taxes**: 1.50
- **Total**: 29.83

---


- **Items**: 
  - A book (exempt from sales tax)
  - A music CD (taxed)
  - A chocolate bar (exempt from sales tax)
- **Sales Taxes**: 1.50
- **Total**: 29.83

---


- **Items**: 
  - A book (exempt from sales tax)
  - A music CD (taxed)
  - A chocolate bar (exempt from sales tax)
- **Sales Taxes**: 1.50
- **Total**: 29.83

---




- **Items**:
  - An imported box of chocolates (exempt from sales tax)
  - An imported bottle of perfume (taxed)
- **Sales Taxes**: 7.65
- **Total**: 65.15

---


## Output 1:

```html
<pre>
1 book: 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83
</pre>
```
