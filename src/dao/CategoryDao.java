package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Category;

public class CategoryDao {

    public static void save(Category category) {
    if (category == null || category.getName().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nama kategori tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        Connection con = ConnectionProvider.getCon();
        String query = "INSERT INTO category (name) VALUES (?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, category.getName());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Kategori berhasil ditambahkan!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    public static ArrayList<Category> getAllRecord() {
        ArrayList<Category> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM category");
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID adalah Nol atau Kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection con = ConnectionProvider.getCon();
            String query = "DELETE FROM category WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kategori Sukses Dihapus!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
