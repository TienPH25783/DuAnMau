/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLHoaDon;
import ViewModels.QLHoaDonChiTiet;
import java.util.List;

/**
 *
 * @author hp
 */
public interface IQLHoaDonChiTietService {

    List<QLHoaDonChiTiet> getAll();

    String insert(QLHoaDonChiTiet qlhdct);

    String update(QLHoaDonChiTiet qlhdct, QLHoaDon idHoaDon);

    String insert(QLHoaDon idHoaDon);
}
