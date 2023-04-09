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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Product;
import model.User;

/**
 *
 * @author diond
 */
@WebServlet(name = "CardServlet", urlPatterns = {"/card"})
public class CardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //lấy cookies
        Cookie[] arrC = request.getCookies();
        String temp = "";
        if (arrC != null) {
            for (Cookie c : arrC) {
                if (c.getName().equals("idArr")) {
                    temp += c.getValue();
                }
            }
        }

        //gán các giá trị vào mảng để xử lí, cho từng user riêng biệt, nhỡ nó có 2 acc
        ArrayList proArr = new ArrayList();
        ArrayList cliArr = new ArrayList();
        try {
            String[] proUser = temp.split("/");
            for (String i : proUser) {
                String[] n = i.split(":");
                int idPro = Integer.parseInt(n[0]);
                int idCli = Integer.parseInt(n[1]);
                proArr.add(idPro);
                cliArr.add(idCli);
            }
        } catch (Exception e) {
            System.out.println("méo có cookies");
        }
        System.out.println("proARR size: " + proArr.size());
        //sử lí data bắn ngược lại jsp thông qua 1 con temp Product
        List<Product> listproArrTemp = new ArrayList<>();
        DAO d = new DAO();
        d.loadProduct();
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        HashMap<Integer, Product> pro = d.getProd();
        System.out.println("____________________________________________________");
        ArrayList filterIdP = new ArrayList();
        int quantityR = 0;
        ArrayList proCurrent = new ArrayList();;
        ArrayList quantity = new ArrayList();
        String positionDel = "";
        for (int i = 0; i < proArr.size(); i++) {
            if ((int) cliArr.get(i) == u.getId()) {
                System.out.println("i=" + i);
                positionDel += i + "/";
                int idPro = pro.get(proArr.get(i)).getId();
                proCurrent.add(idPro);
                //id hiện tại mà khác id trong bảng thì add
                boolean tempL = true;
                //nếu ban đầu trống thì phải add thêm vào
                if (filterIdP.isEmpty()) {
                    filterIdP.add(idPro);
//                    System.out.println("size: " + filterIdP.size());
                }
                for (int z = 0; z < filterIdP.size(); z++) {
//                    System.out.println("z: " + z);
//                    System.out.println("idPro: " + idPro);
//                    System.out.println("filterIdP.get(z): " + (int) filterIdP.get(z));
                    if (idPro == (int) filterIdP.get(z)) {
                        tempL = false;
                    }
                }
                if (tempL) {
                    filterIdP.add(idPro);
//                    System.out.println("add--" + idPro);
//                    System.out.println("filterIDsize = " + filterIdP.size());
                }
            }
        }
        Cookie pos = new Cookie("positionDel", positionDel);
        pos.setMaxAge(2 * 24 * 60 * 60);
        response.addCookie(pos);
//        System.out.println("size ProCurrent: " + proCurrent.size());

        ArrayList proTemp = new ArrayList();
        for (int q = 0; q < proCurrent.size(); q++) {
            boolean tempQ = true;
            if (proTemp.isEmpty()) {
                proTemp.add(-5);
            }
//            System.out.println("proCurrent: " + proCurrent.get(q));
//            for (int p = 0; p < proTemp.size(); p++) {
//                System.out.print(proTemp.get(p) + "*");
//            }
//            System.out.println("");
            for (int s = 0; s < proTemp.size(); s++) {
                if (proCurrent.get(q) == proTemp.get(s)) {
                    tempQ = false;
                }
            }
            if (tempQ) {
                proTemp.add(proCurrent.get(q));
//                System.out.println("add+ "+ proCurrent.get(q));
                for (int j = 0; j < proCurrent.size(); j++) {
                    if (proCurrent.get(q) == proCurrent.get(j)) {
                        quantityR++;
                    }
                }
                quantity.add(quantityR);
                quantityR = 0;
            }

//            System.out.println("size quantity: " + quantity.size());
        }
//
//        for (int i = 0; i < filterIdP.size(); i++) {
//            System.out.print(filterIdP.get(i) + "--");
//        }
        System.out.println("");
        for (int r = 0; r < filterIdP.size(); r++) {
            String nameRaw = pro.get(filterIdP.get(r)).getName();
            String name = nameRaw.trim();
            float price = pro.get(filterIdP.get(r)).getPrice();
            int idPro = pro.get(filterIdP.get(r)).getId();
            System.out.print(quantity.get(r) + "--");
            listproArrTemp.add(new Product(idPro, name, "", "", (int) quantity.get(r), "", 0, price, 0));
        }
        //nếu có id trong list locj kia thì add

        System.out.println("size listproArrTemp: " + listproArrTemp.size());
        request.setAttribute("proArrTemp", listproArrTemp);
        request.getRequestDispatcher("card.jsp").forward(request, response);
    }

    //tạo order add vào database.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] id = request.getParameterValues("id");
        String[] quantity = request.getParameterValues("quantity");
        //nếu quantity của sản phẩm lớn hơn số lượng trong kho thì bắn ngược lại chỉnh sửa lại
        DAO d = new DAO();
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        d.loadProduct();
        Collection<Product> values = d.getProd().values();
        List<Product> pro = new ArrayList<>(values);
        //từ mỗi cái id lấy ra thông tin của product rồi set quantity ở cùng 1 lần duyệt
        for (int i = 0; i < id.length; i++) {

            int clientID = u.getId();
            int productID = Integer.parseInt(id[i]);
            int shopID = 0;//get bang producid
            for (Product p : pro) {
                if (p.getId() == productID) {
                    shopID = p.getSellid();
                    break;
                }
            }
            int quantityOr = Integer.parseInt(quantity[i]);
            d.loadOrder();
            
            int orderID = d.getOrder().size()+1;//getorder++
            System.out.println("new iD:"+ orderID);
            d.createOrder(clientID, productID, shopID, quantityOr, orderID);
            System.out.println("create order OKK");
        }
        request.setAttribute("ok", true);
        doGet(request, response);
        //add vào database

        //chuyển data về card thanh toán, chuyển đối tượng vào 1 list temp chuyển sang bên kia.
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
