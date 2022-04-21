package com.adobe.aem.guides.wknd.core.dao;

import com.adobe.aem.guides.wknd.core.models.ClientModel;

public interface ClientDao {

    ClientModel getInfo(Integer id);

    ClientModel createClient(ClientModel clientModel);

    ClientModel delProduct(Integer id);

    ClientModel upClient(Integer id, ClientModel clientModel);
}
