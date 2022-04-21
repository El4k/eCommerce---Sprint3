package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.models.ClientModel;
import com.adobe.aem.guides.wknd.core.service.ClientCadService;
import com.adobe.aem.guides.wknd.core.service.DatabaseService;
import com.google.gson.Gson;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

import static org.apache.sling.api.servlets.ServletResolverConstants.*;

@Component(service = {Servlet.class}, property = {
        SLING_SERVLET_PATHS + "=" + "/bin/app/registerClient",
        SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,
        SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_POST,
        SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_DELETE,
        SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_PUT,
        SLING_SERVLET_EXTENSIONS + "=" + "json"
})
@ServiceDescription("")
public class ClientCadServlet extends SlingAllMethodsServlet{
    private Gson gson = new Gson();

    @Reference
    private DatabaseService databaseService;

    @Reference
    private ClientCadService clientCadService;

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
        ClientModel clientModel = new ClientModel();
        clientModel = clientCadService.createClient(req, resp);
        String json = clientCadService.strToJson(clientModel);
        resp.getWriter().write(json);

    }



    @Override
    protected void doPost(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException{
        ClientModel client = clientCadService.getInformation();
        String json = clientCadService.strToJson(client);
        resp.getWriter().write(json);
    }

    @Override
    protected void doDelete( SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ClientModel client;
        client = clientCadService.delClient(request, response);
        String json = clientCadService.strToJson(client);
        response.getWriter().write(json);

    }

    @Override
    protected void doPut( SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ClientModel clientModel = new ClientModel();
        clientModel = clientCadService.upClient(request, response);
        String json = clientCadService.strToJson(clientModel);
        response.getWriter().write(json);
    }

}

