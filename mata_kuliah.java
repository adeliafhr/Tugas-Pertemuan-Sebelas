/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pertemuanketujuh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.lang.System.Logger.*;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lenovo
 */
public class mata_kuliah extends javax.swing.JFrame {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/UTS_PBO";
    String user = "postgres";
    String password = "adelia19";
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private String src;

    /**
     * Creates new form mata_kuliah
     */
    public mata_kuliah() {
        initComponents();
        koneksi();
        tampil();
    }

    public void koneksi() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            System.out.println("Koneksi berhasil!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Koneksi gagal!");
        }
    }

    public void tampil() {
        // TODO code application logi
        try (Connection conn = DriverManager.getConnection(koneksi, user, password); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM mata_kuliah ORDER BY Kode_MK")) {

            // Dapatkan model tabel yang ada
            DefaultTableModel model = (DefaultTableModel) Tabel.getModel();

            // Kosongkan data tabel terlebih dahulu
            model.setRowCount(0);

            // Tambahkan data dari ResultSet ke model tabel
            while (rs.next()) {
                Object[] rowData = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            // Tangani eksepsi
            System.err.println("Terjadi kesalahan: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfKode = new javax.swing.JTextField();
        tfSmt = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        tfSKS = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        btnUpload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("MATA KULIAH");

        jLabel2.setText("Kode MK");

        jLabel3.setText("Nama MK");

        jLabel4.setText("SKS");

        jLabel5.setText("Semester Ajar");

        tfSmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSmtActionPerformed(evt);
            }
        });

        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCetak.setText("CETAK");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        Tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "KODE MK", "SKS", "NAMA MK", "SEMESTER AJAR"
            }
        ));
        Tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel);

        btnUpload.setText("UPLOAD");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(282, 282, 282))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(40, 40, 40)
                                .addComponent(tfNama))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfSKS)
                                    .addComponent(tfKode)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tfSmt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCetak))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpload)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tfKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(tfSKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfSmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnInsert)
                                    .addComponent(btnUpdate))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDelete)
                                    .addComponent(btnCetak)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btnUpload))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfSmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSmtActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String kode_mk, SKS, nama_mk, semester_ajar;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);

            String sql = "INSERT INTO mata_kuliah (kode_mk, SKS, nama_mk, semester_ajar) VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            kode_mk = tfKode.getText();
            SKS = tfSKS.getText();
            nama_mk = tfNama.getText();
            semester_ajar = tfSmt.getText();

            pstmt.setString(1, kode_mk);
            pstmt.setInt(2, Integer.parseInt(SKS));
            pstmt.setString(3, nama_mk);
            pstmt.setInt(4, Integer.parseInt(semester_ajar));
            pstmt.executeUpdate();

            conn.commit();
            pstmt.close();
            conn.close();

            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        }

        bersih();
        tampil();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String kode_mk, SKS, nama_mk, semester_ajar;
        if (tfKode.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else if (tfSKS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else if (tfNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else if (tfSmt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else {
            try {
                Class.forName(driver);
                String sql = "UPDATE mata_kuliah SET SKS = ?, nama_mk = ?, semester_ajar = ? WHERE kode_mk = ?";
                conn = DriverManager.getConnection(koneksi, user, password);
                pstmt = conn.prepareStatement(sql);

                kode_mk = tfKode.getText();
                SKS = tfSKS.getText();
                nama_mk = tfNama.getText();
                semester_ajar = tfSmt.getText();

                pstmt.setInt(1, Integer.parseInt(SKS));
                pstmt.setString(2, nama_mk);
                pstmt.setInt(3, Integer.parseInt(semester_ajar));
                pstmt.setString(4, kode_mk);
                pstmt.executeUpdate();

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
                    pstmt.close();
                    conn.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(mata_kuliah.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        bersih();
        tampil();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        // TODO add your handling code here:
        int row = Tabel.getSelectedRow();
        tfKode.setText(Tabel.getValueAt(row, 0).toString());
        tfSKS.setText(Tabel.getValueAt(row, 1).toString());
        tfNama.setText(Tabel.getValueAt(row, 2).toString());
        tfSmt.setText(Tabel.getValueAt(row, 3).toString());
    }//GEN-LAST:event_TabelMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String kode_mk;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);

            String sql = "DELETE FROM mata_kuliah WHERE kode_mk = ?";
            pstmt = conn.prepareStatement(sql);

            kode_mk = tfKode.getText(); // Mengambil Kode MK dari input

            pstmt.setString(1, kode_mk);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }

            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        }

        bersih();
        tampil();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        //TODO add your handling code here:
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);
            String reportPath = "src/pertemuanketujuh/report_matkul.jasper";
            HashMap<String, Object> parameters = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            System.out.println("yang dipilih : " + filePilihan.getAbsolutePath());
            try {
                BufferedReader br = new BufferedReader(new FileReader(filePilihan));
                String baris = new String("");
                String pemisah = ",";
                while ((baris = br.readLine()) != null) //returns a Boolean value
                {
                    String[] dataMhs = baris.split(pemisah);
                    String kode_mk = dataMhs[0];
                    String SKS = dataMhs[1];
                    String nama_mk = dataMhs[2];
                    String semester_ajar = dataMhs[3];
                    if (!kode_mk.isEmpty() && !SKS.isEmpty() && !nama_mk.isEmpty() && !semester_ajar.isEmpty()) {
                        try {
                            Class.forName(driver);
                            conn = DriverManager.getConnection(koneksi, user, password);
                            conn.setAutoCommit(false);

                            String sql = "INSERT INTO mata_kuliah (kode_mk, SKS, nama_mk, semester_ajar) VALUES(?, ?, ?, ?)";
                            pstmt = conn.prepareStatement(sql);

                            pstmt.setString(1, kode_mk);
                            pstmt.setInt(2, Integer.parseInt(SKS));
                            pstmt.setString(3, nama_mk);
                            pstmt.setInt(4, Integer.parseInt(semester_ajar));
                            pstmt.executeUpdate();

                            conn.commit();
                            pstmt.close();
                            conn.close();
                            tampil();
                        } catch (ClassNotFoundException | SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Saat Pengisian Data");
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(mata_kuliah.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(mata_kuliah.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void bersih() {
        tfKode.setText("");
        tfSKS.setText("");
        tfNama.setText("");
        tfSmt.setText("");
    }

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
            java.util.logging.Logger.getLogger(mata_kuliah.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mata_kuliah.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mata_kuliah.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mata_kuliah.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //</editor-fold>
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mata_kuliah.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mata_kuliah.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mata_kuliah.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mata_kuliah.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mata_kuliah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfKode;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfSKS;
    private javax.swing.JTextField tfSmt;
    // End of variables declaration//GEN-END:variables
}
