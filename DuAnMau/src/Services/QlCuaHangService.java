/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Reponsitories.CuaHangRepository;
import Reponsitories.ICuaHangRepositorys;
import ViewModels.QLCuaHang;
import DomainModels.CuaHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public class QlCuaHangService implements IQlCuaHangService {

    private final ICuaHangRepositorys iCuaHangRepositorys;
    private List<QLCuaHang> qlchs;

    public QlCuaHangService() {
        this.iCuaHangRepositorys = new CuaHangRepository();
        qlchs = new ArrayList<>();
    }

    @Override
    public List<QLCuaHang> getAll() {
        this.qlchs = new ArrayList<>();
        var QLCH = iCuaHangRepositorys.getAll();
        for (CuaHang cuaHang : QLCH) {
            qlchs.add(new QLCuaHang(cuaHang.getId(), cuaHang.getMa(), cuaHang.getTen(), cuaHang.getDiaChi(), cuaHang.getThanhPho(), cuaHang.getQuocGia()));
        }
        return qlchs;
    }

    @Override
    public void insert(QLCuaHang qLCuaHang) {
        CuaHang qlch = new CuaHang(qLCuaHang.getId(), qLCuaHang.getMa(), qLCuaHang.getTen(), qLCuaHang.getDiaChi(), qLCuaHang.getThanhPho(), qLCuaHang.getQuocGia());
        iCuaHangRepositorys.insert(qlch);
    }

    @Override
    public void update(QLCuaHang qLCuaHang, UUID id) {
        CuaHang qlch = new CuaHang(qLCuaHang.getId(), qLCuaHang.getMa(), qLCuaHang.getTen(), qLCuaHang.getDiaChi(), qLCuaHang.getThanhPho(), qLCuaHang.getQuocGia());
        iCuaHangRepositorys.update(id, qlch);
    }

    @Override
    public UUID delete(UUID id) {
        return iCuaHangRepositorys.delete(id);
    }

}
