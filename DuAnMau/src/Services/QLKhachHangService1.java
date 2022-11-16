/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KhachHang1;
import ViewModels.QLKhacHang1;
import java.util.List;
import java.util.UUID;
import Reponsitories.KhachHang1Repositon;
import Reponsitories.IKhachHang1Repository;
import java.util.ArrayList;
/**
 *
 * @author ongbi
 */
public class QLKhachHangService1 implements IQLKhachHangService1{
    private IKhachHang1Repository hang1Repositoryl;
    private List<QLKhacHang1> lKhacHang1s;
    public QLKhachHangService1() {
        hang1Repositoryl = new KhachHang1Repositon();
        lKhacHang1s = new ArrayList<>();
    }
    

    @Override
    public List<QLKhacHang1> getAll() {
      lKhacHang1s = new ArrayList<>();
      var x = hang1Repositoryl.getAll();
        for (KhachHang1 khachHang1 : x) {
            lKhacHang1s.add(new QLKhacHang1(khachHang1.getId(), khachHang1.getMa(), khachHang1.getTen(), khachHang1.getTenDem(), khachHang1.getHo(), khachHang1.getDiaChi()));
        }
        return lKhacHang1s;
      
    }

    @Override
    public void insert(QLKhacHang1 khacHang1) {
       KhachHang1 kh = new KhachHang1(khacHang1.getMa(), khacHang1.getTen(), khacHang1.getTenDem(), khacHang1.getHo(), khacHang1.getDiaChi());
       hang1Repositoryl.insert(kh);
    }

    @Override
    public void update(QLKhacHang1 khacHang1, String Ma) {
         KhachHang1 kh = new KhachHang1(khacHang1.getMa(), khacHang1.getTen(), khacHang1.getTenDem(), khacHang1.getHo(), khacHang1.getDiaChi());
       hang1Repositoryl.update(kh, Ma);
    }

    @Override
    public String delete(String Ma) {
       
         hang1Repositoryl.delete(Ma);
         return Ma;
       
    }
    
}
