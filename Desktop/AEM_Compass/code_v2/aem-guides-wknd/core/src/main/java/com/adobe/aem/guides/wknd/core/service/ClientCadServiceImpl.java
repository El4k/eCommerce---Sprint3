package com.adobe.aem.guides.wknd.core.service;

import com.adobe.aem.guides.wknd.core.dao.ClientDao;
import com.adobe.aem.guides.wknd.core.models.ClientModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component(immediate = true, service = ClientCadService.class)
public class ClientCadServiceImpl implements ClientCadService {

    @Reference
    private DatabaseService databaseService;

    @Reference
    private ClientDao clientDao;

    @Override
    public ClientModel getClientDB(SlingHttpServletRequest req) {

        Integer id = Integer.parseInt(req.getParameter("ClientId"));

        ClientModel client = clientDao.getInfo(id);

        return client;
    }

    @Override
    public ClientModel getInformation() {
        return null;
    }

    @Override
    public List<ClientModel> verifyShopClientNull(SlingHttpServletRequest req) {
        try{
            ClientModel clientModel = new ClientModel();
            String name = req.getParameter("ClientUserame");

            if(name==null || name.isEmpty()){

                return (List<ClientModel>) clientModel;
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
    public ClientModel createClient(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        HttpSession session = request.getSession();

        Integer id = Integer.parseInt(request.getParameter("idClient"));
        String username = request.getParameter("usernameClient");
        String name = request.getParameter("nameClient");
        String password = request.getParameter("clientPassword");

        ClientModel clientModel = new ClientModel(id, username, name, password);

        clientModel = clientDao.createClient(clientModel);


        return clientModel;
    }

    @Override
    public ClientModel delClient(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        HttpSession session = request.getSession();

        Integer id = Integer.parseInt(request.getParameter("idClient"));

        ClientModel clientModel = clientDao.delProduct(id);

        return clientModel;
    }

    @Override
    public ClientModel upClient(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        HttpSession session = request.getSession();

        Integer id = Integer.parseInt(request.getParameter("idClient"));

        Integer newId = Integer.parseInt(request.getParameter("newIdClient"));
        String newUsername = request.getParameter("newUsernameClient");
        String newName = request.getParameter("newNameClient");
        String newPassword = request.getParameter("newPassword");

        ClientModel clientModel = new ClientModel(newId, newUsername, newName, newPassword);

        ClientModel client = clientDao.upClient(id, clientModel);

        return client;

    }
}
