/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;


import DomainModels.CuaHang;
import Utilities.DBConectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public class CuaHangRepository implements ICuaHangRepositorys{
       final String INSERT_SQL ="INSERT INTO [dbo].[CuaHang] "
                + "           ([Ma] "
                + "           ,[Ten] "
                + "           ,[DiaChi] "
                + "           ,[ThanhPho] "
                + "           ,[QuocGia]) "
                + "     VALUES "
                + "           (?,?,?,?,?)";

    final String UPDATE_SQL = "UPDATE [dbo].[CuaHang] "
                + "   SET [Ma] = ? "
                + "      ,[Ten] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[ThanhPho] = ? "
                + "      ,[QuocGia] = ? "
                + " WHERE Id =?";

    final String DELETE_SQL ="DELETE FROM [dbo].[CuaHang] "
                + "      WHERE id = ?";

    final String SELECT_SQL = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "      ,[DiaChi] "
                + "      ,[ThanhPho] "
                + "      ,[QuocGia] "
                + "  FROM [dbo].[CuaHang]";
    @Override
    public List<CuaHang> getAll() {
        List<CuaHang> listCH = new ArrayList<>();

        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                UUID id = UUID.fromString(rs.getString("Id"));
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");
                String DiaChi = rs.getString("DiaChi");
                String ThanhPho = rs.getString("ThanhPho");
                String QuocGia = rs.getString("QuocGia");
               

                CuaHang ch = new CuaHang(id, Ma, Ten, DiaChi, ThanhPho, QuocGia);
                listCH.add(ch);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listCH;
    }

    @Override
    public void insert(CuaHang cuaHang) {
 try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
            ps.setString(1, cuaHang.getMa());
            ps.setString(2, cuaHang.getTen());
            ps.setString(3, cuaHang.getDiaChi());
            ps.setString(4, cuaHang.getThanhPho());
            ps.setString(5, cuaHang.getQuocGia());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void update(UUID id, CuaHang cuaHang) {
   try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
           ps.setString(1, cuaHang.getMa());
            ps.setString(2, cuaHang.getTen());
            ps.setString(3, cuaHang.getDiaChi());
            ps.setString(4, cuaHang.getThanhPho());
            ps.setString(5, cuaHang.getQuocGia());
            ps.setObject(6, id);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }    }

    @Override
    public UUID delete(UUID id) {
try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_SQL);
            ps.setObject(1, id);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
        }
    
}
