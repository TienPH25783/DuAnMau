/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;
import ViewModels.QLNSX;
import java.util.List;
import java.util.UUID;
/**
 *
 * @author ongbi
 */
public interface IQLNSXService {
     List<QLNSX> getAll();
    
    void insert(QLNSX qlnsx);
    
    void update( QLNSX qlnsx, UUID id);
    
    UUID delete(UUID id);
}
