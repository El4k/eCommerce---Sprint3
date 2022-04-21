package com.adobe.aem.guides.wknd.core.service;

import com.adobe.aem.guides.wknd.core.dao.ShoppingItemsDao;
import com.adobe.aem.guides.wknd.core.models.Categoria;
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
public class ScheduleProductServiceImpl implements ScheduleProductService{

    @Reference
    private DatabaseService databaseService;

    @Reference
    private ShoppingItemsDao shoppingItemsDao;

    @Override
    public List<ShoppingItemsModel> getProductDB() {

        List<ShoppingItemsModel> shopList = new ArrayList<>();

        shopList = shoppingItemsDao.getScheduleShopping();

        return shopList;
    }

    @Override
    public List<ShoppingItemsModel> getScheduleProducts() {
        return null;
    }

    @Override
    public List<ShoppingItemsModel> verifyShopNull(SlingHttpServletRequest req) {
        try{
            ShoppingItemsModel shopItem = new ShoppingItemsModel();
            List<ShoppingItemsModel> shopList = new ArrayList<>();
            String name = req.getParameter("productName");

            if(name==null || name.isEmpty()){
                shopList = shopItem.getScheduleShopping();
                List<ShoppingItemsModel> shopTemp = new ArrayList<>();
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
    public ShoppingItemsModel addProduct(SlingHttpServletRequest request, SlingHttpServletResponse response) {

        HttpSession session = request.getSession();

        Integer id = Integer.parseInt(request.getParameter("idProduct"));
        String name = request.getParameter("nameProduct");
        Categoria categoria = Categoria.valueOf(request.getParameter("categoriaProduct"));
        Double price = Double.parseDouble(request.getParameter("priceProduct"));
        Integer amount = Integer.parseInt(request.getParameter("amountProduct"));;

        ShoppingItemsModel shopItem = new ShoppingItemsModel(id, name, categoria, price, amount);

        shopItem = shoppingItemsDao.addProduct(shopItem);

        return shopItem;
    }

    @Override
    public List<ShoppingItemsModel> delProduct(SlingHttpServletRequest request, SlingHttpServletResponse response) {

        HttpSession session = request.getSession();

            Integer id = Integer.parseInt(request.getParameter("idProduct"));

            List<ShoppingItemsModel> shopList = shoppingItemsDao.delProduct(id);

            return shopList;
    }

    @Override
    public ShoppingItemsModel upProduct(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        HttpSession session = request.getSession();

        Integer id = Integer.parseInt(request.getParameter("idProduct"));

        Integer newId = Integer.parseInt(request.getParameter("newIdProduct"));
        String newName = request.getParameter("newNameProduct");
        Categoria newCategoria = Categoria.valueOf(request.getParameter("newCategoriaProduct"));
        Double newPrice = Double.parseDouble(request.getParameter("newPriceProduct"));
        Integer newAmount = Integer.parseInt(request.getParameter("newIdAmount"));

        ShoppingItemsModel shoppingItemsModel = new ShoppingItemsModel(newId, newName, newCategoria ,newPrice, newAmount);

        ShoppingItemsModel shoppingItem = shoppingItemsDao.upProduct(id, shoppingItemsModel);

        return shoppingItem;

    }
}
