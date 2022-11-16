/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import DomainModels.NhanVien;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface INhanVienRepository {

    List<NhanVien> getAll();

    boolean insert(NhanVien nv);

    boolean update(NhanVien nv, UUID id);

    UUID delete(UUID id);

}
