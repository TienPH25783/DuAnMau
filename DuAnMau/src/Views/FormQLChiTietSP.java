/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import ViewModels.QLChiTietSP;
import Services.QLChiTietSPServices;
import Services.IQLSanPhamService;
import Services.QLSanPhamService;
import Services.IQLNSXService;
import Services.IQLMauSacService;
import Services.IQLDongSPService;
import Services.QLNSXService;
import Services.QLMauSacService;
import Services.QLDongSPService;
import ViewModels.QLSanPham;
import ViewModels.QLDongSp;
import ViewModels.QLMauSac;
import ViewModels.QLNSX;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Services.IQLChiTietSPService;

/**
 *
 * @author ongbi
 */
public class FormQLChiTietSP extends javax.swing.JFrame {

    private final IQLChiTietSPService iQLChiTienSPService;
    private List<QLChiTietSP> qLChiTietSPs;
    private DefaultComboBoxModel comboBoxModel;
    private IQLSanPhamService iQLSanPhamService;
    private IQLDongSPService iQLDongSPService;
    private IQLMauSacService iQLMauSacService;
    private IQLNSXService iQLNSXService;
    private List<QLMauSac> listMauSac;
    private List<QLSanPham> lSanPhams;
    private List<QLDongSp> lDongSpss;
    private List<QLNSX> lnsxs;

    /**
     * Creates new form CHiTietSP
     */
    public FormQLChiTietSP() {
        initComponents();
        iQLChiTienSPService = new QLChiTietSPServices();
        iQLSanPhamService = new QLSanPhamService();
        iQLDongSPService = new QLDongSPService();
        iQLMauSacService = new QLMauSacService();
        iQLNSXService = new QLNSXService();
        listMauSac = new ArrayList<>();
        lDongSpss = new ArrayList<>();
        lSanPhams = new ArrayList<>();
        lnsxs = new ArrayList<>();
        qLChiTietSPs = iQLChiTienSPService.getAll();
        lSanPhams = iQLSanPhamService.getAll();
        lDongSpss = iQLDongSPService.getAll();
        listMauSac = iQLMauSacService.getAll();
        lnsxs = iQLNSXService.getAll();
        addCBSP(iQLSanPhamService.getAll());
        addCBMS((ArrayList<QLMauSac>) iQLMauSacService.getAll());
        addCBNSX((ArrayList<QLNSX>) iQLNSXService.getAll());
        addCBDSP((ArrayList<QLDongSp>) iQLDongSPService.getAll());
        loadTable();

    }

    private void addCBSP(ArrayList<QLSanPham> List) {
        comboBoxModel = (DefaultComboBoxModel) CbIDSP.getModel();
        for (QLSanPham qLSanPham : List) {
            comboBoxModel.addElement(qLSanPham.getMa());
        }

    }

    private void addCBDSP(ArrayList<QLDongSp> List) {
        comboBoxModel = (DefaultComboBoxModel) CbIDDSP.getModel();
        for (QLDongSp qlds : List) {
            comboBoxModel.addElement(qlds.getMa());
        }

    }

    private void addCBNSX(ArrayList<QLNSX> List) {
        comboBoxModel = (DefaultComboBoxModel) CbIDNSX.getModel();
        for (QLNSX qlnsx : List) {
            comboBoxModel.addElement(qlnsx.getMa());
        }

    }

    private void addCBMS(ArrayList<QLMauSac> List) {
        comboBoxModel = (DefaultComboBoxModel) CBIDMS.getModel();
        for (QLMauSac qlds : List) {
            comboBoxModel.addElement(qlds.getMa());
        }

    }

    private void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) tb_list.getModel();
        dtm.setRowCount(0);

        for (QLChiTietSP qLChiTietSP : this.iQLChiTienSPService.getAll()) {
            Object[] rowData = {
                qLChiTietSP.getId(),
                qLChiTietSP.getIdSP().getId(),
                qLChiTietSP.getIdNSX().getId(),
                qLChiTietSP.getIdMauSac().getId(),
                qLChiTietSP.getIdDongSP().getId(),
                qLChiTietSP.getNamBh(),
                qLChiTietSP.getMoTa(),
                qLChiTietSP.getSoLuongTon(),
                qLChiTietSP.getGiaNhap(),
                qLChiTietSP.getGiaBan()
            };
            dtm.addRow(rowData);
        }
    }

    private QLChiTietSP getFormData() {

        String namBhStr = txtNBH.getText().trim();
        String motaStr = TxtAreaMT.getText().trim();
        String gianhapStr = TxTGiaNhap.getText().trim();
        String giabanStr = txtGiaBan.getText().trim();
        String soluongtonStr = txtSLT.getText().trim();

        UUID id = null;
      
        if (namBhStr.length() == 0 || motaStr.length() == 0 || giabanStr.length() == 0 || gianhapStr.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống");
            return null;
        }

        int namBh = -1;
        double giaNhap = -1;
        double giaBan = 1;
        int soLuongTon = -1;
        try {
            namBh = Integer.parseInt(namBhStr);

            soLuongTon = Integer.parseInt(soluongtonStr);
            if (namBh < 0 || soLuongTon < 0) {
                JOptionPane.showMessageDialog(this, "Năm Bảo Hành Phải và Số Lượng Tồn > 0");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Số Lượng tồn và Năm Bảo Hành Phải Là Số");
            return null;
        }
        try {
            giaBan = Double.parseDouble(giabanStr);
            giaNhap = Double.parseDouble(gianhapStr);

            soLuongTon = Integer.parseInt(soluongtonStr);
            if (giaBan < 0 || giaBan < 0) {
                JOptionPane.showMessageDialog(this, "Giá > 0");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Giá Phải Là Số");
            return null;
        }
        QLNSX idNsx = new QLNSX(getIDNSX());
        QLMauSac idMauSac = new QLMauSac(getIDMauSac());
        QLDongSp idDsp = new QLDongSp(getIDDSP());
        QLSanPham idSP = new QLSanPham(getIDSanPham());


        QLChiTietSP chiTietSP = new QLChiTietSP(id, idSP, idNsx, idMauSac, idDsp, namBh, motaStr, soLuongTon, giaNhap, giaBan);
        return chiTietSP;
    }

//     private UUID getIdSP(){
//         String tenSp = (String) CbIDSP.getSelectedItem();
//         UUID id = null;
//         for (QLSanPham qLSanPham : qLSanPhams) {
//             qLSanPham.setTen();
//         }
//        
//     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        lbID = new javax.swing.JLabel();
        txtNBH = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAreaMT = new javax.swing.JTextArea();
        txtSLT = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        TxTGiaNhap = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_list = new javax.swing.JTable();
        CbIDSP = new javax.swing.JComboBox<>();
        CbIDNSX = new javax.swing.JComboBox<>();
        CBIDMS = new javax.swing.JComboBox<>();
        CbIDDSP = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnRest = new javax.swing.JButton();

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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Chi Tiết Sản Phẩm ");

        jLabel2.setText("ID: ");

        jLabel3.setText("ID SP: ");

        jLabel4.setText("ID NSX: ");

        jLabel5.setText("ID Màu Sắc: ");

        jLabel6.setText("ID Dòng Sản Phẩm: ");

        jLabel7.setText("Năm Bảo Hành: ");

        jLabel8.setText("Mô Tả: ");

        jLabel9.setText("Số Lượng Tồn: ");

        jLabel10.setText("Giá Nhập: ");

        jLabel11.setText("Giá Bán:  ");

        lbID.setText("--");

        TxtAreaMT.setColumns(20);
        TxtAreaMT.setRows(5);
        jScrollPane1.setViewportView(TxtAreaMT);

        tb_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Sản Phẩm", "NSX", "Màu Sắc", "Dòng SP", "Năm BH", "Mô Tả", "Số Lượng Tồn", "Giá Nhập", "Giá Bán"
            }
        ));
        tb_list.setToolTipText("");
        tb_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_listMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_list);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSua.setText("Update");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Delete");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnRest.setText("Clear");
        btnRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(87, 87, 87)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CBIDMS, 0, 207, Short.MAX_VALUE)
                                        .addComponent(CbIDNSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CbIDSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNBH)
                                    .addComponent(TxTGiaNhap)
                                    .addComponent(txtGiaBan)
                                    .addComponent(txtSLT)
                                    .addComponent(jScrollPane1)
                                    .addComponent(CbIDDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXoa)
                                    .addComponent(btnRest))))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbID))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CbIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(CbIDNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnSua)))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(CBIDMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(CbIDDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnXoa)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRest)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSLT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(TxTGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        QLChiTietSP chiTietSP = this.getFormData();
        if (chiTietSP == null) {
            return;
        }
      
        this.iQLChiTienSPService.insert(chiTietSP);
        
        loadTable();
        clearFrom();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tb_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_listMouseClicked
        int row = tb_list.getSelectedRow();
        if (row < -1) {
            return;
        }

        String idStr = tb_list.getValueAt(row, 0).toString();
//        QLSanPham idSPStr = (QLSanPham) tb_list.getValueAt(row, 1);
//        QLNSX idNSXStr = (QLNSX) tb_list.getValueAt(row, 2);
//        QLMauSac idMSStr = (QLMauSac) tb_list.getValueAt(row, 3);
//        QLDongSp idDSPStr = (QLDongSp) tb_list.getValueAt(row, 4);
        String namBh = tb_list.getValueAt(row, 5).toString();
        String soLuongTon = tb_list.getValueAt(row, 7).toString();
        String MoTa = tb_list.getValueAt(row, 6).toString();
        String giaBan = tb_list.getValueAt(row, 8).toString();
        String giaNhap = tb_list.getValueAt(row, 9).toString();
        this.lbID.setText(idStr);
        this.txtNBH.setText(namBh);
        this.txtSLT.setText(soLuongTon);
        this.txtGiaBan.setText(giaBan);
        this.TxTGiaNhap.setText(giaNhap);
        this.TxtAreaMT.setText(MoTa);

    }//GEN-LAST:event_tb_listMouseClicked
    private void clearFrom() {
        this.lbID.setText("--");
        this.CbIDSP.setSelectedIndex(0);
        this.CBIDMS.setSelectedIndex(0);
        this.CbIDSP.setSelectedIndex(0);
        this.CbIDNSX.setSelectedIndex(0);
        txtGiaBan.setText("");
        TxTGiaNhap.setText("");
        txtNBH.setText("");
        TxtAreaMT.setText("");
        txtSLT.setText("");

    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = this.tb_list.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dữ liệu cần xóa");
            return;
        }

        int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa", "Xóa", JOptionPane.YES_NO_OPTION);
        if (chon != JOptionPane.YES_OPTION) {
            return;
        }

        String idStr = this.tb_list.getValueAt(row, 0).toString();
        UUID id = UUID.fromString(idStr);
        this.iQLChiTienSPService.delete(id);
        this.loadTable();
//        this.clearForm();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        QLChiTietSP chiTietSP = this.getFormData();
//        if(chiTietSP == null){
//        return;
//        }
//        
//        this.iQLChiTienSPService.update(chiTietSP.getId(), chiTietSP);
//        loadTable();

        int row = this.tb_list.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn để Sửa");
            return;
        }
        if (chiTietSP == null) {
            return;
        }
        String idStr = this.tb_list.getValueAt(row, 0).toString();
        UUID id = UUID.fromString(idStr);
        this.iQLChiTienSPService.update(id, chiTietSP);

        loadTable();
        clearFrom();
    }//GEN-LAST:event_btnSuaActionPerformed
    private int findIndexComboboxMSById(UUID id) {
        int total1 = this.CBIDMS.getMaximumRowCount();
        for (int i = 0; i < total1; i++) {
            QLMauSac mauSac = this.CBIDMS.getItemAt(i);
            if (id == mauSac.getId()) {
                return i;
            }
        }

        return -1;
    }

    private int findIndexComboboxNsxById(UUID id) {
        int total3 = this.CbIDNSX.getMaximumRowCount();

        for (int i = 0; i < total3; i++) {
            QLNSX qlnsx = this.CbIDNSX.getItemAt(i);
            if (id == qlnsx.getId()) {
                return i;
            }
        }
        return -1;
    }

    private int findIndexComboboxDspById(UUID id) {
        int total2 = this.CbIDDSP.getMaximumRowCount();

        for (int i = 0; i < total2; i++) {
            QLDongSp dongSp = CbIDDSP.getItemAt(i);
            if (id == dongSp.getId()) {
                return i;
            }
        }
        return -1;
    }

    private int findIndexComboboxSPById(UUID id) {
        int total = this.CbIDSP.getMaximumRowCount();
        String Ma = null;
        for (int i = 0; i < total; i++) {
            QLSanPham sanPham = this.CbIDSP.getItemAt(i);
            if (Ma.equals(sanPham.getMa())) {
                id = sanPham.getId();
                return i;
            }
        }

        return -1;
    }


    private void btnRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestActionPerformed
        clearFrom();    }//GEN-LAST:event_btnRestActionPerformed

    private UUID getIDMauSac() {
        String mauSac = (String) CBIDMS.getSelectedItem();
        UUID idMS = null;
        for (QLMauSac x : listMauSac) {
            if (x.getMa().equals(mauSac)) {
                idMS = x.getId();
            }
        }
        return idMS;
    }

    private UUID getIDNSX() {
        String nsx = (String) CbIDNSX.getSelectedItem();
        UUID idNsx = null;
        for (QLNSX lnsx : lnsxs) {
            if (lnsx.getMa().equals(nsx)) {
                idNsx = lnsx.getId();
            }
        }
        return idNsx;
    }

    private UUID getIDDSP() {
        String dongSp = (String) CbIDDSP.getSelectedItem();
        UUID idDsp = null;
        for (QLDongSp lDongSps : lDongSpss) {
            if (lDongSps.getMa().equals(dongSp)) {
                idDsp = lDongSps.getId();
            }
        }
        return idDsp;
    }

    private UUID getIDSanPham() {
        String sanPham = (String) CbIDSP.getSelectedItem();
        UUID idSP = null;
        for (QLSanPham qLSanPham : lSanPhams) {
            if (qLSanPham.getMa().equals(sanPham)) {
                idSP = qLSanPham.getId();
            }
        }
        return idSP;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and /feel */
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
            java.util.logging.Logger.getLogger(FormQLChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQLChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQLChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQLChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQLChiTietSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<QLMauSac> CBIDMS;
    private javax.swing.JComboBox<QLDongSp> CbIDDSP;
    private javax.swing.JComboBox<QLNSX> CbIDNSX;
    private javax.swing.JComboBox<QLSanPham> CbIDSP;
    private javax.swing.JTextField TxTGiaNhap;
    private javax.swing.JTextArea TxtAreaMT;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRest;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbID;
    private javax.swing.JTable tb_list;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtNBH;
    private javax.swing.JTextField txtSLT;
    // End of variables declaration//GEN-END:variables
}
