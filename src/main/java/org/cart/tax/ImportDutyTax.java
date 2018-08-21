package org.cart.tax;

public class ImportDutyTax implements Tax {

    private final Tax component;
    private final double rate;

    public ImportDutyTax(Tax component, double rate) {
        this.component = component;
        this.rate = rate;
    }

    @Override
    public double applyTax(double price, int quantity) {
        return component.applyTax(price, quantity) + rate * price * quantity/100;
    }
}
