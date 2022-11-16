/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import java.util.List;
import DomainModels.NSX;
import java.util.UUID;
/**
 *
 * @author ongbi
 */
public interface INSXRepository {
    List<NSX> getAll();
    void insert(NSX nsx);
    void update(UUID id, NSX nsx);
    UUID delete(UUID id);
   
}
