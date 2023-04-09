/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/** vao 
 *vao thi lai
 * @author diond
 */
@WebServlet(name = "AddCardServlet", urlPatterns = {"/addcard"})
public class AddCardServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCardServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCardServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //tải cook về chỉnh sửa rồi gắn lại
        
        //lấy cook, xóa cook cũ
        Cookie[] arrC=request.getCookies();
        String temp="";
        if(arrC!=null){
            for(Cookie c:arrC){
                if(c.getName().equals("idArr")){
                    temp+=c.getValue();
                    c.setMaxAge(0);
                }
            }
        }
//        System.out.println("lấy được cookie, hủy cookie cũ");
        
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        
        //set cook
        
        String id=request.getParameter("id");
        temp= temp + id + ":" + u.getId()+ "/";
        System.out.println("+1 product to Cookie");
        Cookie c=new Cookie("idArr", temp);
        c.setMaxAge(2*24*60*60);
        response.addCookie(c);
//        System.out.println("add lại cookie");
        response.sendRedirect("home");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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


// vãi thị đái ạ, chất như nước cất.