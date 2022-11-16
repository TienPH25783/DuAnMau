/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NhanVien;
import java.util.List;
import ViewModels.QLNhanVien;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IQLNhanVienService {

    List<QLNhanVien> getAll();

    String insert(QLNhanVien qlnv);

    void update(QLNhanVien qlnv, UUID id);

    UUID delete(UUID id);

   
}
