/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import model.Product;

/**
 *
 * @author diond
 */
@WebServlet(name = "EditProServlet", urlPatterns = {"/editpro"})
public class EditProServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DAO d = new DAO();
        d.loadProduct();
        for (Map.Entry<Integer, Product> p : d.getProd().entrySet()) {
            Integer key = p.getKey();
            Product pr = p.getValue();
            if (id == key) {
                request.setAttribute("edit", true);
                request.setAttribute("pro", pr);
                request.getRequestDispatcher("sell").forward(request, response);
                System.out.println("pro name: " + pr.getName());
                break;
//                d.updateProduct(pr.getId(), pr.getName(), pr.getDescription(), pr.getImg(), 0, 0, 0);

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String img = request.getParameter("img");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int cateID = Integer.parseInt(request.getParameter("cateID"));
        int proID = Integer.parseInt(request.getParameter("proID"));
        int sellid = Integer.parseInt(request.getParameter("sellid"));
        System.out.println("tao la moi nhat: " + price);
        DAO d = new DAO();
        d.loadProduct();
        for (Map.Entry<Integer, Product> p : d.getProd().entrySet()) {
            Integer key = p.getKey();
            Product pr = p.getValue();
            if (proID == key) {
                try {
                    d.updateProduct(proID, name, description, img, quantity, cateID, price, sellid);
                    System.out.println("update successfull");

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
        request.getRequestDispatcher("sell").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
