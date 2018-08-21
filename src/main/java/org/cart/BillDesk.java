package org.cart;

import org.cart.tax.BasicTax;
import org.cart.util.MathUtil;

public class BillDesk {
    private final ShoppingCart shoppingCart;

    public BillDesk(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public double getCartPrice() {
        return MathUtil.round(shoppingCart.getProducts().stream().mapToDouble(p ->
                (p.price * shoppingCart.getQuantity(p)) + (p.tax.applyTax(p.price, shoppingCart.getQuantity(p)))).sum(),2);
    }
}
