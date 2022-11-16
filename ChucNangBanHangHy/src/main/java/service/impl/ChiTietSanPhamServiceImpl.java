/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.ChiTietSanPham;
import repository.ChiTietSanPhamRep;
import service.ChiTietSanPhamService;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService{

    ChiTietSanPhamRep CTSPRep = new ChiTietSanPhamRep();
    
    @Override
    public List<ChiTietSanPham> getListCTSP() {
        return CTSPRep.getListCTSP();
    }

    @Override
    public Boolean saveCTSP(ChiTietSanPham ctsp) {
        return CTSPRep.saveCTSP(ctsp);
    }

    @Override
    public Boolean deleteCTSP(ChiTietSanPham ctsp) {
        return CTSPRep.deleteCTSP(ctsp);
    }

    @Override
    public Boolean updateCTSP(ChiTietSanPham ctsp) {
        return CTSPRep.updateCTSP(ctsp);
    }

    @Override
    public ChiTietSanPham getById(String id) {
        return CTSPRep.getListCTSP(id);
    }
    
    
    
}
