package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.PaymentHistory;

public class PaymentHistoryDao {

    public static ArrayList<PaymentHistory> getAllPaymentHistory() {
        ArrayList<PaymentHistory> paymentList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            String query = "SELECT * FROM payment_history";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                PaymentHistory payment = new PaymentHistory();
                payment.setId(rs.getInt("id"));
                payment.setBillId(rs.getInt("bill_id"));
                payment.setAmountPaid(rs.getDouble("amount"));
                payment.setPaymentDate(rs.getDate("payment_date"));
                payment.setStatus(rs.getString("status"));
                payment.setCustomerName(rs.getString("customer_name"));
                payment.setCustomerEmail(rs.getString("customer_email"));
                payment.setCustomerMobile(rs.getString("customer_mobile"));

                // Log values for debugging
                System.out.println("Customer Name: " + payment.getCustomerName());
                System.out.println("Customer Email: " + payment.getCustomerEmail());
                System.out.println("Customer Mobile: " + payment.getCustomerMobile());

                paymentList.add(payment);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return paymentList;
    }

    public static ArrayList<PaymentHistory> getPaymentHistoriesByBillId(String billId) {
        ArrayList<PaymentHistory> paymentList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            String query = "SELECT * FROM payment_history WHERE bill_id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, billId);
            rs = pst.executeQuery();

            while (rs.next()) {
                PaymentHistory payment = new PaymentHistory();
                payment.setId(rs.getInt("id"));
                payment.setBillId(rs.getInt("bill_id"));
                payment.setAmountPaid(rs.getDouble("amount"));
                payment.setPaymentDate(rs.getDate("payment_date"));
                payment.setStatus(rs.getString("status"));
                payment.setCustomerName(rs.getString("customer_name"));
                payment.setCustomerEmail(rs.getString("customer_email"));
                payment.setCustomerMobile(rs.getString("customer_mobile"));

                paymentList.add(payment);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return paymentList;
    }

    public static void save(PaymentHistory payment) {
        String query = "INSERT INTO payment_history (bill_id, amount, payment_date, status, customer_name, customer_email, customer_mobile) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, payment.getBillId());
            pstmt.setDouble(2, payment.getAmountPaid());
            pstmt.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
            pstmt.setString(4, payment.getStatus());
            pstmt.setString(5, payment.getCustomerName());
            pstmt.setString(6, payment.getCustomerEmail());
            pstmt.setString(7, payment.getCustomerMobile());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data pembayaran berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static double calculatePaymentAmount(String id) {
        double totalAmount = 0.0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            String query = "SELECT total FROM bill WHERE id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                totalAmount = rs.getDouble("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return totalAmount;
    }

    public static ArrayList<PaymentHistory> getAllPaymentHistoryById(String customerBillId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
