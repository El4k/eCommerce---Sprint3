package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.models.impl.CartImpl;
import com.adobe.aem.guides.wknd.core.service.Action;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@Component(service = {Servlet.class})
@SlingServletResourceTypes(
        resourceTypes = "wknd/components/page",
        methods = HttpConstants.METHOD_POST
)
public class SimpleNewServlet extends SlingAllMethodsServlet {

    private  Gson gson = new Gson();

    @Override
    protected void doPost(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException{
        try {


            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");

            CartImpl cart = new CartImpl();
            String paramAction = req.getParameter("action");
            String nameClass = "com.adobe.aem.guides.wknd.core.service." + paramAction;

            String name = null;
            try {
                Class classe = Class.forName(nameClass);
                Action action = (Action) classe.newInstance();
                name = action.executa(req, resp);
            } catch (Exception e) {
                e.getMessage();
            }
            String cartJson = this.gson.toJson(name);
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            out.print(cartJson);
            out.flush();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");

            CartImpl cart = new CartImpl();

            String paramAction = req.getParameter("action");
            String nameClass = "com.adobe.aem.guides.wknd.core.service." + paramAction;

            String name = null;
            try {
                Class classe = Class.forName(nameClass);
                Action action = (Action) classe.newInstance();
                name = action.executa(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String cartJson = this.gson.toJson(name);
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            out.print(cartJson);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}