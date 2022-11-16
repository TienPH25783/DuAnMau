/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import ViewModels.QLNhanVien;
import ViewModels.QLCuaHang;
import Services.IQLNhanVienService;
import Services.QLNhanVienService;
import Services.IQlCuaHangService;
import Services.IQlChucVuService;
import ViewModels.QLChucVu;
import Services.QlCuaHangService;
import Services.QLChucVuService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ongbi
 */
public class FormQLNhanVien extends javax.swing.JFrame {

    private final IQLNhanVienService iQLNhanVienService;
    private List<QLNhanVien> lNhanViens;
    private DefaultComboBoxModel comboBoxModel;
    private IQlChucVuService iQlChucVuService;
    private IQlCuaHangService iQlCuaHangService;
    private List<QLCuaHang> lCuaHangs;
    private List<QLChucVu> lChucVus;

    /**
     * Creates new form FormQLNhanVien
     */
    public FormQLNhanVien() {
        initComponents();
        iQLNhanVienService = new QLNhanVienService();
        iQlChucVuService = new QLChucVuService();
        iQlCuaHangService = new QlCuaHangService();
        lChucVus = new ArrayList<>();
        lCuaHangs = new ArrayList<>();
        lNhanViens = new ArrayList<>();
        comboBoxModel = new DefaultComboBoxModel();
      lChucVus =   iQlChucVuService.getAll();
        lCuaHangs = iQlCuaHangService.getAll();
        lNhanViens = iQLNhanVienService.getAll();
        this.addCbIDCV((ArrayList<QLChucVu>) iQlChucVuService.getAll());
        this.addCbIDCuaH((ArrayList<QLCuaHang>) iQlCuaHangService.getAll());
        this.addCbIDGBC((ArrayList<QLNhanVien>) iQLNhanVienService.getAll());

        loadTable();

    }

    private void addCbIDCuaH(ArrayList<QLCuaHang> list) {
        comboBoxModel = (DefaultComboBoxModel) cbIdCH.getModel();
        for (QLCuaHang qLCuaHang : list) {
            comboBoxModel.addElement(qLCuaHang.getTen());
        }

    }

    private void addCbIDCV(ArrayList<QLChucVu> list) {
        comboBoxModel = (DefaultComboBoxModel) cbIDCV.getModel();
        for (QLChucVu qlcv : list) {
            comboBoxModel.addElement(qlcv.getTen());
        }

    }

    private void addCbIDGBC(ArrayList<QLNhanVien> list) {
        comboBoxModel = (DefaultComboBoxModel) cbIdGBC.getModel();
        for (QLNhanVien qlnv : list) {
            comboBoxModel.addElement(qlnv.getTen());
        }

    }

    private void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblist.getModel();
        dtm.setRowCount(0);
        for (QLNhanVien qLNhanVien : iQLNhanVienService.getAll()) {
            Object[] toRowData = {
                qLNhanVien.getId(),
                qLNhanVien.getMa(),
                qLNhanVien.getHo(),
                qLNhanVien.getTenDem(),
                qLNhanVien.getTen(),
                qLNhanVien.getGioiTinh(),
                qLNhanVien.getNgaySinh(),
                qLNhanVien.getDiaChi(),
                qLNhanVien.getSdt(),
                qLNhanVien.getMatKhau(),
                qLNhanVien.getIdCh().getId(),
                qLNhanVien.getIdCv().getId(),
                qLNhanVien.getIdGuiBC().getId(),
                qLNhanVien.getTrangThai() == 0 ? "Hoạt động" : "Không Hoạt Động",
//                qLNhanVien.getTrangThai(),
            };
            dtm.addRow(toRowData);
        }

    }

    private UUID getIDCH() {
        String cbCH = (String) cbIdCH.getSelectedItem();
        UUID idCh = null;
        for (QLCuaHang lCuaHang : lCuaHangs) {
            if (lCuaHang.getTen().equals(cbCH)) {
                idCh = lCuaHang.getId();
            }
        }
        return idCh;
    }

    private UUID getIDCV() {
        String cbCV = (String) cbIDCV.getSelectedItem();
        UUID idCV = null;
        for (QLChucVu lChucVu : lChucVus) {
            if (lChucVu.getTen().equals(cbCV)) {
                idCV = lChucVu.getId();
            }
        }
        return idCV;
    }

    private UUID getIDGBC() {
        String cbGBC = (String) cbIdGBC.getSelectedItem();
        UUID idGBC = null;
        for (QLNhanVien lNhanVien : lNhanViens) {
            if (lNhanVien.getTen().equals(cbGBC)) {
                idGBC = lNhanVien.getId();
            }

        }
        return idGBC;
    }

    private QLNhanVien getFormData() {
        String Ma = txtMa.getText().trim();
        String Ten = txtTen.getText().trim();
        String TenDem = txtTenDem.getText().trim();
        String Ho = txtHo.getText().trim();
        String GioiTinh;
        String DiaChi = txtDiaChi.getText().trim();
        String Sdt = txtSDT.getText().trim();
        String MatKhau = txtMK.getText().trim();
        Date ngaySinh = DateNgaySinh.getDate();
        UUID id = null;
        int trangThai;
        if (Ma.length() == 0 || Ten.length() == 0 || TenDem.length() == 0 || Ho.length() == 0 || DiaChi.length() == 0 || Sdt.length() == 0 || MatKhau.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống");
            return null;
        }

        if (rdNam.isSelected()) {
            GioiTinh = "Nam";
        } else {
            GioiTinh = "Nữ";
        }

        if (rdHd.isSelected()) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }

        QLChucVu idCv = new QLChucVu(getIDCV());
        QLCuaHang idCh = new QLCuaHang(getIDCH());
        QLNhanVien idGBc = new QLNhanVien(getIDGBC());

        QLNhanVien qLNhanVien = new QLNhanVien(id, Ma, Ten, TenDem, Ho, GioiTinh, ngaySinh, DiaChi, Sdt, MatKhau, idCh, idCv, idGBc, trangThai);
        return qLNhanVien;

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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtTenDem = new javax.swing.JTextField();
        txtHo = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtMK = new javax.swing.JTextField();
        cbIdCH = new javax.swing.JComboBox<>();
        cbIDCV = new javax.swing.JComboBox<>();
        cbIdGBC = new javax.swing.JComboBox<>();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        rdHd = new javax.swing.JRadioButton();
        rdKhd = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblist = new javax.swing.JTable();
        DateNgaySinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Quản Lý Nhân Viên");

        jLabel2.setText("Id");

        jLabel3.setText("Mã");

        jLabel4.setText("Tên");

        jLabel5.setText("Tên Đệm");

        jLabel6.setText("Họ");

        jLabel7.setText("Giới Tính");

        jLabel8.setText("Ngày Sinh");

        jLabel9.setText("Địa Chỉ");

        jLabel10.setText("SDT");

        jLabel11.setText("Mật Khẩu");

        jLabel12.setText("ID Cửa Hàng");

        jLabel13.setText(" ID Gửi BC");

        jLabel14.setText("ID Chức Vụ");

        jLabel15.setText("Trạng Thái");

        lbID.setText("--");

        buttonGroup1.add(rdNam);
        rdNam.setSelected(true);
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        buttonGroup2.add(rdHd);
        rdHd.setSelected(true);
        rdHd.setText("Hoạt Động");

        buttonGroup2.add(rdKhd);
        rdKhd.setText("Không Hoạt Động");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");

        tblist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã", "Họ", "Tên Đệm", "Tên", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "SDT", "Mật Khẩu", "ID Cửa Hàng", "ID Chức Vụ", "ID Gửi BC", "Trạng Thái"
            }
        ));
        tblist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblist);

        DateNgaySinh.setBackground(new java.awt.Color(204, 255, 255));
        DateNgaySinh.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnThem)
                .addGap(143, 143, 143)
                .addComponent(btnSua)
                .addGap(89, 89, 89)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClear)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTenDem)
                                    .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMa)
                                    .addComponent(txtHo, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                                .addGap(98, 98, 98)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(210, 210, 210)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbIdCH, 0, 189, Short.MAX_VALUE)
                                    .addComponent(cbIDCV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(rdHd, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdKhd))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbIdGBC, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(lbID)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel8)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(DateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(cbIdCH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbIdGBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(cbIDCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdHd)
                    .addComponent(rdKhd))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        QLNhanVien qLNhanVien = this.getFormData();
        if (qLNhanVien == null) {
            return;
        }
        this.iQLNhanVienService.insert(qLNhanVien);
        loadTable();

    }//GEN-LAST:event_btnThemActionPerformed

    private void tblistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblistMouseClicked
       int row = tblist.getSelectedRow();
       if(row < - 1){
       return;
       }
       
       String id = tblist.getValueAt(row, 0).toString();
       String ma = tblist.getValueAt(row, 1).toString();
       String ten = tblist.getValueAt(row, 4).toString();
       String tendem = tblist.getValueAt(row, 3).toString();
       String ho= tblist.getValueAt(row, 2).toString();
       String diaCHi = tblist.getValueAt(row, 7).toString();
       String sdt = tblist.getValueAt(row, 8).toString();
       String matKhau = tblist.getValueAt(row, 9).toString();
       String IDCh = tblist.getValueAt(row, 10).toString();
       String IdCV = tblist.getValueAt(row, 11).toString();
       String IDGBC = tblist.getValueAt(row, 12).toString();
       String ngaySinh = tblist.getValueAt(row, 6).toString();
       lbID.setText(id);
       txtMa.setText(ma);
       txtTen.setText(ten);
       txtTenDem.setText(tendem);
       txtHo.setText(ho);
       txtDiaChi.setText(diaCHi);
       txtSDT.setText(sdt);
       txtMK.setText(matKhau);
       cbIdCH.setSelectedItem(IDCh);
       cbIDCV.setSelectedItem(IdCV);
       cbIdGBC.setSelectedItem(IDGBC);
       DateNgaySinh.setDateFormatString(ngaySinh);
       
    }//GEN-LAST:event_tblistMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
  
         QLNhanVien nhanVien = this.getFormData();
        int row = this.tblist.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn để Sửa");
            return;
        }
        if (nhanVien == null) {
            return;
        }
        String idStr = this.tblist.getValueAt(row, 0).toString();
        UUID id = UUID.fromString(idStr);
        this.iQLNhanVienService.update(nhanVien, id);

        loadTable();
//        clearFrom();    }//GEN-LAST:event_btnSuaActionPerformed
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
           int row = this.tblist.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dữ liệu cần xóa");
            return;
        }

        int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa", "Xóa", JOptionPane.YES_NO_OPTION);
        if (chon != JOptionPane.YES_OPTION) {
            return;
        }

        String idStr = this.tblist.getValueAt(row, 0).toString();
        UUID id = UUID.fromString(idStr);
        this.iQLNhanVienService.delete(id);
        this.loadTable();
    }//GEN-LAST:event_btnXoaActionPerformed
    
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
            java.util.logging.Logger.getLogger(FormQLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQLNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateNgaySinh;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbIDCV;
    private javax.swing.JComboBox<String> cbIdCH;
    private javax.swing.JComboBox<String> cbIdGBC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JRadioButton rdHd;
    private javax.swing.JRadioButton rdKhd;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tblist;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDem;
    // End of variables declaration//GEN-END:variables
}
