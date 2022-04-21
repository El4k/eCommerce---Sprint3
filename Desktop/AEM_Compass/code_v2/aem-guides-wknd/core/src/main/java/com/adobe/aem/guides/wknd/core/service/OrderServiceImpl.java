package com.adobe.aem.guides.wknd.core.service;

import com.adobe.aem.guides.wknd.core.dao.OrderDao;
import com.adobe.aem.guides.wknd.core.models.ClientModel;
import com.adobe.aem.guides.wknd.core.models.OrderModel;
import com.adobe.aem.guides.wknd.core.models.ShoppingItemsModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = ScheduleProductService.class)
public class OrderServiceImpl implements OrderService{

    @Reference
    private DatabaseService databaseService;

    @Reference
    private OrderDao orderDao;

    @Reference
    private ClientCadService clientCadService;

    @Override
    public List<OrderModel> getOrderList(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        List<OrderModel> orderlist = new ArrayList<>();

        Integer id = Integer.parseInt(request.getParameter("idClient"));
        orderlist = orderDao.getOrderList(id);

        return orderlist;
    }

    @Override
    public List<OrderModel> verifyOrderNull(SlingHttpServletRequest req) {
        try{
            OrderModel orderItem = new OrderModel();
            List<OrderModel> shopList = new ArrayList<>();
            Integer id = Integer.parseInt(req.getParameter("orderId"));

            if(id==null){
                shopList = orderDao.getOrderList(id);
                List<OrderModel> shopTemp = new ArrayList<>();
                shopTemp = shopList;
                return shopTemp;
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public String strToJson(Object object){
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(object);
    }

    @Override
    public List<ShoppingItemsModel> addProduct(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        HttpSession session = request.getSession();

        Integer id = Integer.parseInt(request.getParameter("idOrder"));
        Integer idProduct = Integer.parseInt(request.getParameter("idProduct"));
        Integer amount = Integer.parseInt(request.getParameter("amountProduct"));;

        ShoppingItemsModel shopItem = new ShoppingItemsModel(idProduct, amount);
        OrderModel orderModel = new OrderModel(id, shopItem);

        List<ShoppingItemsModel> shopList = new ArrayList<>();

        shopList = orderDao.addProduct(shopItem, orderModel);


        return shopList;
    }

    @Override
    public List<OrderModel> delProduct(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        HttpSession session = request.getSession();

        Integer id = Integer.parseInt(request.getParameter("idOrder"));
        Integer idProduct = Integer.parseInt(request.getParameter("idProduct"));
        Integer amount = Integer.parseInt(request.getParameter("amountProduct"));

        ShoppingItemsModel shoppingItemsModel = new ShoppingItemsModel(idProduct, amount);
        OrderModel orderModel = new OrderModel(id);
        List<OrderModel> shopList = orderDao.delProduct(shoppingItemsModel, orderModel);

        return shopList;
    }

    @Override
    public List<ShoppingItemsModel> searchProducts(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        HttpSession session = request.getSession();

        String name = request.getParameter("word");
        List<ShoppingItemsModel> shopList = orderDao.searchProducts(name);

        return shopList;
    }

    @Override
    public List<ShoppingItemsModel> addClient(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        HttpSession session = request.getSession();

        Integer id = Integer.parseInt(request.getParameter("idOrder"));
        Integer idClient = Integer.parseInt(request.getParameter("idClient"));


        ClientModel clientModel = clientCadService.getClientDB(request);
        OrderModel orderModel = new OrderModel(id);

        List<ShoppingItemsModel> listShop = orderDao.addClient(clientModel, orderModel);

        return listShop;
    }
}
