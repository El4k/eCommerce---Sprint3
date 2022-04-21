package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.models.OrderModel;
import com.adobe.aem.guides.wknd.core.models.ShoppingItemsModel;
import com.adobe.aem.guides.wknd.core.service.DatabaseService;
import com.adobe.aem.guides.wknd.core.service.OrderService;
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
        SLING_SERVLET_PATHS + "=" + "/bin/app/cart",
        SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,
        SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_POST,
        SLING_SERVLET_EXTENSIONS + "=" + "json"
})
@ServiceDescription("")
public class ClientViewServlet  extends SlingAllMethodsServlet {

    private Gson gson = new Gson();

    @Reference
    private DatabaseService databaseService;

    @Reference
    private OrderService orderService;

    @Override
    protected void doGet( SlingHttpServletRequest request,  SlingHttpServletResponse response) throws ServletException, IOException {
        List<ShoppingItemsModel> list = orderService.addProduct(request, response);
        String json = orderService.strToJson(list);
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(SlingHttpServletRequest request,  SlingHttpServletResponse response) throws ServletException, IOException {
        List<ShoppingItemsModel> list = orderService.searchProducts(request, response);
        String json = orderService.strToJson(list);
        response.getWriter().write(json);
    }

    @Override
    protected void doPut( SlingHttpServletRequest request,  SlingHttpServletResponse response) throws ServletException, IOException {
        List<ShoppingItemsModel> list = orderService.addClient(request, response);
        String json = orderService.strToJson(list);
        response.getWriter().write(json);
    }

    @Override
    protected void doDelete(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        List<OrderModel> list = orderService.delProduct(request, response);
        String json = orderService.strToJson(list);
        response.getWriter().write(json);
    }
}
