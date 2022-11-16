/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ViewModels.QLNhanVien;
import ViewModels.QLCuaHang;
import ViewModels.QLChucVu;
import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Reponsitories.NhanVienRepository;
import Reponsitories.INhanVienRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 *
 * @author ongbi
 */
public class QLNhanVienService implements IQLNhanVienService{
    final INhanVienRepository iNhanVienRepository; 
    List<QLNhanVien> lNhanViens;
    public QLNhanVienService() {
        iNhanVienRepository = new NhanVienRepository();
        lNhanViens = new ArrayList<>();
    }
    
    @Override
    public List<QLNhanVien> getAll() {
        lNhanViens = new ArrayList<>();
        var QLNV = this.iNhanVienRepository.getAll();
        for (NhanVien qLNhanVien : QLNV) {
            QLCuaHang cuaHang = new QLCuaHang(qLNhanVien.getIdCh().getId());
            QLChucVu chucVu = new QLChucVu(qLNhanVien.getIdCv().getId());
            QLNhanVien nhanVien = new QLNhanVien(qLNhanVien.getIdGuiBC().getId());
            lNhanViens.add(new QLNhanVien(qLNhanVien.getId(), qLNhanVien.getMa(), qLNhanVien.getTen(), qLNhanVien.getTenDem(), qLNhanVien.getHo(), qLNhanVien.getGioiTinh(), qLNhanVien.getNgaySinh(), qLNhanVien.getGioiTinh(), qLNhanVien.getSdt(), qLNhanVien.getMatKhau(), cuaHang, chucVu, nhanVien, qLNhanVien.getTrangThai()));
            
        }
        return lNhanViens;
        
        
    }

    @Override
    public String insert(QLNhanVien qlnv) {
      CuaHang cuaHang = new CuaHang(qlnv.getIdCh().getId());
      ChucVu chucVu = new ChucVu(qlnv.getIdCv().getId());
      NhanVien nhanVien = new NhanVien(qlnv.getIdGuiBC().getId());
      NhanVien nv = new NhanVien(qlnv.getMa(), qlnv.getTen(), qlnv.getTenDem(), qlnv.getHo(), qlnv.getGioiTinh(), qlnv.getNgaySinh(), qlnv.getDiaChi(), qlnv.getSdt(), qlnv.getMatKhau(), cuaHang, chucVu, nhanVien, qlnv.getTrangThai());
    this.iNhanVienRepository.insert(nv);
        return "ThanhCOng";
    }

    @Override
    public void update(QLNhanVien qlnv, UUID id) {
  CuaHang cuaHang = new CuaHang(qlnv.getIdCh().getId());
      ChucVu chucVu = new ChucVu(qlnv.getIdCv().getId());
      NhanVien nhanVien = new NhanVien(qlnv.getIdGuiBC().getId());
      NhanVien nv = new NhanVien( qlnv.getMa(), qlnv.getTen(), qlnv.getTenDem(), qlnv.getHo(), qlnv.getGioiTinh(), qlnv.getNgaySinh(), qlnv.getDiaChi(), qlnv.getSdt(), qlnv.getMatKhau(), cuaHang, chucVu, nhanVien, qlnv.getTrangThai());
      this.iNhanVienRepository.update(nv, id);    }

    @Override
    public UUID delete(UUID id) {

        return iNhanVienRepository.delete(id);

    }
    public static void main(String[] args) {
        //System.out.println(new NhanVienRepository().getOne(UUID.fromString("90288D94-69FF-4A1A-90BE-1FCAA636B3E8")));
        System.out.println(new QLNhanVienService().getAll());
        QLCuaHang idCh = new QLCuaHang(UUID.fromString("8239FFA6-1ECF-4FC1-A1E1-B21BD3B75480"));
        QLChucVu idCv = new QLChucVu(UUID.fromString("A1D7FAEC-0FF4-4219-92F2-932459374B3A"));
        QLNhanVien idNv = new QLNhanVien(UUID.fromString("1563429B-5A88-4551-917E-183F999F98AF"));
        Date ngaySinh = new Date(21-12-2012);
        QLNhanVien nv = new QLNhanVien("2", "SG", "SD", "UU", "Nam", ngaySinh, "SDD", "0002255", "RRRE", idCh, idCv, idNv, 1);
        
        System.out.println(new QLNhanVienService().insert(nv));
    }
}
