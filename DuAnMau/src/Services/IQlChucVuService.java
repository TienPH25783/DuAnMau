/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLChucVu;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IQlChucVuService {
     List<QLChucVu> getAll();
    
    void insert(QLChucVu qlcv);
    
    void update( QLChucVu qlcv, UUID id);
    
    UUID delete(UUID id);
}
