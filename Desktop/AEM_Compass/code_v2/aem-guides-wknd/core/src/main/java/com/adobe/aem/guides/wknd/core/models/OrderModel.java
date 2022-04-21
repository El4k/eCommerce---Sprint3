package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class OrderModel {
    private Integer id;
    private ClientModel client;
    private ShoppingItemsModel orderList;
    private Integer amountItem;

    public OrderModel() {
    }

    public OrderModel(Integer id, ShoppingItemsModel orderList) {
        this.id = id;
        this.orderList = orderList;
    }

    public OrderModel(Integer id, ClientModel client, ShoppingItemsModel orderList) {
        this.id = id;
        this.client = client;
        this.orderList = orderList;
    }

    public OrderModel(Integer id) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public ShoppingItemsModel getOrderList() {
        return orderList;
    }

    public void setOrderList(ShoppingItemsModel orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "------------------------------\n" +
                "Order: \n" +
                "Id: " + this.getId() + "\n" +
                "Client: " + this.getClient() +"\n" +
                "Items: " + this.getOrderList() +"\n" +
                "------------------------------\n";
    }
}
