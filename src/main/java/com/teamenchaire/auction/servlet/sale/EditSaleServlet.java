package com.teamenchaire.auction.servlet.sale;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamenchaire.auction.servlet.ServletDispatcher;

/**
 * A {@code Servlet} which handles requests to the page to edit a sale.
 * 
 * @author Marin Taverniers
 */
@WebServlet("/sale/edit/*")
public final class EditSaleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        new ServletDispatcher(request, response).sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}