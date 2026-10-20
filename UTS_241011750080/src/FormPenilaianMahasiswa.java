/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author krisn
 */
public class FormPenilaianMahasiswa extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormPenilaianMahasiswa.class.getName());

    /**
     * Creates new form FormPenilaianMahasiswa
     */
    public FormPenilaianMahasiswa() {
        initComponents();
        updateSks();
        txtSks.setEditable(false);
        txtNilaiAkhir.setEditable(false);
        txtGrade.setEditable(false);

    }

    private void updateSks() {
        String mataKuliah
                = String.valueOf(cmbMatakuliah.getSelectedItem());

        int sks;

        switch (mataKuliah) {
            case "Rekayasa web":
                sks = 2;
                break;

            case "Java 2":
            case "Basis Data":
            case "Jaringan Komputer":
            case "Pemrograman Mobile":
                sks = 3;
                break;

            default:
                sks = 2;
        }

        txtSks.setText(String.valueOf(sks));
    }

    private boolean hitungNilai() {
        try {
            // Validasi identitas
            if (txtNim.getText().trim().isEmpty()
                    || txtNama.getText().trim().isEmpty()) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "NIM dan Nama wajib diisi!"
                );
                return false;
            }

            if (!rbLakilaki.isSelected()
                    && !rbPerempuan.isSelected()) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Pilih jenis kelamin terlebih dahulu!"
                );
                return false;
            }

            int sks = Integer.parseInt(txtSks.getText().trim());
            int presensi = Integer.parseInt(
                    txtPresensi.getText().trim());

            double tugas = Double.parseDouble(
                    txtTugas.getText().trim());

            double uts = Double.parseDouble(
                    txtUts.getText().trim());

            double uas = Double.parseDouble(
                    txtUas.getText().trim());

            // Jumlah pertemuan berdasarkan SKS
            int jumlahPertemuan;

            if (sks == 3) {
                jumlahPertemuan = 21;
            } else if (sks == 2) {
                jumlahPertemuan = 14;
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                        this, "SKS harus 2 atau 3!"
                );
                return false;
            }

            // Validasi presensi
            if (presensi < 0 || presensi > jumlahPertemuan) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Presensi melebihi batas!\n"
                        + "Mata kuliah ini " + sks + " SKS.\n"
                        + "Maksimal presensi: " + jumlahPertemuan
                        + " pertemuan.",
                        "Peringatan Presensi",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return false;
            }

            // Validasi nilai akademik
            if (tugas < 0 || tugas > 100
                    || uts < 0 || uts > 100
                    || uas < 0 || uas > 100) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Nilai Tugas, UTS, dan UAS harus 0–100!"
                );
                return false;
            }

            // Menghitung bobot nilai
            double persentasePresensi
                    = (double) presensi / jumlahPertemuan * 100;

            double nilaiAbsensi
                    = persentasePresensi * 0.10;

            double nilaiTugas = tugas * 0.20;
            double nilaiUts = uts * 0.30;
            double nilaiUas = uas * 0.40;

            double nilaiAkhir
                    = nilaiAbsensi + nilaiTugas + nilaiUts + nilaiUas;

            // Menentukan grade berdasarkan nilai akhir
            String grade;

            if (nilaiAkhir > 80) {
                grade = "A";
            } else if (nilaiAkhir > 60) {
                grade = "B";
            } else if (nilaiAkhir > 40) {
                grade = "C";
            } else {
                grade = "D";
            }

            // Aturan khusus absensi dari soal UTS
            if (persentasePresensi < 50) {
                grade = "E";
            } else if (persentasePresensi < 75) {
                grade = "D";
            }

            // Menampilkan hasil
            txtNilaiAkhir.setText(
                    String.format(
                            java.util.Locale.US,
                            "%.2f",
                            nilaiAkhir
                    )
            );

            txtGrade.setText(grade);

            return true;

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Presensi, Tugas, UTS, dan UAS harus berupa angka!"
            );
            return false;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        rbLakilaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        cmbMatakuliah = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtSks = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPresensi = new javax.swing.JTextField();
        txtTugas = new javax.swing.JTextField();
        txtUts = new javax.swing.JTextField();
        txtUas = new javax.swing.JTextField();
        txtNilaiAkhir = new javax.swing.JTextField();
        txtGrade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Penilaian Mahasiswa");

        jLabel1.setText("Aplikasi Penilaian Mahasiswa");

        jLabel2.setText("NIM");

        jLabel3.setText("NAMA");

        jLabel4.setText("JENIS KELAMIN");

        jLabel5.setText("MATA KULIAH");

        txtNim.addActionListener(this::txtNimActionPerformed);

        buttonGroup1.add(rbLakilaki);
        rbLakilaki.setText("Laki-laki");

        buttonGroup1.add(rbPerempuan);
        rbPerempuan.setText("Perempuan");
        rbPerempuan.addActionListener(this::rbPerempuanActionPerformed);

        cmbMatakuliah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rekayasa web", "Java 2", "Basis Data", "Jaringan Komputer", "Pemrograman Mobile" }));
        cmbMatakuliah.addActionListener(this::cmbMatakuliahActionPerformed);

        jLabel6.setText("SKS");

        jButton1.setText("Add Data");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Clear");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Proses");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Bobot Penilaian"));

        jLabel7.setText("PRESENSI");

        jLabel8.setText("TUGAS");

        jLabel9.setText("UTS");

        jLabel10.setText("UAS");

        jLabel11.setText("NILAI AKHIR");

        jLabel12.setText("GRADE");

        txtTugas.addActionListener(this::txtTugasActionPerformed);

        txtNilaiAkhir.addActionListener(this::txtNilaiAkhirActionPerformed);

        txtGrade.addActionListener(this::txtGradeActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPresensi)
                    .addComponent(txtTugas)
                    .addComponent(txtUts)
                    .addComponent(txtUas)
                    .addComponent(txtNilaiAkhir)
                    .addComponent(txtGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPresensi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtUts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtUas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNilaiAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        txtLog.setColumns(20);
        txtLog.setRows(5);
        jScrollPane1.setViewportView(txtLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbLakilaki, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(rbPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNim, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(txtNama)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbMatakuliah, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton3))
                                            .addComponent(txtSks, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rbLakilaki)
                            .addComponent(rbPerempuan))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbMatakuliah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNimActionPerformed

    private void rbPerempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPerempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPerempuanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!hitungNilai()) {
            return;
        }

        String jk = rbLakilaki.isSelected() ? "LAKI-LAKI" : "PEREMPUAN";

        txtLog.append(
                txtNim.getText().trim()
                + " | " + txtNama.getText().trim()
                + " | " + jk
                + " | Matkul : " + cmbMatakuliah.getSelectedItem()
                + " | SKS : " + txtSks.getText()
                + " | Absensi : " + txtPresensi.getText().trim()
                + " | Tugas : " + txtTugas.getText().trim()
                + " | UTS : " + txtUts.getText().trim()
                + " | UAS : " + txtUas.getText().trim()
                + " | Nilai Akhir : " + txtNilaiAkhir.getText()
                + " | Grade : " + txtGrade.getText()
                + "\n"
        );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtNim.setText("");
        txtNama.setText("");

        buttonGroup1.clearSelection();

        cmbMatakuliah.setSelectedIndex(0);
        updateSks();

        txtPresensi.setText("");
        txtTugas.setText("");
        txtUts.setText("");
        txtUas.setText("");
        txtNilaiAkhir.setText("");
        txtGrade.setText("");

        txtNim.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        hitungNilai();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGradeActionPerformed

    private void txtNilaiAkhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNilaiAkhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNilaiAkhirActionPerformed

    private void txtTugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTugasActionPerformed

    private void cmbMatakuliahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMatakuliahActionPerformed
        updateSks();
    }//GEN-LAST:event_cmbMatakuliahActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormPenilaianMahasiswa().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbMatakuliah;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JRadioButton rbLakilaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNilaiAkhir;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtPresensi;
    private javax.swing.JTextField txtSks;
    private javax.swing.JTextField txtTugas;
    private javax.swing.JTextField txtUas;
    private javax.swing.JTextField txtUts;
    // End of variables declaration//GEN-END:variables
}
