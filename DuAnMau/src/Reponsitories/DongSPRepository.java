/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import DomainModels.DongSP;
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
public class DongSPRepository implements IDongSPRepository{
    final String INSERT_SQL = "INSERT INTO DongSP ( Ma, Ten) Values (?,?)";
    final String UPDATE_SQL = "UPDATE DongSP SET Ma=?, Ten=? Where Id = ?";
    final String DELETE_SQL = "DELETE FROM DongSP Where Id=?";
    final String SELECT_SQL = "SELECT * FROM DongSP";
   
    @Override
    public List<DongSP> getAll() {
         List<DongSP> listDSP = new ArrayList<>();
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
                UUID id = UUID.fromString(rs.getString("Id"));
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");

               DongSP dongSP = new DongSP(id, Ma, Ten);
               listDSP.add(dongSP);
            }
            System.out.println("Thanh Cong");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listDSP;
    }

    @Override
    public void insert(DongSP dongSP) {
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);

            ps.setString(1, dongSP.getMa());
            ps.setString(2, dongSP.getTen());
            ps.executeUpdate();

            System.out.println("Thanh Cong");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        
    }

    @Override
    public void update(UUID id, DongSP dongSP) {

   try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
            ps.setString(1, dongSP.getMa());
            ps.setString(2, dongSP.getTen());
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
