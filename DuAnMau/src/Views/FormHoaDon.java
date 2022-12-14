/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Services.QLKhachHangService;
import Services.QLNhanVienService;
import Services.QLHoaDonServiceI;
import Services.QLKhachHangService;
import Services.QLNhanVienService;
import ViewModels.QLHoaDon;
import ViewModels.QLKhachHang;
import ViewModels.QLNhanVien;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Services.IQLHoaDonService;
import Services.IQLHoaDonService;

/**
 *
 * @author hp
 */
public class FormHoaDon extends javax.swing.JFrame {

    private List<QLHoaDon> listHoaDon = new ArrayList<>();
    private List<QLKhachHang> listKH = new ArrayList<>();
    private List<QLNhanVien> listNV = new ArrayList<>();
    private IQLHoaDonService qlhdcts = new QLHoaDonServiceI();
    private QLKhachHangService qlkhs = new QLKhachHangService();
    private QLNhanVienService qlnvs = new QLNhanVienService();
    private DefaultTableModel dtm;

    /**
     * Creates new form FrmHoaDon
     */
    public FormHoaDon() {
        initComponents();
        jTable1.setModel(dtm = new DefaultTableModel());
        String[] header = {"ID", "Khach Hang", "Nhan Vien", "Ma", "Ngay Tao", "Ngay Thanh Toan", "Ngay Ship", "Ngay Nhan", "Tinh Trang", "Nguoi Nhan", "Dia Chi", "SDT"};
        dtm.setColumnIdentifiers(header);
        listHoaDon = qlhdcts.getAll();
        //ChoBin
        // Lấy dữ liệu trên git 
        // demodemo
        // Tiên
        //Dmm
        listKH = qlkhs.getAll();
        listNV = qlnvs.getAll();
        loadCbbKH();
        loadCbbNV();
        showData(listHoaDon);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        cbbNhanVien = new javax.swing.JComboBox<>();
        jDateNgayTao = new com.toedter.calendar.JDateChooser();
        jDateNgayThanhToan = new com.toedter.calendar.JDateChooser();
        jDateNgayShip = new com.toedter.calendar.JDateChooser();
        jDateNgayNhan = new com.toedter.calendar.JDateChooser();
        txtMa = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtTenNguoiNhan = new javax.swing.JTextField();
        radioDaThanhToan = new javax.swing.JRadioButton();
        radioChuaThanhToan = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Hoa Don");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Khach Hang");

        jLabel3.setText("Nhan Vien");

        jLabel4.setText("Ma");

        jLabel5.setText("Dia Chi");

        jLabel6.setText("Ngay Tao");

        jLabel7.setText("Tinh Trang");

        jLabel8.setText("Ten Nguoi Nhan");

        jLabel9.setText("SDT");

        jLabel10.setText("Ngay Thanh Toan");

        jLabel11.setText("Ngay Ship");

        jLabel12.setText("Ngay Nhan");

        jDateNgayTao.setDateFormatString("dd-MM-yyyy");

        jDateNgayThanhToan.setDateFormatString("dd-MM-yyyy");

        jDateNgayShip.setDateFormatString("dd-MM-yyyy");

        jDateNgayNhan.setDateFormatString("dd-MM-yyyy");

        buttonGroup1.add(radioDaThanhToan);
        radioDaThanhToan.setText("Da Thanh Toan");

        buttonGroup1.add(radioChuaThanhToan);
        radioChuaThanhToan.setSelected(true);
        radioChuaThanhToan.setText("Chua Thanh Toan");

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cbbNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateNgayThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateNgayShip, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(radioChuaThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioDaThanhToan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(166, 166, 166))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(407, 407, 407))
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(btnXoa))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(85, 85, 85)
                        .addComponent(btnSua)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jDateNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel10))
                                    .addComponent(jDateNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jLabel11))
                            .addComponent(jDateNgayShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jDateNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioDaThanhToan)
                            .addComponent(radioChuaThanhToan)
                            .addComponent(jLabel7))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_jTable1MouseClicked

    private void showData(List<QLHoaDon> listQLHoaDon) {
        dtm.setRowCount(0);
        for (QLHoaDon qLHoaDon : listQLHoaDon) {
            dtm.addRow(qLHoaDon.toDataRow());
        }
    }

    private void fillData(int index) {
        QLHoaDon qlhd = listHoaDon.get(index);
        txtDiaChi.setText(qlhd.getDiaChi());
        txtMa.setText(qlhd.getMa());
        txtSDT.setText(qlhd.getSdt());
        txtTenNguoiNhan.setText(qlhd.getTenNguoiNhan());
        jDateNgayNhan.setDate(qlhd.getNgayNhan());
        jDateNgayShip.setDate(qlhd.getNgayShip());
        jDateNgayTao.setDate(qlhd.getNgayTao());
        jDateNgayThanhToan.setDate(qlhd.getNgayThanhToan());
        if (qlhd.getTinhTrang() == 0) {
            radioChuaThanhToan.setSelected(true);
        } else {
            radioDaThanhToan.setSelected(true);
        }
    }

    private void insert() {
        String ma = txtMa.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String sdt = txtSDT.getText().trim();
        String tenNguoiNhan = txtTenNguoiNhan.getText().trim();
        Date ngayNhan = jDateNgayNhan.getDate();
        Date ngayShip = jDateNgayShip.getDate();
        Date ngayTao = jDateNgayTao.getDate();
        Date ngayThanhToan = jDateNgayThanhToan.getDate();
        int tinhTrang;
        if (radioChuaThanhToan.isSelected()) {
            tinhTrang = 0;
        } else {
            tinhTrang = 1;
        }
        if (ngayNhan == null || ngayShip == null || ngayTao == null || ngayThanhToan == null || ma.length() == 0 || diaChi.length() == 0 || sdt.length() == 0 || tenNguoiNhan.length() == 0) {
            JOptionPane.showMessageDialog(this, "Khong duoc de trong");
        } else {
            QLKhachHang idKH = new QLKhachHang(getIdKH());
            QLNhanVien idNV = new QLNhanVien(getIdNV());
            QLHoaDon qlhd = new QLHoaDon(idKH, idNV, ma, ngayTao, ngayThanhToan, ngayShip, ngayNhan, tinhTrang, tenNguoiNhan, diaChi, sdt);
            JOptionPane.showMessageDialog(this, qlhdcts.insert(qlhd));
            listHoaDon = qlhdcts.getAll();
            showData(listHoaDon);
        }
    }

    private void update() {
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            QLHoaDon qlhd1 = listHoaDon.get(row);
            UUID id = qlhd1.getId();
            String ma = txtMa.getText().trim();
            String diaChi = txtDiaChi.getText().trim();
            String sdt = txtSDT.getText().trim();
            String tenNguoiNhan = txtTenNguoiNhan.getText().trim();
            Date ngayNhan = jDateNgayNhan.getDate();
            Date ngayShip = jDateNgayShip.getDate();
            Date ngayTao = jDateNgayTao.getDate();
            Date ngayThanhToan = jDateNgayThanhToan.getDate();
            int tinhTrang;
            if (radioChuaThanhToan.isSelected()) {
                tinhTrang = 0;
            } else {
                tinhTrang = 1;
            }
            if (ngayNhan == null || ngayShip == null || ngayTao == null || ngayThanhToan == null || ma.length() == 0 || diaChi.length() == 0 || sdt.length() == 0 || tenNguoiNhan.length() == 0) {
                JOptionPane.showMessageDialog(this, "Khong duoc de trong");
            } else {
                QLKhachHang idKH = new QLKhachHang(getIdKH());
                QLNhanVien idNV = new QLNhanVien(getIdNV());
                QLHoaDon qlhd = new QLHoaDon(idKH, idNV, ma, ngayTao, ngayThanhToan, ngayShip, ngayNhan, tinhTrang, tenNguoiNhan, diaChi, sdt);
                JOptionPane.showMessageDialog(this, qlhdcts.update(qlhd, id));
                listHoaDon = qlhdcts.getAll();
                showData(listHoaDon);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Moi chon doi tuong de xoa");
        }
    }

    private void delete() {
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            QLHoaDon qlhd1 = listHoaDon.get(row);
            UUID id = qlhd1.getId();
            JOptionPane.showMessageDialog(this, qlhdcts.delete(id));
            listHoaDon = qlhdcts.getAll();
            showData(listHoaDon);
        } else {
            JOptionPane.showMessageDialog(this, "Moi chon doi tuong de xoa");
        }
    }

    private void loadCbbKH() {
        for (QLKhachHang qLKhachHang : listKH) {
            cbbKhachHang.addItem(qLKhachHang.hoTen());
        }
    }

    private void loadCbbNV() {
        for (QLNhanVien qLNhanVien : listNV) {
            cbbNhanVien.addItem(qLNhanVien.hoTen());
        }
    }

    private UUID getIdKH() {
        String khachHang = (String) cbbKhachHang.getSelectedItem();
        UUID idKH = null;
        for (QLKhachHang qLKhachHang : listKH) {
            if (qLKhachHang.hoTen().equals(khachHang)) {
                idKH = qLKhachHang.getId();
            }
        }
        return idKH;
    }

    private UUID getIdNV() {
        String nhanVien = (String) cbbNhanVien.getSelectedItem();
        UUID idNV = null;
        for (QLNhanVien qLNhanVien : listNV) {
            if (qLNhanVien.hoTen().equals(nhanVien)) {
                idNV = qLNhanVien.getId();
            }
        }
        return idNV;
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
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbNhanVien;
    private com.toedter.calendar.JDateChooser jDateNgayNhan;
    private com.toedter.calendar.JDateChooser jDateNgayShip;
    private com.toedter.calendar.JDateChooser jDateNgayTao;
    private com.toedter.calendar.JDateChooser jDateNgayThanhToan;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioChuaThanhToan;
    private javax.swing.JRadioButton radioDaThanhToan;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNguoiNhan;
    // End of variables declaration//GEN-END:variables
}
