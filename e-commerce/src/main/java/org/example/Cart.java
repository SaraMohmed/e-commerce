package org.example;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    Map<Products,Integer> items = new HashMap<>();
    public void addCart(Products products, int quantity) throws Exception {
        if (products.getQuantity() < quantity) {
            throw new Exception("This quantity is not available now");
        }
        if (products.isExpired()) {
            throw new Exception("This product is expired");
        }
        items.put(products, quantity);
        products.reduceQuantity(quantity);
    }

    public double getOrderSubTotal(){
       double subtotal=0.0;
        for (Map.Entry<Products, Integer> e : items.entrySet()) {
            Products product = e.getKey();
            int quantity = e.getValue();
            subtotal += product.getPrice() * quantity;
        }
        return subtotal;
    }

    public double getShippingFees(){
        double shippingFees = 27.3;   //assume shipping fees equals 27.3 per gram
        double shippingFeesTotal = 0.0;
        for (Map.Entry<Products, Integer> e : items.entrySet()) {
            Products product = e.getKey();
            int quantity = e.getValue();
            if (product instanceof ShippingProduct) {
                shippingFeesTotal += ((ShippingProduct) product).getWeight() * shippingFees;
            }
        }
        return shippingFeesTotal;
    }

    public double getPaidAmount(){
        return getOrderSubTotal()+getShippingFees();
    }

    public double getCustomerCurrentBalance(Customer customer) throws Exception {
        if(getPaidAmount()>customer.getBalance()){
            throw new Exception("The balance is the lowest total price");
        }
        customer.setBalance(customer.getBalance() - getPaidAmount());
        return customer.getBalance();
    }

}
