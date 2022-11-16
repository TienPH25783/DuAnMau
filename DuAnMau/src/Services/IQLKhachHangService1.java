/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLKhacHang1;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IQLKhachHangService1 {
    List<QLKhacHang1> getAll();
    
    void insert(QLKhacHang1 khacHang1);
    
    void update(QLKhacHang1 khacHang1, String Ma);
    
    String delete(String Ma);
}
