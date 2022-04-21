package com.adobe.aem.guides.wknd.core.service;

import com.adobe.aem.guides.wknd.core.models.ShoppingItemsModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import java.util.List;

public interface ScheduleProductService {
    List<ShoppingItemsModel> getProductDB();
    List<ShoppingItemsModel> getScheduleProducts();
    List<ShoppingItemsModel> verifyShopNull(SlingHttpServletRequest req);
    String strToJson(Object object);
    ShoppingItemsModel addProduct( SlingHttpServletRequest request, SlingHttpServletResponse response);
    List<ShoppingItemsModel> delProduct(SlingHttpServletRequest request, SlingHttpServletResponse response);

    ShoppingItemsModel upProduct(SlingHttpServletRequest request, SlingHttpServletResponse response);
}
