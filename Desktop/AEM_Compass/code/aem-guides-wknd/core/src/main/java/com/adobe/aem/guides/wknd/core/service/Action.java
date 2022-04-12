package com.adobe.aem.guides.wknd.core.service;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

public interface Action {
    public String executa(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException;

}
