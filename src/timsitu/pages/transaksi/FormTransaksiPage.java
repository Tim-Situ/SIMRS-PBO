/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package timsitu.pages.transaksi;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import timsitu.models.Obat;
import timsitu.models.Pemeriksaan;
import timsitu.models.Poliklinik;
import timsitu.models.Transaksi;
import timsitu.pages.MainPage;
import timsitu.pages.poliklinik.PoliklinikPage;

/**
 *
 * @author fauzeinmulyawarman
 */
public class FormTransaksiPage extends javax.swing.JPanel {

    Transaksi transaksi;
    Pemeriksaan pemeriksaan;
    int totalBiaya = 0;
    int uangKembalian = 0;
    
    public FormTransaksiPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new timsitu.customs.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtKodeTransaksi = new javax.swing.JTextField();
        txtKodePemeriksaan = new javax.swing.JTextField();
        txtNamaPasien = new javax.swing.JTextField();
        txtNamaDokter = new javax.swing.JTextField();
        txtTotalTagihan = new javax.swing.JTextField();
        txtUangBayar = new javax.swing.JTextField();
        txtKembalian = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDataTransaksi = new javax.swing.JButton();
        btnSimpan1 = new javax.swing.JButton();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Transaksi");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setText("Kode Pembayaran");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setText("Kode Pemeriksaan");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setText("Nama Pasien");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setText("Nama Dokter");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel6.setText("Total Tagihan");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel7.setText("Uang Pembayaran");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel8.setText("Kembalian");

        txtKodeTransaksi.setEditable(false);
        txtKodeTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        txtKodeTransaksi.setText("Otomatis");
        txtKodeTransaksi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtKodePemeriksaan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtNamaPasien.setEditable(false);
        txtNamaPasien.setBackground(new java.awt.Color(255, 255, 255));
        txtNamaPasien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtNamaDokter.setEditable(false);
        txtNamaDokter.setBackground(new java.awt.Color(255, 255, 255));
        txtNamaDokter.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtTotalTagihan.setEditable(false);
        txtTotalTagihan.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalTagihan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtUangBayar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtUangBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUangBayarKeyReleased(evt);
            }
        });

        txtKembalian.setEditable(false);
        txtKembalian.setBackground(new java.awt.Color(255, 255, 255));
        txtKembalian.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");

        btnDataTransaksi.setText("Data Transaksi");
        btnDataTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataTransaksiActionPerformed(evt);
            }
        });

        btnSimpan1.setText("Cari");
        btnSimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(68, 68, 68)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKodeTransaksi)
                            .addComponent(txtKodePemeriksaan)
                            .addComponent(txtNamaPasien)
                            .addComponent(txtNamaDokter)
                            .addComponent(txtTotalTagihan)
                            .addComponent(txtUangBayar)
                            .addComponent(txtKembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnSimpan1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnDataTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txtKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKodePemeriksaan, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(btnSimpan1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaPasien, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaDokter, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotalTagihan, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUangBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnDataTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDataTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataTransaksiActionPerformed
        TransaksiPage transaksiPage = new TransaksiPage();
        MainPage.setForm(transaksiPage);
    }//GEN-LAST:event_btnDataTransaksiActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed

        if(transaksi != null){
            try {
                transaksi.setUangBayar(Integer.parseInt(txtUangBayar.getText()));
                transaksi.simpanData();

                JOptionPane.showMessageDialog(null, "Data Transaksi Berhasil Disimpan...");
                

                MainPage.setForm(new TransaksiPage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),"Gagal", JOptionPane.WARNING_MESSAGE);
            } 
        }else{
            JOptionPane.showMessageDialog(null,"Data tidak boleh ada yang kosong!!!","Gagal", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnSimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpan1ActionPerformed
        transaksi = Pemeriksaan.getDetailData(txtKodePemeriksaan.getText());
        txtNamaPasien.setText(transaksi.getPasien());
        txtNamaDokter.setText(transaksi.getDokter());
        
        totalBiaya = transaksi.getTotalBiaya();
        
        ArrayList<Obat> dataObat = Obat.getResepObat(transaksi.getKodePemeriksaan());
        
        for (Obat obat : dataObat) {
            System.out.println(obat.getHarga());
            System.out.println(obat.getStok());
            totalBiaya += (obat.getHarga() * obat.getStok());
        }
        
        transaksi.setTotalBiaya(totalBiaya);
        txtTotalTagihan.setText(Integer.toString(totalBiaya));
        
    }//GEN-LAST:event_btnSimpan1ActionPerformed

    private void txtUangBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUangBayarKeyReleased
        uangKembalian = Integer.parseInt(txtUangBayar.getText()) - totalBiaya;
        txtKembalian.setText(String.valueOf(uangKembalian));
    }//GEN-LAST:event_txtUangBayarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDataTransaksi;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnSimpan1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private timsitu.customs.PanelBorder panelBorder1;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtKodePemeriksaan;
    private javax.swing.JTextField txtKodeTransaksi;
    private javax.swing.JTextField txtNamaDokter;
    private javax.swing.JTextField txtNamaPasien;
    private javax.swing.JTextField txtTotalTagihan;
    private javax.swing.JTextField txtUangBayar;
    // End of variables declaration//GEN-END:variables
}
