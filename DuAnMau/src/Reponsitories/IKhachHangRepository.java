/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import DomainModels.KhachHang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IKhachHangRepository {
    List<KhachHang> getAll();


    boolean insert(KhachHang kh);

    boolean update(KhachHang kh, UUID id);

    boolean delete(UUID id);
}
