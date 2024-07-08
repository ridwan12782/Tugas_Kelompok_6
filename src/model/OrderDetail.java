/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ridwa
 */
public class OrderDetail {
    private String itemName;
    private double price;
    private int quantity;
    private double total;

    public OrderDetail(String itemName, double price, int quantity, double total) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public OrderDetail(String itemName, Double price, Integer quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

