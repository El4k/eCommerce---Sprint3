package com.adobe.aem.guides.wknd.core.dao;

import com.adobe.aem.guides.wknd.core.models.ShoppingItemsModel;

import java.util.List;

public interface ShoppingItemsDao {

    List<ShoppingItemsModel> getScheduleShopping();

    ShoppingItemsModel addProduct(ShoppingItemsModel shopItem);

    List<ShoppingItemsModel> delProduct(Integer id);

    ShoppingItemsModel upProduct(Integer id, ShoppingItemsModel shoppingItemsModel);
}
