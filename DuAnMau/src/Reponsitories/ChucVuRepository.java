/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import DomainModels.ChucVu;
import Utilities.DBConectionJDBC;
import java.util.List;
import java.util.UUID;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ongbi
 */
public class ChucVuRepository implements IChucVuRepository {

    final String INSERT_SQL = "INSERT INTO [dbo].[ChucVu]"
            + "           ([Ma]"
            + "           ,[Ten])"
            + "     VALUES(?,?)";

    final String UPDATE_SQL = "UPDATE [dbo].[ChucVu] "
            + "   SET[Ma] = ? "
            + "      ,[Ten] = ? "
            + " WHERE id = ? ";

    final String DELETE_SQL = "DELETE FROM [dbo].[ChucVu] "
            + "      WHERE id = ?";

    final String SELECT_SQL = "SELECT [Id] "
            + "      ,[Ma] "
            + "      ,[Ten] "
            + "  FROM [dbo].[ChucVu]";

    @Override
    public List<ChucVu> getAll() {
        List<ChucVu> listCV = new ArrayList<>();

        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                UUID id = UUID.fromString(rs.getString("Id"));
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");

                ChucVu chucVu = new ChucVu(id, Ma, Ten);
                listCV.add(chucVu);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listCV;
    }

    @Override
    public void insert(ChucVu chucVu) {
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
            ps.setString(1, chucVu.getMa());
            ps.setString(2, chucVu.getTen());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(UUID id, ChucVu chucVu) {
        try {
            Connection conn = DBConectionJDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
            ps.setString(1, chucVu.getMa());
            ps.setString(2, chucVu.getTen());
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
