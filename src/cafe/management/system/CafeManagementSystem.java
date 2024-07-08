/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.management.system;

import javax.swing.JFrame;

/**
 *
 * Main class for Cafe Management System application.
 */
public class CafeManagementSystem {

    /**
     * Main method to start the application.
     */
    public static void main(String[] args) {
        // Create and display the Signup frame
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Signup signupFrame = new Signup();
                signupFrame.setVisible(false);
            }
        });
    }
    
}
