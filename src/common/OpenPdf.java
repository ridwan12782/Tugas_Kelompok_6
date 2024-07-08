/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.File;
import javax.swing.JOptionPane;

public class OpenPdf {
    public static void openById(String id) {
        try {
            // Mengecek apakah file tersebut ada
            if ((new File("E:\\" + id + ".pdf")).exists()) {
                // Buka file PDF menggunakan perintah yang sesuai untuk sistem operasi Windows
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler E:\\" + id + ".pdf");
            } else {
                JOptionPane.showMessageDialog(null, "File Tidak Ada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
