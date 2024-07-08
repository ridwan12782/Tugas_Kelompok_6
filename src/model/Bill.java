/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Represents a Bill.
 *
 * @author: ridwa
 */
public class Bill {

    private int id;
    private String name;
    private String mobileNumber;
    private String email;
    private String date;
    private String total;
    private String createdBy;
    private String status;  // Added status field

    // Constructors
    public Bill(int id, String name, String mobileNumber, String email, String date, String total, String createdBy, String status) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.date = date;
        this.total = total;
        this.createdBy = createdBy;
        this.status = status;
    }

    public Bill() {
    }

    // Getters and setters
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", mobileNumber='" + mobileNumber + '\''
                + ", email='" + email + '\''
                + ", date='" + date + '\''
                + ", total='" + total + '\''
                + ", createdBy='" + createdBy + '\''
                + ", status='" + status + '\''
                + '}';
    }
}
