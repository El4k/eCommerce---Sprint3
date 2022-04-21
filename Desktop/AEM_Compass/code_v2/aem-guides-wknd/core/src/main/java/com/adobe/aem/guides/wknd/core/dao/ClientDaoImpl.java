package com.adobe.aem.guides.wknd.core.dao;

import com.adobe.aem.guides.wknd.core.models.ClientModel;
import com.adobe.aem.guides.wknd.core.service.DatabaseService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component(immediate = true, service = ClientDao.class)
public class ClientDaoImpl implements ClientDao{

    @Reference
    private DatabaseService databaseService;

    @Reference
    private ClientModel clientModel;

    @Override
    public ClientModel getInfo(Integer id) {
        try(Connection connection = databaseService.getConnection()){
            String sql = "SELECT * FROM client_table WHERE id_client = ?";


            try(PreparedStatement ps = connection.prepareStatement(sql)){

                ps.setInt(1, id);
                ps.execute();
                try(ResultSet rs = ps.getResultSet()){
                    clientModel.setId(rs.getInt(1));
                    clientModel.setUsername(rs.getString(2));
                    clientModel.setName(rs.getString(3));
                    clientModel.setPassword(rs.getString(4));
                }
                return clientModel;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ClientModel createClient(ClientModel clientModel) {
        try (Connection connection = databaseService.getConnection()) {
            String sql = "INSERT INTO client_table (id_client, username_client, name_client, password_client) VALUES(?,?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, clientModel.getId());
                preparedStatement.setString(2, clientModel.getUsername());
                preparedStatement.setString(3, clientModel.getName());
                preparedStatement.setString(4, clientModel.getPassword());
                preparedStatement.execute();

                return clientModel;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ClientModel delProduct(Integer id) {
        try(Connection connection = databaseService.getConnection()){
            String sql = "DELETE FROM client_table WHERE id_client = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

                preparedStatement.setInt(1, id);
                preparedStatement.execute();

                return getInfo(id);
            }
        }catch (Exception e){
            e.getMessage();
        }

        return null;
    }

    @Override
    public ClientModel upClient(Integer id, ClientModel clientModel) {
        try(Connection connection = databaseService.getConnection()){
            String sql = "SELECT * FROM client_table WHERE id_client = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();

                try (ResultSet resultSet = preparedStatement.getResultSet()) {



                    String sqlUpdate = "UPDATE client_table SET id_client =  ? ,  username_client = ? , name_client = ?, password_client = ? WHERE id_client = ?";
                    try (PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate)) {
                        preparedStatementUpdate.setInt(1, id);
                        preparedStatementUpdate.setString(2, clientModel.getUsername());
                        preparedStatementUpdate.setString(3, clientModel.getName());
                        preparedStatementUpdate.setString(4, clientModel.getPassword());
                        preparedStatementUpdate.setInt(5, clientModel.getId());
                        preparedStatementUpdate.execute();

                        return clientModel;
                    }
                }
            }
        }catch(Exception e){
            e.getMessage();
        }

        return null;

    }
}
