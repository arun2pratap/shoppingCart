package org.cart;

import java.security.InvalidParameterException;
import java.util.*;


public class ShoppingCart {

    private Map<Product, Integer> orders = new HashMap<>();

    public void add(Product product, int quantity) {
        if(quantity <= 0){
            throw new InvalidParameterException("Please provide quantity greater than 0");
        }
        orders.put(product,
                (orders.get(product) == null ? 0 : orders.get(product)) + quantity);
    }

    public ArrayList<Product> getProducts(){
        return new ArrayList(orders.keySet());
    }

    public int getQuantity(Product product) {
        return orders.get(product) == null ? 0 : orders.get(product);
    }

}
