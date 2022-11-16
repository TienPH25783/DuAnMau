/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import ViewModels.QLMauSac;
import java.util.List;
import java.util.UUID;
import Reponsitories.MauSacRepository;
import Reponsitories.IMauSacRepository;
import java.util.ArrayList;
/**
 *
 * @author ongbi
 */
public class QLMauSacService implements IQLMauSacService{
     private final  IMauSacRepository iMauSacRepository;
     private List<QLMauSac> listMS;
    public QLMauSacService() {
        iMauSacRepository = new MauSacRepository();
        listMS = new ArrayList<>();
    }
     
    @Override
    public List<QLMauSac> getAll() {
    listMS = new ArrayList<>();
    var QlmauSac = this.iMauSacRepository.getAll();
        
        for (MauSac mauSac : QlmauSac) {
            listMS.add(new QLMauSac(mauSac.getId(), mauSac.getMa(), mauSac.getTen()));
        }
    return listMS;
        
    }

    @Override
    public void insert(QLMauSac qLMauSac) {
         MauSac mauSac = new MauSac(qLMauSac.getId(), qLMauSac.getMa(), qLMauSac.getTen());
         this.iMauSacRepository.insert(mauSac);
    }

    @Override
    public void update(QLMauSac qLMauSac, UUID id) {
         MauSac mauSac = new MauSac(qLMauSac.getId(), qLMauSac.getMa(), qLMauSac.getTen());
         this.iMauSacRepository.update(id, mauSac);
    }

    @Override
    public UUID delete(UUID id) {
        this.iMauSacRepository.delete(id);
         return id;
    }
    
}
