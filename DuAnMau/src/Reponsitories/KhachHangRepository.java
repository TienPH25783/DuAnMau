/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import DomainModels.KhachHang;
import Utilities.DBConectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ongbi
 */
public class KhachHangRepository implements IKhachHangRepository{

    @Override
    public List<KhachHang> getAll() {
   String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "      ,[TenDem] "
                + "      ,[Ho] "
                + "      ,[NgaySinh] "
                + "      ,[Sdt] "
                + "      ,[DiaChi] "
                + "      ,[ThanhPho] "
                + "      ,[QuocGia] "
                + "      ,[MatKhau] "
                + "  FROM [dbo].[KhachHang]";
        try ( Connection con = DBConectionJDBC.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<KhachHang> listKhachHang = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                listKhachHang.add(kh);
            }
            return listKhachHang;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;    }

    @Override
    public boolean insert(KhachHang kh) {
 String query = "INSERT INTO [dbo].[KhachHang] "
                + "           ([Ma] "
                + "           ,[Ten] "
                + "           ,[TenDem] "
                + "           ,[Ho] "
                + "           ,[NgaySinh] "
                + "           ,[Sdt] "
                + "           ,[DiaChi] "
                + "           ,[ThanhPho] "
                + "           ,[QuocGia] "
                + "           ,[MatKhau]) "
                + "     VALUES "
                + "           (?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConectionJDBC.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, kh.getSdt());
            ps.setObject(7, kh.getDiaChi());
            ps.setObject(8, kh.getThanhPho());
            ps.setObject(9, kh.getQuocGia());
            ps.setObject(10, kh.getMatKhau());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;    }

    @Override
    public boolean update(KhachHang kh, UUID id) {
 String query = "UPDATE [dbo].[KhachHang] "
                + "   SET [Ma] = ? "
                + "      ,[Ten] = ? "
                + "      ,[TenDem] = ? "
                + "      ,[Ho] = ? "
                + "      ,[NgaySinh] = ? "
                + "      ,[Sdt] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[ThanhPho] = ? "
                + "      ,[QuocGia] = ? "
                + "      ,[MatKhau] = ? "
                + " WHERE Id = ?";
        int check = 0;
        try ( Connection con = DBConectionJDBC.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, kh.getSdt());
            ps.setObject(7, kh.getDiaChi());
            ps.setObject(8, kh.getThanhPho());
            ps.setObject(9, kh.getQuocGia());
            ps.setObject(10, kh.getMatKhau());
            ps.setObject(11, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;    }

    @Override
    public boolean delete(UUID id) {
   String query = "DELETE FROM [dbo].[KhachHang] "
                + "      WHERE Id = ?";
        int check = 0;
        try ( Connection con = DBConectionJDBC.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;    }
    
}
