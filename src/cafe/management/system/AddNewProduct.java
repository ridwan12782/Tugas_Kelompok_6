/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.management.system;

import java.util.ArrayList;
import model.Category;
import model.Product;
import dao.CategoryDao;
import dao.ProductDao;
import javax.swing.JOptionPane;
import java.math.BigDecimal;

public class AddNewProduct extends javax.swing.JFrame {

    /**
     * Creates new form AddNewProduct
     */
    public AddNewProduct() {
        initComponents();
        btn_save.setEnabled(false); // Menonaktifkan tombol simpan saat inisialisasi frame
    }

    // Method untuk memvalidasi isian pada field name dan price
    private void validateFields() {
        String name = txt_name.getText().trim();
        String price = txt_price.getText().trim();

        // Cek jika nama dan harga tidak kosong
        if (!name.isEmpty() && !price.isEmpty()) {
            // Coba parse harga menjadi BigDecimal
            try {
                BigDecimal parsedPrice = new BigDecimal(price);
                if (parsedPrice.compareTo(BigDecimal.ZERO) <= 0) {
                    JOptionPane.showMessageDialog(null, "Harga produk harus lebih besar dari nol", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    btn_save.setEnabled(false); // Menonaktifkan tombol simpan jika harga tidak valid
                } else {
                    btn_save.setEnabled(true); // Mengaktifkan tombol simpan jika semua valid
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Format harga tidak valid", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                btn_save.setEnabled(false); // Menonaktifkan tombol simpan jika format harga tidak valid
            }
        } else {
            btn_save.setEnabled(false); // Menonaktifkan tombol simpan jika ada field yang kosong
        }
    }

    private void clearFields() {
        txt_name.setText("");
        txt_price.setText("");
    }

    // Method yang digenerate otomatis oleh NetBeans untuk inisialisasi komponen UI
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        cmb_category = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 134));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new product.png"))); // NOI18N
        jLabel1.setText("Tambah Produk Baru");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nameKeyReleased(evt);
            }
        });
        getContentPane().add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 230, -1));

        txt_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_priceKeyReleased(evt);
            }
        });
        getContentPane().add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 204, 230, -1));

        getContentPane().add(cmb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 230, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Kategori");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Harga");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        btn_save.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btn_save.setText("Simpan");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        getContentPane().add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 256, -1, -1));

        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btn_clear.setText("Hapus");
        btn_clear.setToolTipText("");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        getContentPane().add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 256, -1, -1));

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        getContentPane().add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 23, 30, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/small-page-background.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed

        // Membuat objek Product dan mengatur nilai-nilai berdasarkan input pengguna
        Product product = new Product();
        product.setName(txt_name.getText().trim());
        product.setCategory((String) cmb_category.getSelectedItem());
        product.setPrice(txt_price.getText().trim());

        try {
            // Memastikan harga valid (lebih besar dari nol)
            double price = Double.parseDouble(txt_price.getText().trim());
            if (price <= 0) {
                JOptionPane.showMessageDialog(null, "Harga produk harus lebih besar dari nol", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                return; // Menghentikan proses penyimpanan jika harga tidak valid
            }

            // Menyimpan produk menggunakan ProductDao
            ProductDao.save(product);

            // Menyembunyikan frame AddNewProduct setelah menyimpan
            setVisible(false);

            // Reset semua field dan status tombol simpan
            clearFields();
            btn_save.setEnabled(false);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Format harga tidak valid", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new AddNewProduct().setVisible(true);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        // TODO add your handling code here:
// Membersihkan isi JComboBox sebelum menambahkan item baru
        cmb_category.removeAllItems();

        try {
            // Mengambil semua kategori dari database menggunakan CategoryDao.getAllRecord()
            ArrayList<Category> list = CategoryDao.getAllRecord();
            for (Category categoryObj : list) {
                cmb_category.addItem(categoryObj.getName()); // Menambahkan nama kategori ke dalam JComboBox
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil Kategori: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formComponentShown

    private void txt_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txt_nameKeyReleased

    private void txt_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_priceKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txt_priceKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cmb_category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    // End of variables declaration//GEN-END:variables
}
