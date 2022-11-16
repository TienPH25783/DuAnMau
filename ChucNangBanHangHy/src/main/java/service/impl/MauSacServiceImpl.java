/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.MauSac;
import repository.MauSacRep;
import service.MauSacService;

/**
 *
 * @author Admin
 */
public class MauSacServiceImpl implements MauSacService{

    MauSacRep mauSacRep = new MauSacRep();
    
    @Override
    public List<MauSac> getMauSac() {
        return mauSacRep.getMauSac();
    }

    @Override
    public MauSac getByMaMauSac(String maMauSac) {
        return mauSacRep.getByMa(maMauSac);
    }
    
}
