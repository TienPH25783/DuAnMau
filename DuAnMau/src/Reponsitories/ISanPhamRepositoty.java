/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import DomainModels.SanPham;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ISanPhamRepositoty {

    ArrayList<SanPham> getAll();

    void insert(SanPham sanPham);

    void update(SanPham sanPham, UUID id);

    UUID delete(UUID id);

}
