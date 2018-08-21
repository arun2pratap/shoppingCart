package org.cart.tax;

public class ExemptedTax implements Tax {
    private final double rate;

    public ExemptedTax( double rate) {
        this.rate = rate;
    }

    @Override
    public double applyTax(double price, int quantity) {
        return rate * price * quantity/100;
    }
}
