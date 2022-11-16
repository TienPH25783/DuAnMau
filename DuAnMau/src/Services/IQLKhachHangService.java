/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLKhachHang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IQLKhachHangService {
     List<QLKhachHang> getAll();

    String insert(QLKhachHang qlkh);

    String update(QLKhachHang qlkh, UUID id);

    String delete(UUID id);
}
