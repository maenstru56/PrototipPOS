package com.base;

public class Store {
    private String name;
    private String address;
    private ProductCatalog catalog;
    private Register register;

    public Store(String name, String address, ProductCatalog catalog) {
        this.name = name;
        this.address = address;
        this.catalog = catalog;

        register = new Register(catalog);
    }

    public ProductCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(ProductCatalog catalog) {
        this.catalog = catalog;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public Register getRegister() {
        return register;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
