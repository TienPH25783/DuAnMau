/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;
import ViewModels.QLMauSac;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IQLMauSacService {
    List<QLMauSac> getAll();
    
    void insert(QLMauSac qLMauSac);
    
    void update( QLMauSac qLMauSac, UUID id);
    
    UUID delete(UUID id);
    
}
