/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;
import ViewModels.QLDongSp;
import java.util.List;
import java.util.UUID;

public interface IQLDongSPService {
     List<QLDongSp> getAll();
    
    void insert(QLDongSp qlsp);
    
    void update( QLDongSp qlsp, UUID id);
    
    UUID delete(UUID id);
}
