/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import DomainModels.ChiTietSP;
import DomainModels.SanPham;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.DongSP;
import Utilities.DBConectionJDBC;
import java.util.List;
import java.util.UUID;
import java.sql.*;
import java.util.ArrayList;

public class ChiTietSPRepositoty implements IChiTietSPRepository {
   
    final String INSERT_SQL = "INSERT INTO [dbo].[ChiTietSP]"
            + "           ([IdSP]"
            + "           ,[IdNsx]"
            + "           ,[IdMauSac]"
            + "           ,[IdDongSP]"
            + "           ,[NamBH]"
            + "           ,[MoTa]"
            + "           ,[SoLuongTon]"
            + "           ,[GiaNhap]"
            + "           ,[GiaBan])"
            + "     VALUES(?,?,?,?,?,?,?,?,?)";

    final String UPDATE_SQL = "UPDATE [dbo].[ChiTietSP]  SET  "
            + "[IdSP] = ? ,[IdNsx] = ?,[IdMauSac] = ?,[IdDongSP] = ?,[NamBH] = ?,[MoTa] = ?,[SoLuongTon] = ?,[GiaNhap] = ? ,[GiaBan] = ?"
            + " WHERE [Id] = ?";
    final String DELETE_SQL = "DELETE FROM [dbo].[ChiTietSP]"
            + "      WHERE Id = ?";
    final String SELECT_SQL = " SELECT dbo.ChiTietSP.Id, dbo.SanPham.Id , dbo.DongSP.Id , dbo.NSX.Id , dbo.MauSac.Id , dbo.ChiTietSP.NamBH, ChiTietSP.MoTa,ChiTietSP.SoLuongTon,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,"
            + "                                  dbo.ChiTietSP.MoTa, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan"
            + "                FROM     dbo.ChiTietSP INNER JOIN "
            + "                                 dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN "
            + "                                 dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id INNER JOIN "
            + "                                 dbo.NSX ON dbo.ChiTietSP.IdNsx = dbo.NSX.Id INNER JOIN "
            + "                                 dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id;";
//    final String SELECT_SQL = "SELECT * FROM ChiTietSP";

    @Override

    public List<ChiTietSP> getAll() {
        List<ChiTietSP> ctsps = new ArrayList<>();
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_SQL);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                UUID Id = UUID.fromString(rs.getString(1));
//                UUID IdSP = UUID.fromString(rs.getString("IdSP"));  
//                UUID IdNsx = UUID.fromString(rs.getString("IdNsx"));  
//                UUID IdMauSac = UUID.fromString(rs.getString("IdMauSac")); 
//                SanPham sanPham = new SanPham(UUID.fromString(rs.getString("IdSP")));
                SanPham sanPham = new SanPham(UUID.fromString(rs.getString(2)));
                DongSP dongSP = new DongSP(UUID.fromString(rs.getString(5)));
                NSX nsx = new NSX(UUID.fromString(rs.getString(3)));
                MauSac mauSac = new MauSac(UUID.fromString(rs.getString(4)));

                Integer NamBh = rs.getInt(6);
                String MoTa = rs.getString(7);
                Integer SoluongTon = rs.getInt(8);
                double GiaNhap = rs.getDouble(9);
                double GiaBan = rs.getDouble(10);

                ChiTietSP chiTietSP = new ChiTietSP(Id, sanPham, nsx, mauSac, dongSP, NamBh, MoTa, SoluongTon, GiaNhap, GiaBan);
                ctsps.add(chiTietSP);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ctsps;
    }

    @Override
    public boolean insert(ChiTietSP chiTietSP) {
        int check = 0;
        try {

            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);

            ps.setObject(1, chiTietSP.getSanPham().getId());
            ps.setObject(2, chiTietSP.getNsx().getId());
            ps.setObject(3, chiTietSP.getMauSac().getId());
            ps.setObject(4, chiTietSP.getDongSP().getId());
            ps.setObject(5, chiTietSP.getNamBh());
            ps.setObject(6, chiTietSP.getMoTa());
            ps.setObject(7, chiTietSP.getSoLuongTon());
            ps.setObject(8, chiTietSP.getGiaNhap());
            ps.setObject(9, chiTietSP.getGiaBan());
            check = ps.executeUpdate();
            System.out.println("Thanh Cong");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(UUID id, ChiTietSP chiTietSP) {
        int check = 0;
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
             ps.setObject(1, chiTietSP.getSanPham().getId());
            ps.setObject(2, chiTietSP.getNsx().getId());
            ps.setObject(3, chiTietSP.getMauSac().getId());
            ps.setObject(4, chiTietSP.getDongSP().getId());
            ps.setObject(5, chiTietSP.getNamBh());
            ps.setObject(6, chiTietSP.getMoTa());
            ps.setObject(7, chiTietSP.getSoLuongTon());
            ps.setObject(8, chiTietSP.getGiaNhap());
            ps.setObject(9, chiTietSP.getGiaBan());
            ps.setObject(10, id);
           check = ps.executeUpdate();

            System.out.println("Đã chạy");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check>0;
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
        SanPham idSP = new SanPham(UUID.fromString("0E5DB180-376A-4B48-9E33-6F8BA7F5EFC5"));
        NSX idNSX = new NSX(UUID.fromString("9A5768C7-E795-4BBF-841F-A8312668B637"));
        DongSP idDongSP = new DongSP(UUID.fromString("4C1AFF91-7229-47E4-ADB0-26BAA6F3C8F3"));
        MauSac idMauSac = new MauSac(UUID.fromString("0C01CFDB-000A-4EB2-83AA-2D4B53CEBFBD"));
        ChiTietSP p = new ChiTietSP(idSP, idNSX, idMauSac, idDongSP, 2020, "2", 11, 145.00, 440.02);
        System.out.println(new ChiTietSPRepositoty().update(p.getId(), p));
    }

}
