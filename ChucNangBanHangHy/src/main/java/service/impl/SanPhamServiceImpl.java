/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.SanPham;
import repository.SanPhamRep;
import service.SanPhamService;

/**
 *
 * @author Admin
 */
public class SanPhamServiceImpl implements SanPhamService{

    SanPhamRep sanPhamRep = new SanPhamRep();
    
    @Override
    public List<SanPham> getSanPham() {
        return sanPhamRep.getSanPham();
    }

    @Override
    public SanPham getByMaSP(String maSP) {
        return sanPhamRep.getByMa(maSP);
    }
    
    
}
