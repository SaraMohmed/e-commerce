package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        Cart cart = new Cart();
        Products products = new ShippingProduct("chesse",100.0, 10,0.4);
        cart.addCart(products, 2);
        Products products2 = new ShippingProduct("Biscuits",150.0, 10,0.7);
        cart.addCart(products2, 1);
        System.out.println("Subtotal       "+(int)cart.getOrderSubTotal());
        System.out.println("Shipping       "+(int)cart.getShippingFees());
        System.out.println("Amount         "+(int)cart.getPaidAmount());


    }
}