/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import model.Category;
import model.Order;
import model.Product;
import model.User;

/**
 *
 * @author diond
 */
public class DAO {

    public static void main(String[] args) {
        DAO d = new DAO();
        d.loadUser();
        System.out.println(d.getUser().size());
    }

    private String status;
    private HashMap<Integer, User> user;
    private HashMap<Integer, Product> prod;
    private ArrayList<Order> order;
    private ArrayList<Category> cate;

    public ArrayList<Category> getCate() {
        return cate;
    }

    public void setCate(ArrayList<Category> cate) {
        this.cate = cate;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * ***********************************************************************************************************************
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<Integer, User> getUser() {
        return user;
    }

    public void setUser(HashMap<Integer, User> user) {
        this.user = user;
    }

    public HashMap<Integer, Product> getProd() {
        return prod;
    }

    public void setProd(HashMap<Integer, Product> prod) {
        this.prod = prod;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }

    /**
     * ***********************************************************************************************************************
     */
    private Connection con;

    public DAO() {
        try {
            con = new DBContext().getConnection();
            status = "connect successful";
        } catch (Exception e) {
            status = "connect error" + e.getMessage();
        }
    }

    /**
     * CATEGORY ***********************************************************************************************************************
     */
    public void loadCategory() {
        cate = new ArrayList<>();
        String sql = "select * from Category_HE161829";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String desc = rs.getString("desc");
                int id = rs.getInt("id");
                cate.add(new Category(name, id, desc));
                status = "load Category successful";
            }
        } catch (SQLException e) {
            status = "error at load Category" + e.getMessage();

        }
    }

    /**
     * ***********************************************************************************************************************
     */
    public void loadUser() {
        user = new HashMap<>();
        String sql = "select * from [User_HE161829]";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("userID");
                String name = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
                String email = rs.getString("email");
                String add = rs.getString("address");
                String pass = rs.getString("password");
                int role = rs.getInt("role");
                boolean active = rs.getBoolean("active");
                int phone = rs.getInt("phoneNum");
                user.put(id, new User(name, gender, pass, id, email, add, phone, active, role));
            }
            status = "load User thanh cong";
        } catch (SQLException e) {
            status = "error at load User" + e.getMessage();
        }
        System.out.println(status);
    }

    public void insertUser(String name, String pass, int id, String email, String add, int phone, boolean active, int role, boolean gender) {
        String sql = "INSERT INTO [dbo].[User_HE161829]\n"
                + "           ([name]\n"
                + "           ,[password]\n"
                + "           ,[userID]\n"
                + "           ,[email]\n"
                + "           ,[address]\n"
                + "           ,[phoneNum]\n"
                + "           ,[role]\n"
                + "           ,[active]\n"
                + "           ,[gender])\n"
                + "     VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(4, email);
            ps.setString(5, add);
            ps.setBoolean(8, active);
            ps.setBoolean(9, gender);
            ps.setInt(3, id);
            ps.setInt(6, phone);
            ps.setInt(7, role);
            ps.execute();
            status = "insert user successful";
        } catch (SQLException e) {
            status = "error at Insert User" + e.getMessage();

        }
    }

    public void updateUser(String name, String pass, int id, String email, String add, int phone, boolean active, int role, boolean gender) {
        String sql = "UPDATE [dbo].[User_HE161829]\n"
                + "   SET [name] = ?\n"
                + "      ,[password] =?\n"
                + "      ,[gender] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[phoneNum] = ?\n"
                + "      ,[role] = ?\n"
                + "      ,[active] = ?\n"
                + " WHERE [userID] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(4, email);
            ps.setString(5, add);
            ps.setBoolean(8, active);
            ps.setBoolean(3, gender);
            ps.setInt(9, id);
            ps.setInt(6, phone);
            ps.setInt(7, role);
            ps.execute();
            status = "update user successful";
        } catch (SQLException e) {
            status = "error at Update User" + e.getMessage();

        }
    }

    public void deleteUser(int id) {
        String sql = "delete from [User_HE161829] where [userID] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            status = "delete user successful int DAO";
            System.out.println(status);

        } catch (SQLException e) {
            status = "error at Delete User" + e.getMessage();
            System.out.println(status);

        }
    }

    /**
     * ***********************************************************************************************************************
     */
    public void loadProduct() {
        prod = new HashMap<>();
        String sql = "select * from Product_HE161829";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                java.util.Date dateRaw = rs.getTimestamp("date");
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                String date = sdf.format(dateRaw);
                String img = rs.getString("img");
                String description = rs.getString("description");
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                int cateID = rs.getInt("cateID");
                float price = rs.getFloat("price");
                int shopID = rs.getInt("shopID");
                prod.put(id, new Product(id, name, date, img, quantity, description, cateID, price, shopID));
                status = "load Product successful";
            }
        } catch (SQLException e) {
            status = "error at load Product" + e.getMessage();
        }
    }

    public void insertProduct(int id, String name, String desc, String img, int quantity, int CateID, float price, int shopID) {
        String sql = "INSERT INTO [dbo].[Product_HE161829]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[price]\n"
                + "           ,[date]\n"
                + "           ,[img]\n"
                + "           ,[quantity]\n"
                + "           ,[description]\n"
                + "           ,[cateID]\n"
                + "           ,[shopID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            ps.setString(2, name);
            ps.setString(5, img);
            ps.setString(7, desc);
            ps.setTimestamp(4, timestamp);
            ps.setInt(9, shopID);
            ps.setInt(8, CateID);
            ps.setInt(6, quantity);
            ps.setInt(1, id);
            ps.setFloat(3, price);
            ps.execute();
            status = "inser product successful";
            System.out.println(status);

        } catch (SQLException e) {
            status = "error at Insert Product" + e.getMessage();
            System.out.println(status);
        }
    }

    public void updateProduct(int id, String name, String desc, String img, int quantity, int CateID, float price, int shopID) {
        String sql = "UPDATE [dbo].[Product_HE161829]\n"
                + "   SET [id] = ?\n"
                + "      ,[name] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[date] = ?\n"
                + "      ,[img] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[cateID] = ?\n"
                + "      ,[shopID] = ?\n"
                + " WHERE [id] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            ps.setString(2, name);
            ps.setString(5, img);
            ps.setString(7, desc);
            ps.setTimestamp(4, timestamp);
            ps.setInt(9, shopID);
            ps.setInt(10, id);
            ps.setInt(8, CateID);
            ps.setInt(6, quantity);
            ps.setInt(1, id);
            ps.setFloat(3, price);
            ps.execute();
            status = "update in DAO product successful";
            System.out.println(status);
        } catch (SQLException e) {
            status = "error at update Product" + e.getMessage();
            System.out.println(status);
        }
    }

    public void deleteProduct(int id) {
        String sql = "delete from Product_HE161829 where [id] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            status = "delete product successful";
            System.out.println(status);

        } catch (SQLException e) {
            status = "error at Delete Product" + e.getMessage();
            System.out.println(status);

        }
    }

    /**
     * ***********************************************************************************************************************
     */
//
    public void loadOrder() {
        String sql = "select   rr.nameCli, rr.quantityOr, rr.dateOrder, rr.name as namePro, s.nameShop, rr.orderID\n"
                + "			from(select * from Product_HE161829 p right join\n"
                + "             (select u.name as nameCli, o.quantityOr, o.dateOrder, o.productID,o.orderID from [User_HE161829] u inner join\n"
                + "               [Order_HE161829] o on u.userID = o.clientID) c\n"
                + "              on p.id = c.productID) rr\n"
                + "			inner join Shop_HE161829 s on s.shopID= rr.shopID";
        order = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.util.Date dateRaw = rs.getTimestamp("dateOrder");
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                String date = sdf.format(dateRaw);
                String nameCli = rs.getString("nameCli");
                String nameShop = rs.getString("nameShop");
                int quatity = rs.getInt("quantityOr");
                String namePro = rs.getString("namePro");
                int orderID = rs.getInt("orderID");
                order.add(new Order(orderID, nameCli, nameShop, date, quatity, namePro));
//thiếu khúc add vào list
            }
        } catch (SQLException e) {

        }
    }

    public void createOrder(int clientID, int productID, int shopID, int quantityOr, int orderID) {

        String sql = "INSERT INTO [dbo].[Order_HE161829]\n"
                + "           ([clientID]\n"
                + "           ,[productID]\n"
                + "           ,[dateOrder]\n"
                + "           ,[quantityOr]\n"
                + "           ,[orderID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            ps.setTimestamp(3, timestamp);
            ps.setInt(5, orderID);
            ps.setInt(4, quantityOr);
            ps.setInt(2, productID);
            ps.setInt(1, clientID);
            ps.execute();
            status = "inser order successful";

        } catch (SQLException e) {
            status = "error at Insert order" + e.getMessage();
            System.out.println(status);
        }

    }

    public String nameSellviaShopID(int shopID) {
        String nameSell = "";
        String sql = "select [name] from\n"
                + "(select s.shopID, u.name from\n"
                + "Shop_HE161829 s inner join User_HE161829 u\n"
                + "on s.userID = u.userID) t where shopID = ?";
        System.out.println("shopID: " + shopID);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, shopID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nameSell = rs.getString("name");
            }
            System.out.println("execute");
        } catch (Exception e) {
            System.out.println("fail nameSellviaShopID" + e.getMessage());
        }
        return nameSell;
    }

    public int idOrderToIdUserShop(int idOrder) {
        int sellerID = 99999;
        String sql = "  select k.userID from (\n"
                + "  select t.orderID, s.userID from (select o.orderID, p.shopID from Order_HE161829 o inner join Product_HE161829 p on o.productID=p.id) t\n"
                + "  inner join Shop_HE161829 s on s.shopID = t.shopID  ) k where k.orderID =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idOrder);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sellerID = rs.getInt("userID");
            }
            System.out.println("execute");
        } catch (Exception e) {
            System.out.println("fail nameSellviaShopID" + e.getMessage());
        }
        return sellerID;
    }
    
    
    public int idOrderToIdProduct (int idOrder){
        int idProduct = 99999;
        String sql = "select productID from Order_HE161829 where orderID =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idOrder);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idProduct = rs.getInt("productID");
            }
            System.out.println("execute");
        } catch (Exception e) {
            System.out.println("fail nameSellviaShopID" + e.getMessage());
        }
        return idProduct;
    }
}
