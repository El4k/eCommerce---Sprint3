package com.adobe.aem.guides.wknd.core.service;

import com.adobe.aem.guides.wknd.core.models.ClientModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import java.util.List;

public interface ClientCadService {

    ClientModel getClientDB(SlingHttpServletRequest req);
    ClientModel getInformation();
    List<ClientModel> verifyShopClientNull(SlingHttpServletRequest req);
    String strToJson(Object object);
    ClientModel createClient( SlingHttpServletRequest request, SlingHttpServletResponse response);
    ClientModel delClient(SlingHttpServletRequest request, SlingHttpServletResponse response);
    ClientModel upClient(SlingHttpServletRequest request, SlingHttpServletResponse response);
}