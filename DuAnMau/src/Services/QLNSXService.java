/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import DomainModels.NSX;
import ViewModels.QLNSX;
import java.util.List;
import java.util.UUID;
import Reponsitories.INSXRepository;
import Reponsitories.NSXRepository;
import java.util.ArrayList;

/**
 *
 * @author ongbi
 */
public class QLNSXService implements IQLNSXService{
    private final INSXRepository iNSXRepository;
    private List<QLNSX> listNSX;
    public QLNSXService() {
        iNSXRepository = new NSXRepository();
        listNSX = new ArrayList<>();
    }

    @Override
    public List<QLNSX> getAll() {
        listNSX = new ArrayList<>();
        var QlNSX = this.iNSXRepository.getAll();
        
        for (NSX nsx : QlNSX) {
            listNSX.add(new QLNSX(nsx.getId(), nsx.getMa(), nsx.getTen()));
        }
    return listNSX;
    }

    @Override
    public void insert(QLNSX qlnsx) {
  NSX nsx = new NSX(qlnsx.getId(), qlnsx.getMa(), qlnsx.getTen());
         this.iNSXRepository.insert(nsx);    }

    @Override
    public void update(QLNSX qlnsx, UUID id) {
  NSX nsx = new NSX(qlnsx.getId(), qlnsx.getMa(), qlnsx.getTen());
  this.iNSXRepository.update(id, nsx);
    }

    @Override
    public UUID delete(UUID id) {
        this.iNSXRepository.delete(id);
        return id;
    }
    
}
