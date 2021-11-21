package com.base;

public class Register {
    private ProductCatalog catalog;
    private Sale currentSale;

    public Register(ProductCatalog catalog) {
        this.catalog = catalog;
    }

    public void endSale() {
        currentSale.becomeComplete();
    }

    public void enterItem(int id, int quantity) {
        ProductDescription desc = catalog.getProductDescription(id);

        currentSale.makeLineItem( desc, quantity );
    }

    public void makeNewSale() {
        currentSale = new Sale();
    }

    public void makePayment(String paymentType, double cashTendered) {
        currentSale.makePayment(cashTendered, paymentType);
    }
}
