package org.cart.tax;

import org.cart.Product;

public interface Tax {
    double applyTax(double price, int quantity);
}
