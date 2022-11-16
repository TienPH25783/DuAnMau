/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import java.util.List;
import ViewModels.QLSanPham;
import java.util.ArrayList;
import java.util.UUID;

public interface IQLSanPhamService {
    ArrayList<QLSanPham> getAll();
    
    void insert(QLSanPham qlsp);
    
    void update( QLSanPham qlsp, UUID id);
    
    UUID delete(UUID id);
    
    
}
