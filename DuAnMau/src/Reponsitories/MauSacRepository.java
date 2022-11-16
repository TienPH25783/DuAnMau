/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import DomainModels.MauSac;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.*;
import Utilities.DBConectionJDBC;
import java.util.logging.Level;
import java.util.logging.Logger;
import DomainModels.MauSac;

/**
 *
 * @author ongbi
 */
public class MauSacRepository implements IMauSacRepository {

    final String INSERT_SQL = "INSERT INTO MauSac ( Ma, Ten) Values (?,?)";
    final String UPDATE_SQL = "UPDATE MauSac SET Ma=?, Ten=? Where Id = ?";
    final String DELETE_SQL = "DELETE FROM MauSac Where Id=?";
    final String SELECT_SQL = "SELECT * FROM MauSac";

    @Override
    public List<MauSac> getAll() {
        List<MauSac> listMS = new ArrayList<>();

        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                UUID id = UUID.fromString(rs.getString("Id"));
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");

                MauSac mauSac = new MauSac(id, Ma, Ten);
                listMS.add(mauSac);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listMS;

    }

    @Override
    public void insert(MauSac mauSac) {
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
            ps.setString(1, mauSac.getMa());
            ps.setString(2, mauSac.getTen());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void update(UUID id, MauSac mauSac) {
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
            ps.setString(1, mauSac.getMa());
            ps.setString(2, mauSac.getTen());
            ps.setObject(3, id);
            ps.execute();
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

}
