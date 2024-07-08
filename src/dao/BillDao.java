package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.Bill;
import model.OrderDetail;
import model.PaymentHistory;

public class BillDao {

    public static String getId() {
        int id = 1;
        try {
            ResultSet rs = DbOperations.getData("select max(id) from bill");
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return String.valueOf(id);
    }

    public static void save(Bill bill) {
        String query = "insert into bill (id, name, mobileNumber, email, date, total, createdBy, status) values(?,?,?,?,?,?,?,?)";
        try (Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, bill.getId());
            ps.setString(2, bill.getName());
            ps.setString(3, bill.getMobileNumber());
            ps.setString(4, bill.getEmail());
            ps.setString(5, bill.getDate());
            ps.setString(6, bill.getTotal());
            ps.setString(7, bill.getCreatedBy());
            ps.setString(8, bill.getStatus());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Detail Tagihan Berhasil Ditambahkan");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<Bill> getAllRecordsByInc(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            String query = "select * from bill where date like ? order by id";
            try (Connection con = ConnectionProvider.getCon();
                    PreparedStatement ps = con.prepareStatement(query)) {

                ps.setString(1, "%" + date + "%");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Bill bill = new Bill();
                    bill.setId(rs.getInt("id"));
                    bill.setName(rs.getString("name"));
                    bill.setMobileNumber(rs.getString("mobileNumber"));
                    bill.setEmail(rs.getString("email"));
                    bill.setDate(rs.getString("date"));
                    bill.setTotal(rs.getString("total"));
                    bill.setCreatedBy(rs.getString("createdBy"));
                    bill.setStatus(rs.getString("status"));
                    arrayList.add(bill);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return arrayList;
    }

    public static ArrayList<Bill> getAllRecordsByDesc(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            String query = "select * from bill where date like ? order by id desc";
            try (Connection con = ConnectionProvider.getCon();
                    PreparedStatement ps = con.prepareStatement(query)) {

                ps.setString(1, "%" + date + "%");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Bill bill = new Bill();
                    bill.setId(rs.getInt("id"));
                    bill.setName(rs.getString("name"));
                    bill.setMobileNumber(rs.getString("mobileNumber"));
                    bill.setEmail(rs.getString("email"));
                    bill.setDate(rs.getString("date"));
                    bill.setTotal(rs.getString("total"));
                    bill.setCreatedBy(rs.getString("createdBy"));
                    bill.setStatus(rs.getString("status"));
                    arrayList.add(bill);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return arrayList;
    }

    public static double calculatePaymentAmount(String id) {
        double totalAmount = 0.0;
        try {
            String query = "select total from bill where id = ?";
            try (Connection con = ConnectionProvider.getCon();
                    PreparedStatement ps = con.prepareStatement(query)) {

                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    totalAmount = rs.getDouble("total");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return totalAmount;
    }

    public static void deleteRecordById(String id) {
        String query = "delete from bill where id = ?";
        try (Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tagihan berhasil dihapus");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Bill getBillById(String id) {
        Bill bill = null;
        try {
            String query = "SELECT * FROM bill WHERE id = ?";
            try (Connection con = ConnectionProvider.getCon();
                    PreparedStatement ps = con.prepareStatement(query)) {

                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    bill = new Bill();
                    bill.setId(rs.getInt("id"));
                    bill.setName(rs.getString("name"));
                    bill.setMobileNumber(rs.getString("mobileNumber"));
                    bill.setEmail(rs.getString("email"));
                    bill.setDate(rs.getString("date"));
                    bill.setTotal(rs.getString("total"));
                    bill.setCreatedBy(rs.getString("createdBy"));
                    bill.setStatus(rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return bill;
    }

    public static ArrayList<OrderDetail> getOrderDetails(String billId) {
        ArrayList<OrderDetail> orderDetailsList = new ArrayList<>();
        try {
            String query = "select * from orderdetails where billId = ?";
            try (Connection con = ConnectionProvider.getCon();
                    PreparedStatement ps = con.prepareStatement(query)) {

                ps.setString(1, billId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String itemName = rs.getString("itemName");
                    Double price = rs.getDouble("price");
                    Integer quantity = rs.getInt("quantity");
                    OrderDetail orderDetail = new OrderDetail(itemName, price, quantity);
                    orderDetailsList.add(orderDetail);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return orderDetailsList;
    }

    public static void savePaymentHistory(PaymentHistory paymentHistory) {
        String query = "insert into paymenthistory (billId, amountPaid, paymentDate, status, customerName, customerEmail, customerMobile) values(?,?,?,?,?,?,?)";
        try (Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, paymentHistory.getBillId());
            ps.setDouble(2, paymentHistory.getAmountPaid());
            ps.setDate(3, new java.sql.Date(paymentHistory.getPaymentDate().getTime()));
            ps.setString(4, paymentHistory.getStatus());
            ps.setString(5, paymentHistory.getCustomerName());
            ps.setString(6, paymentHistory.getCustomerEmail());
            ps.setString(7, paymentHistory.getCustomerMobile());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Riwayat Pembayaran Berhasil Disimpan");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<PaymentHistory> getAllPaymentHistoryById(String customerBillId) {
        ArrayList<PaymentHistory> paymentList = new ArrayList<>();
        try {
            String query = "SELECT * FROM paymenthistory WHERE billId = ?";
            try (Connection con = ConnectionProvider.getCon();
                    PreparedStatement ps = con.prepareStatement(query)) {

                ps.setString(1, customerBillId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    PaymentHistory payment = new PaymentHistory();
                    payment.setId(rs.getInt("id"));
                    payment.setBillId(rs.getInt("billId"));
                    payment.setAmountPaid(rs.getDouble("amountPaid"));
                    payment.setPaymentDate(rs.getDate("paymentDate"));
                    payment.setStatus(rs.getString("status"));
                    payment.setCustomerName(rs.getString("customerName"));
                    payment.setCustomerEmail(rs.getString("customerEmail"));
                    payment.setCustomerMobile(rs.getString("customerMobile"));

                    paymentList.add(payment);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return paymentList;
    }

    public static void updatePaymentStatus(String id, String status) {
        String query = "UPDATE bill SET status = ? WHERE id = ?";
        try (Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, status);
            ps.setString(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(Bill billObj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
