package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import java.util.ArrayList;
import java.util.List;

import static com.adobe.aem.guides.wknd.core.models.Categoria.*;

@Model(adaptables = Resource.class)
public class ShoppingItemsModel {

    private Integer id;
    private String name;
    private Categoria categoria;
    private Double price;
    private Integer amount;

    private static List<ShoppingItemsModel> shopItemList = new ArrayList<>();
    static{
        insertShoppingItemsModel();
    }

    private List<ShoppingItemsModel> shopList = new ArrayList<ShoppingItemsModel>();

    public ShoppingItemsModel(){

    }

    public ShoppingItemsModel(Integer id, String name, Categoria categoria, Double price, Integer amount) {
        this.id = id;
        this.name = name;
        this.categoria = categoria;
        this.price = price;
        this.amount = amount;
    }

    public ShoppingItemsModel(Integer id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }



    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<ShoppingItemsModel> getScheduleShopping(){
        return shopItemList;
    }

    public void setShopList(ArrayList<ShoppingItemsModel> shopList){
        this.shopList = shopList;
    }

    public void addProduct(ShoppingItemsModel shopItem){
        shopItemList.add(shopItem);
    }

    public static void insertShoppingItemsModel(){
        shopItemList.add(new ShoppingItemsModel(0, "notebook i7",COMPUTADORES, 7000.0, 5));
        shopItemList.add(new ShoppingItemsModel(1, "notebook i5",COMPUTADORES, 5500.0, 5));
        shopItemList.add(new ShoppingItemsModel(2, "celular xiaomi",CELULARES, 2200.0, 5));
        shopItemList.add(new ShoppingItemsModel(3, "suporte de notebook",ACESSORIOS, 150.0, 5));

        shopItemList.addAll(shopItemList);
    }

    @Override
    public String toString(){
        return "------------------------------\n" +
                "Product description: \n" +
                "Id:......." + this.getId() + "\n" +
                "Name:....." + this.getName() +"\n" +
                "Categoria:" + this.getCategoria() +"\n" +
                "Price:...." + this.getPrice() +"\n" +
                "Amount:..." + this.getAmount() + "\n"+
                "------------------------------\n";
    }
}
