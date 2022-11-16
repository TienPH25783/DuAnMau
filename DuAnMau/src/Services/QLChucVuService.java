/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Reponsitories.ChucVuRepository;
import Reponsitories.IChucVuRepository;
import ViewModels.QLChucVu;
import DomainModels.ChucVu;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public class QLChucVuService implements IQlChucVuService{
    private final IChucVuRepository iChucVuRepository;
    private List<QLChucVu> ListQLCV;
    public QLChucVuService() {
        iChucVuRepository = new ChucVuRepository();
        ListQLCV = new ArrayList<>();
        
    }

    @Override
    public List<QLChucVu> getAll() {
           this.ListQLCV = new ArrayList<>();
        var QLChucVu = iChucVuRepository.getAll();
        for (ChucVu chucVu : QLChucVu) {
            ListQLCV.add(new QLChucVu(chucVu.getId(), chucVu.getMa(), chucVu.getTen()));
        }
        return ListQLCV;
    }

    @Override
    public void insert(QLChucVu qlcv) {
        ChucVu chucVu = new ChucVu(qlcv.getId(), qlcv.getMa(), qlcv.getTen());
        iChucVuRepository.insert(chucVu);
    }

    @Override
    public void update(QLChucVu qlcv, UUID id) {
          ChucVu chucVu = new ChucVu(qlcv.getId(), qlcv.getMa(), qlcv.getTen());
        iChucVuRepository.update(id, chucVu);
    }

    @Override
    public UUID delete(UUID id) {
      return iChucVuRepository.delete(id);
    }
    
}
