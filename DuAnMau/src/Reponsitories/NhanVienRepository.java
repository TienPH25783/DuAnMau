/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import DomainModels.NhanVien;
import Utilities.DBConectionJDBC;
import java.util.List;
import java.util.UUID;
import java.util.Date;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import DomainModels.ChucVu;
import DomainModels.CuaHang;
import java.util.ArrayList;
/**
 *
 * @author ongbi
 */
public class NhanVienRepository implements INhanVienRepository {

    final String SELECT_SQL = "SELECT dbo.NhanVien.Id, dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.TenDem, dbo.NhanVien.Ho, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, dbo.NhanVien.DiaChi, dbo.NhanVien.Sdt, dbo.NhanVien.MatKhau,  "
            + "                  dbo.CuaHang.Id , dbo.ChucVu.Id , dbo.NhanVien.Id,  dbo.NhanVien.Ho+' '+dbo.NhanVien.TenDem+' '+dbo.NhanVien.Ten,  dbo.NhanVien.TrangThai "
            + "              FROM     dbo.CuaHang INNER JOIN "
            + "                  dbo.NhanVien ON dbo.CuaHang.Id = dbo.NhanVien.IdCH INNER JOIN "
            + "                  dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id";

    final String INSERT_SQL = "INSERT INTO [dbo].[NhanVien] "
            + "           ([Ma] "
            + "           ,[Ten] "
            + "           ,[TenDem] "
            + "           ,[Ho] "
            + "           ,[GioiTinh] "
            + "           ,[NgaySinh] "
            + "           ,[DiaChi] "
            + "           ,[Sdt] "
            + "           ,[MatKhau] "
            + "           ,[IdCH] "
            + "           ,[IdCV] "
            + "           ,[IdGuiBC] "
            + "           ,[TrangThai]) "
            + "     VALUES "
            + "           (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL =  "UPDATE [dbo].[NhanVien] "
                + "   SET [Ma] = ? "
                + "      ,[Ten] = ? "
                + "      ,[TenDem] = ? "
                + "      ,[Ho] = ? "
                + "      ,[GioiTinh] = ? "
                + "      ,[NgaySinh] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[Sdt] = ? "
                + "      ,[MatKhau] = ? "
                + "      ,[IdCH] = ? "
                + "      ,[IdCV] = ? "
                + "      ,[IdGuiBC] = ? "
                + "      ,[TrangThai] = ? "
                + " WHERE Id = ?";

    final String DELETE_SQL = "DELETE FROM [dbo].[NhanVien] "
            + "      WHERE Id = ?";

    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {                
               UUID id = UUID.fromString(rs.getString(1));
               String ma = rs.getString(2);
               String ten = rs.getString(3);
               String tenDem = rs.getString(4);
               String ho = rs.getString(5);
               String gioiTinh = rs.getString(6);
               Date ngaySinh = rs.getDate(7);
               String diaChi = rs.getString(8);
               String sdt = rs.getString(9);
               String matKhau = rs.getString(10);
               CuaHang cuaHang = new CuaHang(UUID.fromString(rs.getString(11)));
               ChucVu chucVu = new ChucVu(UUID.fromString(rs.getString(12)));
               NhanVien nhanVien = new NhanVien(UUID.fromString(rs.getString(13)), rs.getString(14));
               int trangThai = rs.getInt(15);
               NhanVien nv = new NhanVien(id, ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, cuaHang, chucVu, nhanVien, trangThai);
               list.add(nv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;

//        String query = "SELECT dbo.NhanVien.Id, dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.TenDem, dbo.NhanVien.Ho, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, dbo.NhanVien.DiaChi, dbo.NhanVien.Sdt, dbo.NhanVien.MatKhau,  "
//                + "                  dbo.CuaHang.Id , dbo.CuaHang.Ten , dbo.ChucVu.Id , dbo.ChucVu.Ten ,dbo.NhanVien.Id,  dbo.NhanVien.Ho+' '+dbo.NhanVien.TenDem+' '+dbo.NhanVien.Ten,  dbo.NhanVien.TrangThai "
//                + "FROM     dbo.CuaHang INNER JOIN "
//                + "                  dbo.NhanVien ON dbo.CuaHang.Id = dbo.NhanVien.IdCH INNER JOIN "
//                + "                  dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id";
//        try ( Connection con = DBConectionJDBC.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
//            List<NhanVien> listNhanVien = new ArrayList<>();
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                CuaHang idCh = new CuaHang(UUID.fromString(rs.getString(11)), rs.getString(12));
//                ChucVu idCv = new ChucVu(UUID.fromString(rs.getString(13)), rs.getString(14));
//                NhanVien idGuiBc = new NhanVien(UUID.fromString(rs.getString(15)), rs.getString(16));
//                NhanVien nv = new NhanVien(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), idCh, idCv, idGuiBc, rs.getInt(17));
//                listNhanVien.add(nv);
//            }
//            return listNhanVien;
//        } catch (SQLException sqle) {
//            sqle.printStackTrace(System.out);
//        } catch (Exception ex) {
//           ex.printStackTrace();
//        }
//        return null;
    } 

    @Override
    public boolean insert(NhanVien nv) {
        int check = 0;
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
           
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getHo());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getNgaySinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getSdt());
            ps.setObject(9, nv.getMatKhau());
            ps.setObject(10, nv.getIdCh().getId());
            ps.setObject(11, nv.getIdCv().getId());
            ps.setObject(12, nv.getIdGuiBC().getId());
            ps.setObject(13, nv.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(NhanVien nv, UUID id) {
    int check = 0;
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
           
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getHo());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getNgaySinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getSdt());
            ps.setObject(9, nv.getMatKhau());
            ps.setObject(10, nv.getIdCh().getId());
            ps.setObject(11, nv.getIdCv().getId());
            ps.setObject(12, nv.getIdGuiBC().getId());
            ps.setObject(13, nv.getTrangThai());
            ps.setObject(14, id);
            check = ps.executeUpdate();
            System.out.println("Thanh cong");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check > 0;
    
    }

    @Override
    public UUID delete(UUID id) {
       try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_SQL);
            ps.setObject(1, id);
            ps.execute();
            System.out.println("thanh cong");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }
     public static void main(String[] args) {
//        System.out.println(new NhanVienRepository().getOne(UUID.fromString("90288D94-69FF-4A1A-90BE-1FCAA636B3E8")));
         System.out.println(new NhanVienRepository().getAll());
        CuaHang idCh = new CuaHang(UUID.fromString("8239FFA6-1ECF-4FC1-A1E1-B21BD3B75480"));
        ChucVu idCv = new ChucVu(UUID.fromString("A1D7FAEC-0FF4-4219-92F2-932459374B3A"));
        NhanVien idNv = new NhanVien(UUID.fromString("1563429B-5A88-4551-917E-183F999F98AF"));
        Date ngaySinh = new Date(21-12-2012);
        NhanVien nv = new NhanVien("2", "SG", "SD", "UU", "Nam", ngaySinh, "SDD", "0002255", "RRRE", idCh, idCv, idNv, 1);
        
        System.out.println(new NhanVienRepository().insert(nv));
    }
}
