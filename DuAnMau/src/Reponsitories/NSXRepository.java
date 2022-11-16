/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import DomainModels.NSX;
import Utilities.DBConectionJDBC;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.*;

/**
 *
 * @author ongbi
 */
public class NSXRepository implements INSXRepository{
final String INSERT_SQL = "INSERT INTO NSX ( Ma, Ten) Values (?,?)";
    final String UPDATE_SQL = "UPDATE NSX SET Ma=?, Ten=? Where Id = ?";
    final String DELETE_SQL = "DELETE FROM NSX Where Id=?";
    final String SELECT_SQL = "SELECT * FROM NSX";

    @Override
    public List<NSX> getAll() {
        List<NSX> listNSX = new ArrayList<>();

        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                UUID id = UUID.fromString(rs.getString("Id"));
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");

               NSX nsx = new NSX(id, Ma, Ten);
                listNSX.add(nsx);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listNSX;    }

    @Override
    public void insert(NSX nsx) {
           try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
            ps.setString(1, nsx.getMa());
            ps.setString(2, nsx.getTen());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(UUID id, NSX nsx) {
      try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
            ps.setString(1, nsx.getMa());
            ps.setString(2, nsx.getTen());
            ps.setObject(3, id);
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
