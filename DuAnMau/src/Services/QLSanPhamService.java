/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import ViewModels.QLSanPham;
import java.util.List;
import Reponsitories.SanPhamRepository;
import Reponsitories.ISanPhamRepositoty;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public class QLSanPhamService implements IQLSanPhamService {

    private final ISanPhamRepositoty reposiitory;
    public ArrayList<QLSanPham> qlsps;

    public QLSanPhamService() {
        this.reposiitory = new SanPhamRepository();
        this.qlsps = new ArrayList<>();
    }

    @Override
    public ArrayList<QLSanPham> getAll() {
        this.qlsps = new ArrayList<>();
        var sanPham = reposiitory.getAll();
        for (SanPham sp : sanPham) {
            qlsps.add(new QLSanPham(sp.getId(), sp.getMa(), sp.getTen()));
        }
        return qlsps;

    }

    @Override
    public void insert(QLSanPham qlsp) {
        SanPham sanPham = new SanPham(qlsp.getId(), qlsp.getMa(), qlsp.getTen());
        this.reposiitory.insert(sanPham);
    }

    @Override
    public void update( QLSanPham qlsp, UUID id) {
        SanPham sanPham = new SanPham(qlsp.getId(), qlsp.getMa(), qlsp.getTen());
        this.reposiitory.update(sanPham, id);
    }

    @Override
    public UUID delete(UUID id) {
        return reposiitory.delete(id);

    }

}
