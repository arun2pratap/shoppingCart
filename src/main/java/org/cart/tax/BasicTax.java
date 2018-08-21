package org.cart.tax;

public class BasicTax implements Tax {
    private final double rate;

    public BasicTax(double rate) {
        this.rate = rate;
    }

    @Override
    public double applyTax(double price, int quantity) {
        return rate * price * quantity/100;
    }
}
