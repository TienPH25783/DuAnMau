/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLChiTietSP;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IQLChiTietSPService {
    
    List<QLChiTietSP> getAll();

    void insert(QLChiTietSP qLChiTietSP);

    void update(UUID id, QLChiTietSP qLChiTietSP);

    UUID delete(UUID id);
}
