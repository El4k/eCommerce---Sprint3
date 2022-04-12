package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.Cart;
import com.adobe.aem.guides.wknd.core.models.ShoppingItems;

import java.util.ArrayList;
import java.util.List;

public class CartImpl implements Cart {

    private ListShop listShop;
    private Integer id;
    private ArrayList<ShoppingItemsImpl> cat = listShop.catalogo();
    private ShoppingItemsImpl shop;
    private List<ShoppingItems> shoppingList= new ArrayList<>();

    public void setId(Integer id) {
        this.id = id;
    }

    public void setShoppingList(List<ShoppingItems> shoppingList) {
        this.shoppingList = shoppingList;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public List<ShoppingItems> getShoppingList() {
        return shoppingList;
    }

    public List<ShoppingItems> AddItem( ShoppingItemsImpl shop){
        for (int i=0; i<cat.size(); i++){
            if(shop.getId() == cat.indexOf(i)){
                shoppingList.add(shop);
            }
        }

        return shoppingList;
    }
}
