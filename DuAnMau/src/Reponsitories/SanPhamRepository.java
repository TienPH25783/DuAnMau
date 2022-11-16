/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import DomainModels.SanPham;
import Utilities.DBConectionJDBC;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.UUID;

public class SanPhamRepository implements ISanPhamRepositoty {

    final String INSERT_SQL = "INSERT INTO SanPham ( Ma, Ten) Values (?,?)";
    final String UPDATE_SQL = "UPDATE SanPham SET Ma=?, Ten=? Where Id = ?";
    final String DELETE_SQL = "DELETE FROM SanPham Where Id=?";
    final String SELECT_SQL = "SELECT Id, Ten, Ma FROM SanPham";

    public SanPhamRepository() {
    }

    @Override
    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> listSP = new ArrayList<>();
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
                UUID id = UUID.fromString(rs.getString("Id"));
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");

                SanPham sanPham = new SanPham(id, Ma, Ten);
                listSP.add(sanPham);
            }
            System.out.println("Thanh Cong");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listSP;
    }

    @Override
    public void insert(SanPham sanPham) {
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);

            ps.setString(1, sanPham.getMa());
            ps.setString(2, sanPham.getTen());
            ps.executeUpdate();

            System.out.println("Thanh Cong");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void update(SanPham sanPham, UUID id) {
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
            ps.setString(1, sanPham.getMa());
            ps.setString(2, sanPham.getTen());
            ps.setObject(3, id);
            ps.executeUpdate();

            System.out.println("Thanh cong");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public UUID delete(UUID id) {
        try {

            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_SQL);
            ps.setObject(1, id);
            ps.execute();

            System.out.println("Thanh Cong");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    

}
