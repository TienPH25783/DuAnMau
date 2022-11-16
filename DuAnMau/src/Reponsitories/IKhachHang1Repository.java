/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import DomainModels.KhachHang1;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IKhachHang1Repository {
    List<KhachHang1> getAll();
    
    void insert(KhachHang1 kh);
    
    void update(KhachHang1 kh, String Ma);
    
    String delete(String Ma);
}
