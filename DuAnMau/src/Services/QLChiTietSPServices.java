/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ViewModels.QLChiTietSP;
import ViewModels.QLMauSac;
import ViewModels.QLDongSp;
import ViewModels.QLSanPham;
import ViewModels.QLNSX;
import DomainModels.ChiTietSP;
import DomainModels.SanPham;
import DomainModels.NSX;
import DomainModels.DongSP;
import DomainModels.MauSac;
import java.util.List;
import java.util.UUID;
import Reponsitories.ChiTietSPRepositoty;
import Reponsitories.IChiTietSPRepository;

import java.util.ArrayList;

/**
 *
 * @author ongbi
 */
public class QLChiTietSPServices implements IQLChiTietSPService{
   private final IChiTietSPRepository iChiTietSPRepository;
    List<QLChiTietSP> listCT;
    public QLChiTietSPServices() {
        iChiTietSPRepository = new ChiTietSPRepositoty();
        this.listCT = new ArrayList<>();
    }
  
    @Override
    public List<QLChiTietSP> getAll() {
        this.listCT = new ArrayList<>();
        var QlCT = iChiTietSPRepository.getAll();
        for (ChiTietSP chiTietSP : QlCT) {
            QLSanPham idSP = new QLSanPham(chiTietSP.getSanPham().getId());
            QLNSX idNSX = new QLNSX(chiTietSP.getNsx().getId());
            QLMauSac idMauSac = new QLMauSac(chiTietSP.getMauSac().getId());
            QLDongSp idDongSP = new QLDongSp(chiTietSP.getDongSP().getId());
          listCT.add(new QLChiTietSP(chiTietSP.getId(), idSP, idNSX, idMauSac, idDongSP, chiTietSP.getNamBh(), chiTietSP.getMoTa(), chiTietSP.getSoLuongTon(), chiTietSP.getGiaNhap(), chiTietSP.getGiaBan()));
        }  

       return listCT;
    }

    @Override
    public void insert(QLChiTietSP qLChiTietSP) {
        SanPham idSP = new SanPham(qLChiTietSP.getIdSP().getId());
        NSX idNSX = new NSX(qLChiTietSP.getIdNSX().getId());
        MauSac idMauSac = new MauSac(qLChiTietSP.getIdMauSac().getId());
        DongSP idDongSP = new DongSP(qLChiTietSP.getIdDongSP().getId());
        ChiTietSP chiTietSP = new ChiTietSP( idSP,  idNSX, idMauSac,idDongSP, qLChiTietSP.getNamBh(), qLChiTietSP.getMoTa(), qLChiTietSP.getSoLuongTon(), qLChiTietSP.getGiaNhap(), qLChiTietSP.getGiaBan());
        this.iChiTietSPRepository.insert(chiTietSP);
        
        
    }   

    @Override
    public void update(UUID id, QLChiTietSP qLChiTietSP) {
        SanPham idSP = new SanPham(qLChiTietSP.getIdSP().getId());
        NSX idNSX = new NSX(qLChiTietSP.getIdNSX().getId());
        MauSac idMauSac = new MauSac(qLChiTietSP.getIdMauSac().getId());
        DongSP idDongSP = new DongSP(qLChiTietSP.getIdDongSP().getId());
        ChiTietSP chiTietSP = new ChiTietSP( idSP,  idNSX, idMauSac,idDongSP,qLChiTietSP.getNamBh(), qLChiTietSP.getMoTa(), qLChiTietSP.getSoLuongTon(), qLChiTietSP.getGiaNhap(), qLChiTietSP.getGiaBan());
        this.iChiTietSPRepository.update(id , chiTietSP);
    }

    @Override
    public UUID delete(UUID id) {
        
     this.iChiTietSPRepository.delete(id);
       return id;
    }
    
}
