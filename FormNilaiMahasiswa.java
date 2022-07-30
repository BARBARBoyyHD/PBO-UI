/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kemahasiswaan_m.nahrul.hayat_10121074;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Asus
 */
public class FormNilaiMahasiswa extends javax.swing.JFrame {

    /**
     * Creates new form FormNilaiMahasiswa
     */
 

        koneksi dbsetting;
        String driver,database,user,pass;
        Object tabel;
        
    public FormNilaiMahasiswa() {
        initComponents();
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass= dbsetting.SettingPanel("DBPassword");
        
        tabel_nilai.setModel(tableModel);
        
        
        settableload();
        ComboBoxNama();
         ComboBoxMK();
        
    }
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTableModel();
    private javax.swing.table.DefaultTableModel getDefaultTableModel()
    {
        return new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String [] {
                "No","Nama","Nama M.K","Absensi","Tgs 1","Tgs 2","Tgs 3","UTS","UAS","Nilai Absen","Nilai Tugas"
                    ,"Nilai UTS","Nilai UAS","Nilai Akhir","Index","Keterangan"
            }
                
        )
        {
            boolean[] canEdit = new boolean[]{
                false,false,false,false,false,false,false,false,false,false,false,false,false,false,false
            };
            
            public boolean iscellEditable(int rowIndex, int columnIndex){
                return canEdit[columnIndex];
            }
        };
    }
    String data[] = new String[16];
    private void settableload()
    {
        String stat = "";
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                                                        database,
                                                        user,
                                                        pass);
            
           Statement stt = kon.createStatement();
           String SQL = "select * from nilai";
           ResultSet res = stt.executeQuery(SQL);
           while(res.next())
           {
               data[0]= res.getString(1);
               data[1]= res.getString(2);
               data[2]= res.getString(3);
               data[3]= res.getString(4);
               data[4]= res.getString(5);
               data[5]= res.getString(6);
               data[6]= res.getString(7);
               data[7]= res.getString(8);
               data[8]= res.getString(9);
               data[9]= res.getString(10);
               data[10]= res.getString(11);
               data[11]= res.getString(12);
               data[12]= res.getString(13);
               data[13]= res.getString(14);
               data[14]= res.getString(15);
               data[15]= res.getString(16);
               
               tableModel.addRow(data);
           }
           res.close();
           stt.close();
           kon.close();
            
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            
        }
        
    }
     public void membersihkan_teks()
    {
        txt_nama.setSelectedItem("");
        txt_nim.setText("");
        txt_kehadiran.setText("");
        txt_tugas1.setText("");
        txt_tugas2.setText("");
        txt_tugas3.setText("");
        txt_mk.setSelectedItem("");
        txt_kodemk.setText("");
        uts.setText("");
        uas.setText("");
        txt_kehadiran.setText("");
        
    }
    public void nonaktif_teks()
    {
       txt_nama.setEnabled(false);
        txt_nim.setEnabled(false);
        txt_kehadiran.setEnabled(false);
        txt_tugas1.setEnabled(false);
        txt_tugas2.setEnabled(false);
        txt_tugas3.setEnabled(false);
        txt_mk.setEnabled(false);
        txt_kodemk.setEnabled(false);
        uts.setEnabled(false);
        uas.setEnabled(false);
        txt_kehadiran.setEnabled(false);
    }
    public void aktif_teks()
    {
        txt_nama.setEnabled(true);
        txt_nim.setEnabled(true);
        txt_kehadiran.setEnabled(true);
        txt_tugas1.setEnabled(true);
        txt_tugas2.setEnabled(true);
        txt_tugas3.setEnabled(true);
        txt_mk.setEnabled(true);
        txt_kodemk.setEnabled(true);
        uts.setEnabled(true);
        uas.setEnabled(true);
        txt_kehadiran.setEnabled(true);
    }
    int row = 0;
    public void tampil_field()
    {
        row = tabel_nilai.getSelectedRow();
        txt_nama.setSelectedItem(tableModel.getValueAt(row, 0).toString());
        txt_nim.setText(tableModel.getValueAt(row,1).toString());
        txt_kehadiran.setText(tableModel.getValueAt(row,2).toString());
        txt_tugas1.setText(tableModel.getValueAt(row,3).toString());
        txt_tugas2.setText(tableModel.getValueAt(row,4).toString());
        txt_tugas3.setText(tableModel.getValueAt(row,5).toString());
        txt_mk.setSelectedItem(tableModel.getValueAt(row,6).toString());
        txt_kodemk.setText(tableModel.getValueAt(row,7).toString());
        uts.setText(tableModel.getValueAt(row,8).toString());
        uas.setText(tableModel.getValueAt(row,9).toString());
        txt_kehadiran.setText(tableModel.getValueAt(row,10).toString());
        btn_simpan.setEnabled(false);
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_batal.setEnabled(false);
        aktif_teks();
    }
    
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
       public void ComboBoxNama(){
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM mahasiswa";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next())
            {
                txt_nama.addItem(res.getString("nama"));
            }
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
            JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
       }
        public void ComboBoxMK(){
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM matakuliah";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next())
            {
                txt_mk.addItem(res.getString("namamk"));
            }
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
            JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        // absensi  
    }
    public int ngitungKehadiran(){
            int nilaikehadiran = Integer.parseInt(txt_kehadiran.getText());
            int rumus = (((nilaikehadiran / 14)*100*5)/100);
            return rumus;
    }    
    public int ngitungTugas(){
        int tugas1 = Integer.parseInt(txt_tugas1.getText());
        int tugas2 = Integer.parseInt(txt_tugas2.getText());
        int tugas3 = Integer.parseInt(txt_tugas3.getText());
        
        int rumus2 = ((tugas1 + tugas2 + tugas3/3)*(25/100));
        return rumus2;
    }
    public int ngitungUts(){
        int uts1 = Integer.parseInt(uts.getText());
        
        int rumus3 = uts1 * (30/100);
        return rumus3;
    }
    public int ngitungUas(){
        int uas1 = Integer.parseInt(uas.getText());
        
        int rumus4 = uas1 * (40/100);
        return rumus4;
    }
     public int ngitungNilaiakhir(){
        int nakhir = ngitungKehadiran() + ngitungTugas()+ngitungUts()+ngitungUas();
        return nakhir;
        
    }
    public String Index(int nilai){
        String Index = "E";
        if(nilai >= 80 && nilai <= 100){
             Index = "A";
         }
         else if(nilai <= 79 && nilai >= 68){
             Index = "B";
         }
         else if(nilai <= 67 && nilai >= 56){
             Index = "C";
         }
         else if(nilai <= 55 && nilai >= 45){
             Index = "D";
         }
        return Index;
    }
    public String keterangan(String Index){
        int hadir = Integer.parseInt(txt_kehadiran.getText());
        String ket = "Tidak Lulus";
        if(hadir < 11){
             if(Index == "A" || Index == "B"|| Index == "C"){
            ket = "LULUS";
        }
        }
       
        return ket;
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField9 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        txt_nim = new javax.swing.JTextField();
        txt_kehadiran = new javax.swing.JTextField();
        txt_tugas1 = new javax.swing.JTextField();
        txt_tugas2 = new javax.swing.JTextField();
        txt_tugas3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        nama_mk = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_kodemk = new javax.swing.JTextField();
        txt_angkatan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_nilai = new javax.swing.JTable();
        btn_tambah = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        txt_nama = new javax.swing.JComboBox<>();
        txt_mk = new javax.swing.JComboBox<>();
        uts = new javax.swing.JTextField();
        uas = new javax.swing.JTextField();

        jTextField9.setText("jTextField9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORM NILAI MAHASISWA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Pencarian Data");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Masukan Data");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nim");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Kehadiran");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tugas 1");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tugas 2");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tugas 3");

        txt_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nimActionPerformed(evt);
            }
        });

        txt_kehadiran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kehadiranActionPerformed(evt);
            }
        });

        txt_tugas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tugas1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Pertemuan");

        nama_mk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nama_mk.setText("Nama Mata Kuliah");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Kode M.K");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("UTS");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("UAS");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Angkatan");

        tabel_nilai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabel_nilai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "title1", "title2", "title3", "title4"
            }
        ));
        jScrollPane1.setViewportView(tabel_nilai);

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        txt_nama.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                txt_namaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        txt_nama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_namaMouseClicked(evt);
            }
        });
        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });

        txt_mk.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                txt_mkPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        uts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_tugas3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
                                            .addComponent(txt_tugas2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
                                            .addComponent(txt_kehadiran, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
                                            .addComponent(txt_tugas1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(187, 187, 187)
                                                .addComponent(jLabel15))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel14)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jLabel10)
                                                            .addGap(105, 105, 105)
                                                            .addComponent(jLabel13)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(172, 172, 172)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(nama_mk)
                                                            .addComponent(jLabel12)))))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_nim, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                        .addComponent(txt_nama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_kodemk, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                .addComponent(txt_mk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_angkatan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addComponent(uas, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(uts, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nama_mk)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_kodemk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txt_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nimActionPerformed

    private void txt_kehadiranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kehadiranActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_kehadiranActionPerformed

    private void txt_tugas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tugas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tugas1ActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
         nonaktif_teks();
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_keluar.setEnabled(true);
        membersihkan_teks();   
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
         int keluar = JOptionPane.showConfirmDialog(null,"Apakah Anda Ingin"+" Keluar Program ?!","Pesan!!",JOptionPane.YES_NO_OPTION);
        if(keluar == JOptionPane.YES_OPTION){
            System.exit(0);
        }
        else if (keluar == JOptionPane.NO_OPTION){
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }            // TODO add your handling code here:
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txt_namaActionPerformed

    private void txt_namaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_namaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_namaMouseClicked

    private void txt_namaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_txt_namaPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
                      String item = (String)txt_nama.getSelectedItem();
    try
    {
        Class.forName(driver);
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String SQL = "SELECT mahasiswa.nim from mahasiswa where nama="
                + "'"+item+"'";
        ResultSet res = stt.executeQuery(SQL);
        if(res.next())
        {
           String das = res.getString("nim");
            txt_nim.setText(das);
        }
    }
    catch (Exception ex)
    {
        System.err.println(ex.getMessage());
        JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
        JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
  
    }//GEN-LAST:event_txt_namaPopupMenuWillBecomeInvisible

    private void txt_mkPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_txt_mkPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
              String item = (String)txt_mk.getSelectedItem();
    try
    {
        Class.forName(driver);
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String SQL = "SELECT matakuliah.nomormk from matakuliah where namamk="
                + "'"+item+"'";
        ResultSet res = stt.executeQuery(SQL);
        if(res.next())
        {
           String asd = res.getString("nomormk");
            txt_kodemk.setText(asd);
        }
    }
    catch (Exception ex)
    {
        System.err.println(ex.getMessage());
        JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
        JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    }//GEN-LAST:event_txt_mkPopupMenuWillBecomeInvisible

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
          String data[]=new String[16];
          
          

    if((txt_nim.getText().isEmpty()) || (txt_angkatan.getText().isEmpty()))
    {
        JOptionPane.showMessageDialog(null,
                        "data tidak boleh kosong, silahkan dilengkapi");
        txt_nim.requestFocus();
    }
    else
    {
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                                database,
                                user,
                                pass);
            Statement stt = kon.createStatement ();
            String    SQL = "INSERT INTO nilai(nama,"
                            +"namamk,"+"absensi,"+"tugas1,"+"tugas2,"+"tugas3,"+
                            "uts,"+"uas,"+"nilaiabsen,"+"nilaitugas,"+"nilaiuts,"+"nilaiuas,"
                            +"nilaiakhir,"+"index,"+"keterangan)"
                            +"VALUES"
                            +"('"+txt_nama.getSelectedItem()+"',"
                            +"'"+txt_mk.getSelectedItem()+"',"
                            +"'"+txt_kehadiran.getText()+"',"
                            +"'"+Integer.parseInt(txt_tugas1.getText())+"',"
                            +"'"+Integer.parseInt(txt_tugas2.getText())+"',"
                            +"'"+Integer.parseInt(txt_tugas3.getText())+"',"
                            
                            +"'"+Integer.parseInt(uts.getText())+"',"
                            +"'"+Integer.parseInt(uas.getText())+"',"
                            +"'"+ngitungKehadiran()+"',"
                            +"'"+ngitungTugas()+"',"
                            +"'"+ngitungUts()+"',"
                            +"'"+ngitungUas()+"',"
                            +"'"+ngitungNilaiakhir()+"',"
                                +"'"+Index(ngitungNilaiakhir())+"',"
                                +"'"+keterangan(Index(ngitungNilaiakhir()))+"')";
                       
            
            stt.executeUpdate(SQL);
            data[1]= String.valueOf(txt_nama.getSelectedItem()); 
            data[2]= String.valueOf(txt_mk.getSelectedItem());
            data[3]=txt_kehadiran.getText();
            data[4]=txt_tugas1.getText();
            data[5]=txt_tugas2.getText();
            data[6]=txt_tugas3.getText();
            data[7]=uts.getText();
            data[8]=uas.getText();
           
            data[9]= String.valueOf(ngitungKehadiran());
            data[10]=String.valueOf(ngitungTugas());
            data[11]=String.valueOf(ngitungUts());
            data[12]=String.valueOf(ngitungUas());
            data[13]=String.valueOf(ngitungNilaiakhir());
             data[14]=String.valueOf(Index(ngitungNilaiakhir()));
              data[15]=String.valueOf(keterangan(Index(ngitungNilaiakhir())));
            
         
           
            tableModel.insertRow(0, data);
            stt.close();
            kon.close();
            membersihkan_teks();
            btn_simpan.setEnabled(false);
            nonaktif_teks();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,
                ex.getMessage(),"Error",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
        }        
        
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void utsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utsActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        txt_nama.requestFocus();
        btn_simpan.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_keluar.setEnabled(false);
        aktif_teks(); 
    }//GEN-LAST:event_btn_tambahActionPerformed

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
            java.util.logging.Logger.getLogger(FormNilaiMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNilaiMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNilaiMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNilaiMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNilaiMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel nama_mk;
    private javax.swing.JTable tabel_nilai;
    private javax.swing.JTextField txt_angkatan;
    private javax.swing.JTextField txt_kehadiran;
    private javax.swing.JTextField txt_kodemk;
    private javax.swing.JComboBox<String> txt_mk;
    private javax.swing.JComboBox<String> txt_nama;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JTextField txt_tugas1;
    private javax.swing.JTextField txt_tugas2;
    private javax.swing.JTextField txt_tugas3;
    private javax.swing.JTextField uas;
    private javax.swing.JTextField uts;
    // End of variables declaration//GEN-END:variables
}
