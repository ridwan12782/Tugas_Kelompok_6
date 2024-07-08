package dao;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        try {
            // Create user table
            String userTable = "CREATE TABLE user ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(200), "
                    + "email VARCHAR(200) UNIQUE, "
                    + "mobileNumber VARCHAR(12), "
                    + "address VARCHAR(200), "
                    + "password VARCHAR(100), " // Sesuaikan panjang maksimum sesuai kebutuhan Anda
                    + "securityQuestion VARCHAR(200), "
                    + "answer VARCHAR(200), "
                    + "status VARCHAR(10))"; // Menggunakan VARCHAR(10) untuk status sesuai contoh sebelumnya

            String adminDetails = "INSERT INTO user (name, email, mobileNumber, address, password, securityQuestion, answer, status) "
                    + "VALUES ('Admin', 'ridwanspeed8@gmail.com', '081234567890', 'Indonesia', 'admin', 'apa?', 'apa', 'aktif')";

            // Create category table (fixing typo in 'create table' statement)
            String categoryTable = "CREATE TABLE category ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(200))";

            // Create category table (fixing typo in 'create table' statement)
            String billTable = "CREATE TABLE bill ("
                    + "id INT PRIMARY KEY, "
                    + "name VARCHAR(200), "
                    + "mobileNumber VARCHAR(200), "
                    + "email VARCHAR(200), "
                    + "date VARCHAR(50), "
                    + "total VARCHAR(200), "
                    + "createdBy VARCHAR(200))";

            String productTable = "create table product (id int AUTO_INCREMENT key, name varchar(200), category varchar(200), price varchar(200))";

            String paymentHistory = "CREATE TABLE paymenthistory (\n"
                    + "    id INT PRIMARY KEY AUTO_INCREMENT,\n"
                    + "    billId INT NOT NULL,\n"
                    + "    itemName VARCHAR(100) NOT NULL,\n"
                    + "    price DECIMAL(10, 2) NOT NULL,\n"
                    + "    quantity INT NOT NULL,\n"
                    + "    name VARCHAR(100) NOT NULL,\n"
                    + "    mobileNumber VARCHAR(15) NOT NULL,\n"
                    + "    email VARCHAR(100) NOT NULL,\n"
                    + "    date DATE NOT NULL,\n"
                    + "    total DECIMAL(10, 2) NOT NULL,\n"
                    + "    createdBy VARCHAR(100) NOT NULL,\n"
                    + "    FOREIGN KEY (billId) REFERENCES bill(id)\n"
                    + ");";
            String orderDetails = "CREATE TABLE orderdetails (\n"
                    + "    id INT PRIMARY KEY AUTO_INCREMENT,\n"
                    + "    billId INT NOT NULL,\n"
                    + "    itemName VARCHAR(100) NOT NULL,\n"
                    + "    price DECIMAL(10, 2) NOT NULL,\n"
                    + "    quantity INT NOT NULL,\n"
                    + "    FOREIGN KEY (billId) REFERENCES bill(id)\n"
                    + ");";
            // Uncomment the lines below to execute the SQL queries
            // DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
            // DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully");
            // DbOperations.setDataOrDelete(categoryTable, "Category Table Created Successfully");
            // DbOperations.setDataOrDelete(productTable, "Product Table Created Successfully");
            // DbOperations.setDataOrDelete(billTable, "Bill Table Created Successfully");
            DbOperations.setDataOrDelete(paymentHistory, "paymentHistory Table Created Successfully");
            // DbOperations.setDataOrDelete(orderDetails, "orderDetails Table Created Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
