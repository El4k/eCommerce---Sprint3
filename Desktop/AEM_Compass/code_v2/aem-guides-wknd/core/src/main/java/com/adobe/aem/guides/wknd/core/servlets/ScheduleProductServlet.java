package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.models.ShoppingItemsModel;
import com.adobe.aem.guides.wknd.core.service.DatabaseService;
import com.adobe.aem.guides.wknd.core.service.ScheduleProductService;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import static org.apache.sling.api.servlets.ServletResolverConstants.*;

@Component(service = {Servlet.class}, property = {
        SLING_SERVLET_PATHS + "=" + "/bin/app/registerProduct",
        SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,
        SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_POST,
        SLING_SERVLET_EXTENSIONS + "=" + "json"
})
@ServiceDescription("")
public class ScheduleProductServlet extends SlingAllMethodsServlet {

    private  Gson gson = new Gson();

    @Reference
    private DatabaseService databaseService;

    @Reference
    private ScheduleProductService scheduleProductService;

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
        ShoppingItemsModel shoppingItemsModel = new ShoppingItemsModel();
        shoppingItemsModel = scheduleProductService.addProduct(req, resp);
        String json = scheduleProductService.strToJson(shoppingItemsModel);
        resp.getWriter().write(json);

    }

    @Override
    protected void doPost(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException{
        List<ShoppingItemsModel> list = scheduleProductService.getScheduleProducts();
        String json = scheduleProductService.strToJson(list);
        resp.getWriter().write(json);
    }

    @Override
    protected void doDelete( SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        List<ShoppingItemsModel> shoppingItemsModel;
        shoppingItemsModel = scheduleProductService.delProduct(request, response);
        String json = scheduleProductService.strToJson(shoppingItemsModel);
        response.getWriter().write(json);

    }

    @Override
    protected void doPut( SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ShoppingItemsModel shoppingItemsModel = new ShoppingItemsModel();
        shoppingItemsModel = scheduleProductService.upProduct(request, response);
        String json = scheduleProductService.strToJson(shoppingItemsModel);
        response.getWriter().write(json);
    }

}