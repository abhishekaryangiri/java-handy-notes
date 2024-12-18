**Basic sales tax is applicable at a rate of 10% on all goods, except books, food,
and medical products that are exempt. Import duty is an additional sales tax
applicable on all imported goods at a rate of 5%, with no exemptions.**

**When I purchase items I receive a receipt which lists the name of all the items
and their price (including tax), finishing with the total cost of the items,
and the total amounts of sales taxes paid.  The rounding rules for sales tax are
that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to
the nearest 0.05) amount of sales tax.**

**Write an application that prints out the receipt details for these shopping baskets...**

**NPUT:** 

```html
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85
```
```html
Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50
```
```html
Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25
```

## Institution

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
1 book: 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83
```

## Output 2:
```html
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15
```

## Output 3:
```html
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 box of imported chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68
```