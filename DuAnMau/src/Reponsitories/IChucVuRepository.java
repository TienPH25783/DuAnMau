/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import DomainModels.ChucVu;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IChucVuRepository {
    List<ChucVu> getAll();
    
    void insert(ChucVu chucVu);
    
    void update (UUID id, ChucVu chucVu);
    
    UUID delete(UUID id);
}
