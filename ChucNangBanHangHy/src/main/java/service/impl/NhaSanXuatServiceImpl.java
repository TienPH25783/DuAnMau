/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.NhaSanXuat;
import repository.NhaSanXuatRep;
import service.NhaSanXuatService;

/**
 *
 * @author Admin
 */
public class NhaSanXuatServiceImpl implements NhaSanXuatService{
    
    NhaSanXuatRep nhaSanXuatRep = new NhaSanXuatRep();

    @Override
    public List<NhaSanXuat> getNhaSanXuat() {
        return nhaSanXuatRep.getNhaSanXuat();
    }

    @Override
    public NhaSanXuat getByMaNSX(String maNSX) {
        return nhaSanXuatRep.getByMa(maNSX);
    }    
    
}
