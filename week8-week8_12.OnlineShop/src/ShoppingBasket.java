
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Danya
 */
import java.util.Map;
import java.util.HashMap;

public class ShoppingBasket {

    private Map<String, Purchase> purchaseList;

    public ShoppingBasket() {
        this.purchaseList = new HashMap<String, Purchase>();
    }

    public void add(String product, int price) {
        if (purchaseList.containsKey(product)) {
            purchaseList.get(product).increaseAmount();
        } else {
            Purchase purchase = new Purchase(product, 1, price);
            purchaseList.put(product, purchase);
        }
    }

    public int price() {
        int totalPrice = 0;
        for (Purchase purchase : purchaseList.values()) {
            totalPrice += purchase.price();
        }
        return totalPrice;
    }

    public void print() {
        for (Purchase purchase : purchaseList.values()) {
            System.out.println(purchase);
        }
    }

}
