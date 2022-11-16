/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author hp
 */
public interface IHoaDonChiTietRepository {

    List<HoaDonChiTiet> getAll();

    boolean insert(HoaDonChiTiet hdct);

    boolean update(HoaDonChiTiet hdct, HoaDon idHoaDon);

    boolean insert(HoaDon idHoaDon);
}
