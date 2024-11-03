package org.example;

import java.util.List;

public class ShippingService {
    public void displyNameAndWeight(List<ShippingProduct> items) {
        for (ShippingProduct item : items) {
            System.out.println("Name: " + item.getName() + ", Weight: " + item.getWeight());
        }
    }
}
