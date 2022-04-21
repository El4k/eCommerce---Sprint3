package com.adobe.aem.guides.wknd.core.service;

import com.adobe.aem.guides.wknd.core.models.OrderModel;
import com.adobe.aem.guides.wknd.core.models.ShoppingItemsModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import java.util.List;

public interface OrderService {

    List<OrderModel> getOrderList(SlingHttpServletRequest request, SlingHttpServletResponse response);
    List<OrderModel> verifyOrderNull(SlingHttpServletRequest req);
    String strToJson(Object object);
    List<ShoppingItemsModel> addProduct(SlingHttpServletRequest request, SlingHttpServletResponse response);
    List<OrderModel> delProduct(SlingHttpServletRequest request, SlingHttpServletResponse response);
    List<ShoppingItemsModel> searchProducts(SlingHttpServletRequest request, SlingHttpServletResponse response);
    List<ShoppingItemsModel> addClient(SlingHttpServletRequest request, SlingHttpServletResponse response);

}
