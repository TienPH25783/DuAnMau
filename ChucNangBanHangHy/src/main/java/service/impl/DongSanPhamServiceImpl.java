/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.DongSanPham;
import repository.DongSanPhamRep;
import service.DongSanPhamService;

/**
 *
 * @author Admin
 */
public class DongSanPhamServiceImpl implements DongSanPhamService {

    DongSanPhamRep dongSanPhamRep = new DongSanPhamRep();

    @Override
    public List<DongSanPham> getDongSanPham() {
        return dongSanPhamRep.getDongSanPham();
    }

    @Override
    public DongSanPham getByMaDSP(String maDSP) {
        return dongSanPhamRep.getByMa(maDSP);
    }

}
