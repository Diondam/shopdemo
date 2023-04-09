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
import java.util.ArrayList;

/**
 *
 * @author diond
 */
@WebServlet(name = "DeleteProServlet", urlPatterns = {"/delpro"})
public class DeleteProServlet extends HttpServlet {

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
            out.println("<title>Servlet DeleteProServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteProServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idDel = Integer.parseInt(request.getParameter("delid"));

        //lấy vị trí i của user và lấy chuỗi data chưa lọc user
        Cookie[] arrC = request.getCookies();
        String positionDel = "agddf";
        String temp = "";
        if (arrC != null) {
            for (Cookie c : arrC) {
                if (c.getName().equals("positionDel")) {
                    positionDel = c.getValue();
                }
                if (c.getName().equals("idArr")) {
                    temp += c.getValue();
                    c.setMaxAge(0);
                }
            }
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("positionDel: " + positionDel);
        //chuyển string data vào mảng để xóa theo vị trí
        String[] proUser = temp.split("/");
        ArrayList ProUser = new ArrayList();
        for (int i = 0; i < proUser.length; i++) {
            ProUser.add(proUser[i]);
        }

        //chuyển chuỗi vị trí sang mảng int các vị trí
        String[] posiRaw = positionDel.split("/");
        System.out.print("posiRaw: ");
        for (int i = 0; i < posiRaw.length; i++) {
            System.out.print(posiRaw[i] + "*");
        }
        System.out.println("");
        int posi[] = new int[posiRaw.length];
        for (int i = 0; i < posiRaw.length; i++) {
            posi[i] = Integer.parseInt(posiRaw[i]);
        }

        //xóa dâta tại các vị trí được xác định
        int count = 0;
        for (int j = 0; j < posi.length; j++) {
            String[] n = proUser[j].split(":");
            int idPro = Integer.parseInt(n[0]);
            if (idDel == idPro) {
                ProUser.remove((posi[j] - count));
                count++;
            }

        }

        System.out.println(ProUser.toString());
        //tạo cookie mới : gắn array thành chuỗi
        String tempp = "";

        for (int i = 0; i < ProUser.size(); i++) {
            tempp += ProUser.get(i) + "/";
        }
        Cookie c = new Cookie("idArr", tempp);
        c.setMaxAge(2 * 24 * 60 * 60);
        response.addCookie(c);
        System.out.println("update cookie finished");
        response.sendRedirect("card");
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
