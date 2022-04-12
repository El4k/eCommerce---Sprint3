package com.adobe.aem.guides.wknd.core.models.impl;

import javax.servlet.ServletException;
import java.util.ArrayList;

public class ListShop {

    ArrayList<ShoppingItemsImpl> shopList = new ArrayList<>();

    public ArrayList<ShoppingItemsImpl> catalogo() {

        ShoppingItemsImpl prod1 = new ShoppingItemsImpl(0,"notebook i7", 7500.0, 15);
        shopList.add(prod1);
        ShoppingItemsImpl prod2 = new ShoppingItemsImpl(1,"celular xiaomi", 1500.0, 5);
        shopList.add(prod2);
        ShoppingItemsImpl prod3 = new ShoppingItemsImpl(2,"notebook i5", 5500.0, 5);
        shopList.add(prod3);
        ShoppingItemsImpl prod4 = new ShoppingItemsImpl(3,"suporte notebook 15.6", 250.0, 5);
        shopList.add(prod4);
        ShoppingItemsImpl prod5 = new ShoppingItemsImpl(4,"suporte notebook 14", 150.0, 5);
        shopList.add(prod5);

        return shopList;
    }

    public ShoppingItemsImpl search(Integer id) throws ServletException {
       if(id <= shopList.size()){
           return shopList.get(id);
       }else{
           throw new ServletException();
       }
    }
}
