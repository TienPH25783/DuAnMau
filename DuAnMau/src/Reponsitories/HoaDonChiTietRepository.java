/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import DomainModels.ChiTietSP;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Utilities.DBConectionJDBC;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class HoaDonChiTietRepository implements IHoaDonChiTietRepository {

    @Override
    public List<HoaDonChiTiet> getAll() {
        String query = "SELECT dbo.HoaDon.Id, dbo.ChiTietSP.Id , dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.DonGia "
                + "FROM     dbo.HoaDon INNER JOIN "
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.IdHoaDon INNER JOIN "
                + "                  dbo.ChiTietSP ON dbo.HoaDonChiTiet.IdChiTietSP = dbo.ChiTietSP.Id";
        try ( Connection con = DBConectionJDBC.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDonChiTiet> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon idHoaDon = new HoaDon(UUID.fromString(rs.getString(1)));
                ChiTietSP idChiTietSP = new ChiTietSP(UUID.fromString(rs.getString(2)));
                HoaDonChiTiet hdct = new HoaDonChiTiet(idHoaDon, idChiTietSP, rs.getInt(3), rs.getInt(4));
                list.add(hdct);
            }
            return list;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean insert(HoaDonChiTiet hdct) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet] "
                + "           ([SoLuong] "
                + "           ,[DonGia]) "
                + "     VALUES "
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBConectionJDBC.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getSoLuong());
            ps.setObject(2, hdct.getDonGia());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public boolean update(HoaDonChiTiet hdct, HoaDon idHoaDon) {
        String query = "UPDATE [dbo].[HoaDonChiTiet] "
                + "   SET [SoLuong] = ? "
                + "      ,[DonGia] = ? "
                + " WHERE HoaDonChiTiet.IdHoaDon = ?";
        int check = 0;
        try ( Connection con = DBConectionJDBC.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getSoLuong());
            ps.setObject(2, hdct.getDonGia());
            ps.setObject(3, idHoaDon);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    @Override
    public boolean insert(HoaDon idHoaDon) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet] "
                + "      WHERE HoaDonChiTiet.IdHoaDon = ?";
        int check = 0;
        try ( Connection con = DBConectionJDBC.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, idHoaDon);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

}
