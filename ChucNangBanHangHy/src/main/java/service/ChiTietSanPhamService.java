/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ChiTietSanPham;

/**
 *
 * @author Admin
 */
public interface ChiTietSanPhamService {
 
    List<ChiTietSanPham> getListCTSP();
    
    Boolean saveCTSP(ChiTietSanPham ctsp);
    
    Boolean deleteCTSP(ChiTietSanPham ctsp);
    
    Boolean updateCTSP(ChiTietSanPham ctsp);
    
    ChiTietSanPham getById(String id);
    
}
