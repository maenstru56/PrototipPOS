package com.base;

public class Register {
    private ProductCatalog catalog;

    public Sale getCurrentSale() {
        return currentSale;
    }

    public void setCurrentSale(Sale currentSale) {
        this.currentSale = currentSale;
    }

    private Sale currentSale;

    public Register(ProductCatalog catalog) {
        this.catalog = catalog;
    }

    public void endSale() {
        currentSale.becomeComplete();
    }

    public void enterItem(int id, int quantity) {
        if(catalog.getProductDescription(id) == null){
            System.out.println("Item's id doesn't exit!");
            return;
        }

        ProductDescription desc = catalog.getProductDescription(id);
        currentSale.makeLineItem(desc, quantity);
    }

    public void makeNewSale() {
        currentSale = new Sale();
    }

    public void makePayment(String paymentType, double cashTendered) {
        currentSale.makePayment(cashTendered, paymentType);
    }
}
