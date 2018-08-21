package org.cart;

import org.cart.tax.Tax;

import java.util.Objects;

public class Product {
    public final double price;
    public final String name;
    public final Tax tax;

    public Product(String name, double price, Tax tax) {
        this.price = price;
        this.name = name;
        this.tax = tax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

}
