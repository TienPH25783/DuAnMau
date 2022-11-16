/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.DongSP;
import ViewModels.QLDongSp;
import Reponsitories.DongSPRepository;
import Reponsitories.IDongSPRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QLDongSPService implements IQLDongSPService {

    private final IDongSPRepository iDongSPRepository;
    private List<QLDongSp> listQLDSP;

    public QLDongSPService() {
        iDongSPRepository = new DongSPRepository();
        this.listQLDSP = new ArrayList<>();
    }

    @Override
    public List<QLDongSp> getAll() {
        this.listQLDSP = new ArrayList<>();
        var QlDongSP = iDongSPRepository.getAll();
        for (DongSP dongSP : QlDongSP) {
            listQLDSP.add(new QLDongSp(dongSP.getId(), dongSP.getMa(), dongSP.getTen()));
        }
        return listQLDSP;
    }

    @Override
    public void insert(QLDongSp qlsp) {
        DongSP dongSP = new DongSP(qlsp.getId(), qlsp.getMa(), qlsp.getTen());
        this.iDongSPRepository.insert(dongSP);
    }

    @Override
    public void update(QLDongSp qlsp, UUID id) {
        DongSP dongSP = new DongSP(qlsp.getId(), qlsp.getMa(), qlsp.getTen());
        this.iDongSPRepository.update(id, dongSP);
    }

    @Override
    public UUID delete(UUID id) {

        return this.iDongSPRepository.delete(id);
    }

}
