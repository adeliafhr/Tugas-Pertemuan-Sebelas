# Aplikasi Upload Data CSV dengan Java Swing
---
## 🗂️ Table Of Contents 
-  [File Excel](https://github.com/adeliafhr/Tugas-Pertemuan-Sebelas/blob/main/DataMatkul.csv)
-  [Fitur Upload](https://github.com/adeliafhr/Tugas-Pertemuan-Sebelas/blob/main/mata_kuliah.java)

---
##  📋 Langkah - Langkah 
### 1. Membuat file excel
![image](https://github.com/user-attachments/assets/1163625d-a863-438b-ba02-9087688540f3)

---
### 2. Simpan dalam bentuk (.CSV)
![image](https://github.com/user-attachments/assets/0c5ec451-e4d4-4e48-bbf3-8a2266571853)

---
### 3. Tambahkan button upload pada java swing
![image](https://github.com/user-attachments/assets/c4519e1e-3a6d-47d9-9725-d8b4084e4c8c)

---
### 4. Berikut source code untuk button upload
<pre>
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
    }
</pre>

---
## 5. Implementasi
### a) Tampilan awal output
![image](https://github.com/user-attachments/assets/cefc2060-a416-4bcf-8a65-c97944cab690)

---
### b) Pilih button upload dan pilih file dengan format (.CSV)
![image](https://github.com/user-attachments/assets/08bdbdd8-c754-4d3a-902e-8282e714a7a6)

---
### c) Data pada tabel akan secara otomatis bertambah
![image](https://github.com/user-attachments/assets/0d9f24dd-a685-44db-8e2c-17c4e8698fad)

---
## 💡Selamat Belajar dan Selamat Mencoba dalam menggunakan Data CSV pada Java Swing !!📖
