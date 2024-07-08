/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 * DbOperations class for executing database operations.
 */
public class DbOperations {

    /**
     * Method to execute data insertion or deletion query.
     *
     * @param query SQL query to execute (INSERT, UPDATE, DELETE).
     * @param msg Message to display after successful execution.
     */
    public static void setDataOrDelete(String query, String msg) {
    if (query == null || query.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Query is null or empty", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        st.executeUpdate(query);

        if (msg != null && !msg.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, msg);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}



    /**
     * Method to execute data retrieval query.
     *
     * @param query SQL query to execute (Select).
     * @return ResultSet containing the result of the query.
     */
    public static ResultSet getData(String query) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
