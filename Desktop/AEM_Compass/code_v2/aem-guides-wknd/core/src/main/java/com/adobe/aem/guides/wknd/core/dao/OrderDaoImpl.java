package com.adobe.aem.guides.wknd.core.dao;

import com.adobe.aem.guides.wknd.core.models.ClientModel;
import com.adobe.aem.guides.wknd.core.models.OrderModel;
import com.adobe.aem.guides.wknd.core.models.ShoppingItemsModel;
import com.adobe.aem.guides.wknd.core.service.DatabaseService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component (immediate = true, service = OrderDao.class)
public class OrderDaoImpl implements OrderDao{

    @Reference
    private DatabaseService databaseService;

    @Reference
    private OrderModel orderModel;

    @Override
    public List<OrderModel> getOrder(Integer id) {
        try(Connection connection = databaseService.getConnection()){
            String sql = "SELECT * FROM order_table where id_order = ?";

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, id);
                ps.execute();
                try(ResultSet rs = ps.getResultSet()){
                    List<OrderModel> shopList = new ArrayList<>();
                    while (rs.next()){
                        OrderModel orderItem = new OrderModel();
                        orderItem.setId(rs.getInt(1));
                        orderItem.setClient((ClientModel) rs.getObject(2));
                        orderItem.setOrderList((ShoppingItemsModel) rs.getObject(3));
                        shopList.add(orderItem);
                    }
                    return shopList;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderModel> getOrderList(Integer id) {
        try(Connection connection = databaseService.getConnection()){
            String sql = "SELECT * FROM order_table where id_client = ?";

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, id);
                ps.execute();
                try(ResultSet rs = ps.getResultSet()){
                    List<OrderModel> shopList = new ArrayList<>();
                    while (rs.next()){
                        OrderModel orderItem = new OrderModel();
                        orderItem.setId(rs.getInt(1));
                        orderItem.setClient((ClientModel) rs.getObject(2));
                        orderItem.setOrderList((ShoppingItemsModel) rs.getObject(3));
                        shopList.add(orderItem);
                    }
                    return shopList;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ShoppingItemsModel> addProduct(ShoppingItemsModel shoppingItemsModel, OrderModel orderModel) {
        try (Connection connection = databaseService.getConnection()) {
            String sql = "INSERT INTO order_table (id_order, shop_item_order, shop_amount_order) VALUES(?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, orderModel.getId());
                preparedStatement.setInt(2, shoppingItemsModel.getId());
                preparedStatement.setInt(3, shoppingItemsModel.getAmount());
                preparedStatement.execute();

                String sqlCreateList = "SELECT * FROM order_table WHERE id_order = ?";

                try(PreparedStatement ps = connection.prepareStatement(sqlCreateList)) {
                    preparedStatement.setInt(1, orderModel.getId());

                    ps.execute();
                    try (ResultSet rs = ps.getResultSet()) {
                        List<ShoppingItemsModel> shopList = new ArrayList<>();
                        while (rs.next()) {
                            ShoppingItemsModel shopItem = new ShoppingItemsModel();
                            shopItem.setId(rs.getInt(2));
                            shopItem.setAmount(rs.getInt(3));
                            shopList.add(shopItem);
                        }
                        return shopList;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<OrderModel> delProduct(ShoppingItemsModel shoppingItemsModel, OrderModel orderModel) {
        try(Connection connection = databaseService.getConnection()){
            String sql = "DELETE FROM order_table WHERE id_order = ? AND shop_item_order = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

                preparedStatement.setInt(1, orderModel.getId());
                preparedStatement.setInt(2, shoppingItemsModel.getId());
                preparedStatement.execute();

                return getOrder(orderModel.getId());
            }
        }catch (Exception e){
            e.getMessage();
        };
        return null;
    }

    @Override
    public List<ShoppingItemsModel> searchProducts(String keyWord) {
        try(Connection connection = databaseService.getConnection()){
            String sql = "SELECT * FROM products_table WHERE name_product LIKE ? OR categoria_product LIKE ?";

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, keyWord);
                ps.setString(2, keyWord);
                ps.execute();
                try(ResultSet rs = ps.getResultSet()){
                    List<ShoppingItemsModel> shopList = new ArrayList<>();
                    while (rs.next()){
                        ShoppingItemsModel shopItem = new ShoppingItemsModel();
                        shopItem.setId(rs.getInt(1));
                        shopItem.setName(rs.getString(2));
                        shopItem.setPrice(rs.getDouble(3));
                        shopItem.setAmount(rs.getInt(4));
                        shopList.add(shopItem);
                    }
                    return shopList;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ShoppingItemsModel> addClient(ClientModel clientModel, OrderModel orderModel) {
        try (Connection connection = databaseService.getConnection()) {
            String sql = "UPDATE order_table SET client_order = ? WHERE id_order = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, clientModel.getId());
                preparedStatement.setInt(2, orderModel.getId());
                preparedStatement.execute();

                String sqlCreateList = "SELECT * FROM order_table WHERE id_order = ?";

                try(PreparedStatement ps = connection.prepareStatement(sqlCreateList)) {
                    preparedStatement.setInt(1, orderModel.getId());

                    ps.execute();
                    try (ResultSet rs = ps.getResultSet()) {
                        List<ShoppingItemsModel> shopList = new ArrayList<>();
                        while (rs.next()) {
                            ShoppingItemsModel shopItem = new ShoppingItemsModel();
                            shopItem.setId(rs.getInt(2));
                            shopItem.setAmount(rs.getInt(3));
                            shopList.add(shopItem);
                        }
                        return shopList;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}
