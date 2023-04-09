/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
//O
//
//INSERT INTO [dbo].[Product]
//           ([id]
//           ,[name]
//           ,[price]
//           ,[date]
//           ,[img]
//           ,[quantity]
//           ,[description]
//           ,[cateID])

public class Product {

    private int id;
    private String name;
    private String date;
    private String img;
    private int quantity;
    private String description;
    private int cateID;
    private float price;
    private int sellid;

    public Product() {
    }

    public Product(int id, String name, String date, String img, int quantity, String description, int cateID, float price, int sellid) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.img = img;
        this.quantity = quantity;
        this.description = description;
        this.cateID = cateID;
        this.price = price;
        this.sellid = sellid;
    }

   

    public int getSellid() {
        return sellid;
    }

    public void setSellid(int sellid) {
        this.sellid = sellid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    

}
