package com.adobe.aem.guides.wknd.core.dao;

import com.adobe.aem.guides.wknd.core.models.ShoppingItemsModel;
import com.adobe.aem.guides.wknd.core.service.DatabaseService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component (immediate = true, service = ShoppingItemsDao.class)
public class ShoppingItemsDaoImpl implements ShoppingItemsDao {

    @Reference
    private DatabaseService databaseService;

    @Reference
    private ShoppingItemsModel shoppingItemsModel;

    @Override
    public List<ShoppingItemsModel> getScheduleShopping() {
        try(Connection connection = databaseService.getConnection()){
            String sql = "SELECT * FROM products_table";

            try(PreparedStatement ps = connection.prepareStatement(sql)){
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
    public ShoppingItemsModel addProduct(ShoppingItemsModel shopItem) {
        try (Connection connection = databaseService.getConnection()) {
            String sql = "INSERT INTO product_table (id_product, name_product,categoria_product , price_product, amount_product) VALUES(?,?,?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, shopItem.getId());
                preparedStatement.setString(2, shopItem.getName());
                preparedStatement.setString(3, String.valueOf(shopItem.getCategoria()));
                preparedStatement.setDouble(4, shopItem.getPrice());
                preparedStatement.setInt(5, shopItem.getAmount());
                preparedStatement.execute();

                return shopItem;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ShoppingItemsModel> delProduct(Integer id){
        try(Connection connection = databaseService.getConnection()){
            String sql = "DELETE FROM product_table WHERE id_product = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            return getScheduleShopping();
        }
    }catch (Exception e){
        e.getMessage();
    }

        return null;
    }

    @Override
    public ShoppingItemsModel upProduct(Integer id, ShoppingItemsModel shoppingItemsModel) {
        try(Connection connection = databaseService.getConnection()){
            String sql = "SELECT * FROM product_table WHERE id_product = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();

                try (ResultSet resultSet = preparedStatement.getResultSet()) {



                    String sqlUpdate = "UPDATE product_table SET id_product =  ? ,  name_product = ? , categoria_product , price_product = ?, amount_product = ? WHERE id_product = ?";
                    try (PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate)) {
                        preparedStatementUpdate.setInt(1, id);
                        preparedStatementUpdate.setString(2, shoppingItemsModel.getName());
                        preparedStatementUpdate.setString(3, String.valueOf(shoppingItemsModel.getCategoria()));
                        preparedStatementUpdate.setDouble(4, shoppingItemsModel.getPrice());
                        preparedStatementUpdate.setInt(5, shoppingItemsModel.getAmount());
                        preparedStatementUpdate.setInt(6, shoppingItemsModel.getId());
                        preparedStatementUpdate.execute();

                        return shoppingItemsModel;
                    }
                }
            }
        }catch(Exception e){
            e.getMessage();
        }

        return null;

    }

    }
