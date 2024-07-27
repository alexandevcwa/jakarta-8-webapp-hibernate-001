package com.alexandevcwa.servlet;

import com.alexandevcwa.orm.PostgreSQLSessionFactory;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author AlexanDev_CWA
 */
@WebServlet(name = "SvClient", urlPatterns = {"/SvClient", "/svclient"})
public class SvClient extends HttpServlet {

    @Inject
    private PostgreSQLSessionFactory sessionFactory;

    private Validator validator;

    @Override
    public void init() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String nit = request.getParameter("nit");
    }
}
