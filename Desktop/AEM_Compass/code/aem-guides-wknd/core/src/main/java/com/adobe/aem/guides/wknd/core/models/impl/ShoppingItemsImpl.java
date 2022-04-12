package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.ShoppingItems;

public class ShoppingItemsImpl implements ShoppingItems {
    private Integer id;
    private String name;
    private Double price;
    private Integer amount;

    public ShoppingItemsImpl(Integer id, String name, Double price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }

}
