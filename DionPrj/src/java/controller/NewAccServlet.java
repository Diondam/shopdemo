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

/**
 *
 * @author diond
 */
@WebServlet(name = "NewAccServlet", urlPatterns = {"/newacc"})
public class NewAccServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("newacc", 1);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        System.out.println("pass: "+ pass);
        String repass = request.getParameter("repass");
        System.out.println("repass: "+ repass);
        String email = request.getParameter("email");
        String add = request.getParameter("add");
        int phone = Integer.parseInt(request.getParameter("phone"));
        int role = 3;
        DAO d = new DAO();
        int id = 999;
        if (!pass.equals(repass)) {
            request.setAttribute("repassW", "Nhập sai repass");
            request.getRequestDispatcher("login").forward(request, response);
            return;
        }
        try {
            d.loadUser();
            id = d.getUser().size() + 1;
            d.insertUser(name, pass, id, email, add, phone, false, role, true);
            System.out.println("insert acc successfull");
        } catch (Exception e) {
            System.out.println(d.getStatus() + e.getMessage());
        }
        request.setAttribute("repassW", "");
        
        
        System.out.println("id: "+ id );
        System.out.println("mail: "+ email);
        request.setAttribute("id", id);
        request.setAttribute("email", email);
        request.getRequestDispatcher("email").forward(request, response);
        System.out.println("da chuyen huong sang mail");
//
//         request.setAttribute("mis", "haohanquanhi");
//        request.getRequestDispatcher("email").forward(request, response);
    }

}


