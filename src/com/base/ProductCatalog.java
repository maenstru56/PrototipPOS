package com.base;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<Integer, ProductDescription> descriptions = new HashMap();

    public ProductCatalog() {
        int id1 = 100;
        int id2 = 200;
        double price = 3;

        ProductDescription desc;
        desc = new ProductDescription(id1, price, "product 1" );
        descriptions.put( id1, desc );

        desc = new ProductDescription(id2, price, "product 2" );
        descriptions.put( id2, desc );
    }

    public ProductDescription getProductDescription(int id) {
        return descriptions.get( id );
    }
}
