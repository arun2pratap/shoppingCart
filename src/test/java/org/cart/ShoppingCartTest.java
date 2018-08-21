package org.cart;

import org.cart.tax.BasicTax;
import org.cart.tax.ExemptedTax;
import org.cart.tax.ImportDutyTax;
import org.cart.tax.Tax;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    @Test
    public void addProductImportDutyAndBasicTax() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Tax basicWithImportDuty = new ImportDutyTax(new BasicTax(10), 5);
        Product doveSoap = new Product("DoveSoap", 39.99, basicWithImportDuty);
        BillDesk billDesk = new BillDesk(shoppingCart);
        int quantity = 5;
        shoppingCart.add(doveSoap, quantity);
        assertEquals(229.94,billDesk.getCartPrice() , 0.0001);
    }

    @Test
    public void addProductExemptedTax() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Tax basicWithImportDuty = new ExemptedTax(0);
        Product doveSoap = new Product("DoveSoap", 39.99, basicWithImportDuty);
        BillDesk billDesk = new BillDesk(shoppingCart);
        int quantity = 5;
        shoppingCart.add(doveSoap, quantity);
        assertEquals(199.95,billDesk.getCartPrice() , 0.0001);
    }


    @Test
    public void addProductExemptedTaxWithImportDuty() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Tax basicWithImportDuty = new ImportDutyTax(new ExemptedTax(0),5);
        Product doveSoap = new Product("DoveSoap", 39.99, basicWithImportDuty);
        BillDesk billDesk = new BillDesk(shoppingCart);
        int quantity = 5;
        shoppingCart.add(doveSoap, quantity);
        assertEquals(209.95,billDesk.getCartPrice() , 0.0001);
    }
//
//    @Test(expected = InvalidParameterException.class)
//    public void invalidProductQuantity() {
//        new ShoppingCart().add(new Product("DoveSoap", 39.99, basicWithImportDuty), -2);
//    }
//
//    @Test
//    public void addSameProductMultipleTime() {
//        ShoppingCart shoppingCart = new ShoppingCart();
//        Product doveSoap = new Product("DoveSoap", 39.99, basicWithImportDuty);
//
//        shoppingCart.add(doveSoap, 5);
//        shoppingCart.add(new Product("DoveSoap", 39.99, basicWithImportDuty), 3);
//
//        assertEquals(8, shoppingCart.getQuantity(doveSoap));
////        assertEquals(319.92, shoppingCart.totalPrice(), 0.0001);
//    }
//
//    @Test
//    public void addMultipleProductWithTaxApplied() {
//        BasicTax basicTax = new BasicTax(12.5);
//        ShoppingCart shoppingCart = new ShoppingCart();
//        BillDesk billDesk = new BillDesk(basicTax, shoppingCart);
//        Product doveSoap = new Product("DoveSoap", 39.99, basicWithImportDuty);
//        Product axeDeo = new Product("AxeDeo", 99.99, basicWithImportDuty);
//
//        shoppingCart.add(doveSoap, 2);
//        shoppingCart.add(axeDeo, 2);
//
//        assertEquals(2, shoppingCart.getQuantity(doveSoap));
//        assertEquals(2, shoppingCart.getQuantity(axeDeo));
//        assertEquals(314.96, billDesk.getCartPrice(), 0.001);
////        assertEquals(35.0, billDesk.getCartPrice() - shoppingCart.totalPrice(), 0.0001);
//    }
}
