package com.adobe.aem.guides.wknd.core.service;

import com.adobe.aem.guides.wknd.core.models.ShoppingItems;
import com.adobe.aem.guides.wknd.core.models.impl.CartImpl;
import com.adobe.aem.guides.wknd.core.models.impl.ListShop;
import com.adobe.aem.guides.wknd.core.models.impl.ShoppingItemsImpl;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;


import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AddProduct implements Action {

    @Override
    public String executa(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        String idString = request.getParameter("id");
        Integer id = Integer.parseInt(idString);
        String prodIdString = request.getParameter("prodId");
        Integer prodId = Integer.parseInt(prodIdString);

        ListShop ls = new ListShop();

        ShoppingItemsImpl sh = ls.search(prodId);

        CartImpl cart = new CartImpl();
        cart.AddItem(sh);
        List<ShoppingItems> l = cart.getShoppingList();


        return " " + l;
    }
}
