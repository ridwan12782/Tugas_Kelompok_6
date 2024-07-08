/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;

public class ProductDao {

    public static void save(Product product) {
        if (product == null || product.getName().trim().isEmpty() || product.getCategory().trim().isEmpty() || Double.parseDouble(product.getPrice().trim()) <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid product data", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query = "INSERT INTO product (name, category, price) VALUES (?, ?, ?)";
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, product.getName());
            pst.setString(2, product.getCategory());
            pst.setString(3, product.getPrice());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produk Berhasil Ditambahkan!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<Product> getAllRecords() {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product");
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getString("price"));
                arrayList.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return arrayList;
    }

    public static void update(Product product) {
        String query = "UPDATE product SET name=?, category=?, price=? WHERE id=?";
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, product.getName());
            pst.setString(2, product.getCategory());
            pst.setString(3, product.getPrice());
            pst.setInt(4, product.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produk Berhasil Diupdate!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void delete(String id) {
        String query = "DELETE FROM product WHERE id=?";
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produk Berhasil Dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<Product> getAllRecordsByCategory(String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from product where category='" + category + "'");
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("name"));
                arrayList.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static ArrayList<Product> filterProductByname(String name, String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from product where name like='%" + name + "%' and category = '" + category + "'");
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("name"));
                arrayList.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static Product getProductByname(String name) {
        Product product = new Product();
        try {
            ResultSet rs = DbOperations.getData("select *from product where name='" + name + "'");
            while (rs.next()) {
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
