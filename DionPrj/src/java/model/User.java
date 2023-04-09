/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//[name]
//      ,[password]
//      ,[id]
//      ,[email]
//      ,[address]
//      ,[phoneNum]
//      ,[role]
//      ,[active]
//      ,[gender]


public class User {
    private String name;
    private String pass;
    private int id;
    private String email;
    private String add;
    private int phone;
    private boolean active;
    private int role;
    private boolean gender;

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User(String name,boolean gender, String pass, int id, String email, String add, int phone, boolean active, int role) {
        this.name = name;
        this.pass = pass;
        this.id = id;
        this.email = email;
        this.add = add;
        this.phone = phone;
        this.active = active;
        this.role = role;
        this.gender = gender;
    }

    

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}
