/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLCuaHang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IQlCuaHangService {
     List<QLCuaHang> getAll();
    
    void insert(QLCuaHang qLCuaHang);
    
    void update( QLCuaHang qlch, UUID id);
    
    UUID delete(UUID id);
}
