package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

public interface Cart {

    String getId();

    List<ShoppingItems> getShoppingList();

}
