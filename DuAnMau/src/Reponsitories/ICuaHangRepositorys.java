/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import DomainModels.CuaHang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface ICuaHangRepositorys {
     List<CuaHang> getAll();
    
    void insert(CuaHang cuaHang);
    
    void update (UUID id, CuaHang cuaHang);
    
    UUID delete(UUID id);

   
}
