package com.adobe.aem.guides.wknd.core.dao;

import com.adobe.aem.guides.wknd.core.models.ClientModel;
import com.adobe.aem.guides.wknd.core.models.OrderModel;
import com.adobe.aem.guides.wknd.core.models.ShoppingItemsModel;

import java.util.List;

public interface OrderDao {
    List<OrderModel> getOrder(Integer id);

    List<OrderModel> getOrderList(Integer id);

    List<ShoppingItemsModel> addProduct(ShoppingItemsModel shoppingItemsModel, OrderModel orderModel);

    List<OrderModel> delProduct(ShoppingItemsModel shoppingItemsModel, OrderModel orderModel);

    List<ShoppingItemsModel> searchProducts(String keyWord);

    List<ShoppingItemsModel> addClient(ClientModel clientModel, OrderModel orderModel);
}
