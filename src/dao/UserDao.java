package dao;

import model.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;


/**
 * Class for handling User data operations.
 */
public class UserDao {

    public static void save(user user) {
        String query = "INSERT INTO user (name, email, mobileNumber, address, password, securityQuestion, answer, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getMobileNumber());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getSecurityQuestion());
            ps.setString(7, user.getAnswer());
            ps.setString(8, user.getStatus() != null ? user.getStatus() : "false");

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pengguna Berhasil Mendaftar!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static user login(String email, String password) {
        user u = null;
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        try (Connection conn = ConnectionProvider.getCon();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new user();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setMobileNumber(rs.getString("mobileNumber"));
                u.setAddress(rs.getString("address"));
                u.setPassword(rs.getString("password"));
                u.setSecurityQuestion(rs.getString("securityQuestion"));
                u.setAnswer(rs.getString("answer"));
                u.setStatus(rs.getString("status"));
            } else {
                JOptionPane.showMessageDialog(null, "Email atau Kata sandi Salah!", "Login Gagal", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return u;
    }

    public static user getSecurityQuestion(String email) {
        user u = null;
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email = '" + email + "'");
            while (rs.next()) {
                u = new user();
                u.setSecurityQuestion(rs.getString("securityQuestion"));
                u.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return u;
    }

    public static void update(String email, String newPassword) {
        // SQL query to update the user's password
        String query = "UPDATE user set password = '" + newPassword + "' where email='" + email + "'";
        DbOperations.setDataOrDelete(query, "Password Berhasil Diubah!");
    }

    public static ArrayList<user> getAllRecords(String email) {
        ArrayList<user> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from user where email like '%" + email + "%'");
            while (rs.next()) {
                user u = new user();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setMobileNumber(rs.getString("mobileNumber"));
                u.setAddress(rs.getString("address"));
                u.setSecurityQuestion(rs.getString("securityQuestion"));
                u.setStatus(rs.getString("status"));
                arrayList.add(u);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void changeStatus(String email, String status) {
        String query = "update user set status='" + status + "' where email ='" + email + "'";
        DbOperations.setDataOrDelete(query, "Status Berhasil Diubah");
    }

    public static void changePassword(String email, String oldPassword, String newPassword){
        try {
            ResultSet rs = DbOperations.getData("select *from user where email='" + email + "' and password='" + oldPassword + "'");
            if (rs.next()) {
                update(email, newPassword);
            } else {
                JOptionPane.showMessageDialog(null, "Katasandi Lama Salah!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    public static void ChangeSecurityQuestion(String email, String password, String securityQuestion,String answer){
        try{
            ResultSet rs =DbOperations.getData("select *from user where email ='"+email+"' and password='"+password+"'");
            if(rs.next()){
                update(email, securityQuestion, answer);
            }
            else{
                JOptionPane.showMessageDialog(null, "Password Salah!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static void update(String email, String securityQuestion,String answer){
        String query = "update user set securityQuestion='"+securityQuestion+"',answer='"+answer+"' where email='"+email+"'";
        DbOperations.setDataOrDelete(query, "Pertanyaan Keamanana Berhasil Diubah!");
    }

}
