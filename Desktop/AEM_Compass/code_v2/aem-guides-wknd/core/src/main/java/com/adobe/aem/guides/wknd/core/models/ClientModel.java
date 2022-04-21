package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class ClientModel {

    private Integer id;
    private String username;
    private String name;
    private String password;

    public ClientModel(Integer id, String username, String name, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public ClientModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "------------------------------\n" +
                "Client: \n" +
                "Id: " + this.getId() + "\n" +
                "Username: " + this.getUsername() +"\n" +
                "Name: " + this.getName() +"\n" +
                "------------------------------\n";
    }
}
