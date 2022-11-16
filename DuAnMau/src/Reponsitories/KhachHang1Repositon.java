/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import DomainModels.KhachHang1;
import Utilities.DBConectionJDBC;
import java.util.List;
import java.util.UUID;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ongbi
 */
public class KhachHang1Repositon implements IKhachHang1Repository{
         final String INSERT_SQL = "INSERT INTO KhachHang (Ma, Ten, TenDem, Ho, DiaChi) Values (?, ?, ?, ?, ?)";
         final String UPDATE_SQL = "UPDATE KhachHang SET Ma = ?, Ten = ?, TenDem = ?, Ho = ?, DiaChi = ? Where Ma = ? ";
         final String DELETE_SQL = "DELETE FROM KhachHang Where Ma = ?";
         final String SELECT_SQL = "SELECT Ma, Ten, TenDem, Ho, DiaChi FROM KhachHang ";
    @Override
    public List<KhachHang1> getAll() {
        List<KhachHang1> list = new ArrayList<>();
             try {
                 Connection conn = DBConectionJDBC.getConnection();
                 PreparedStatement ps = conn.prepareStatement(SELECT_SQL);
                 ps.execute();
                 ResultSet rs = ps.getResultSet();
                 
                 while (rs.next() == true) {                     
//                UUID id = UUID.fromString(rs.getString("Id"));
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");
                String TenDem = rs.getString("TenDem");
                String Ho = rs.getString("Ho");
                String DiaChi = rs.getString("DiaChi");
                
                KhachHang1 kh = new KhachHang1( Ma, Ten, TenDem, Ho, DiaChi);
                list.add(kh);
                 }
             } catch (Exception ex) {
                 Logger.getLogger(KhachHang1Repositon.class.getName()).log(Level.SEVERE, null, ex);
             }
          return list;
    }

    @Override
    public void insert(KhachHang1 kh) {
             try {
                 Connection conn = DBConectionJDBC.getConnection(); 
                 PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
                ps.setString(1, kh.getMa());
                ps.setObject(2, kh.getTen());
                ps.setObject(3, kh.getTenDem());
                ps.setObject(4, kh.getHo());
                ps.setObject(5, kh.getDiaChi());
                ps.execute();
                         } catch (Exception ex) {
                 Logger.getLogger(KhachHang1Repositon.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    @Override
    public void update(KhachHang1 kh, String Ma) {
             try {
                 Connection conn = DBConectionJDBC.getConnection();
                 PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
                  ps.setString(5, kh.getMa());
                ps.setObject(1, kh.getTen());
                ps.setObject(2, kh.getTenDem());
                ps.setObject(3, kh.getHo());
                ps.setObject(4, kh.getDiaChi());
                ps.execute();
             } catch (Exception ex) {
                 Logger.getLogger(KhachHang1Repositon.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    @Override
    public String delete(String Ma) {
             try {
                 Connection conn = DBConectionJDBC.getConnection();
                 PreparedStatement ps = conn.prepareStatement(DELETE_SQL);
                  ps.setObject(1, Ma);
                  ps.execute();
             } catch (Exception ex) {
                ex.printStackTrace();
             }
             return Ma;
    }
    
}
