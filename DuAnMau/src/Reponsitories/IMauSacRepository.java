/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import java.util.List;
import DomainModels.MauSac;
import java.util.UUID;
/**
 *
 * @author ongbi
 */
public interface IMauSacRepository {
    List<MauSac> getAll();
    
    void insert(MauSac mauSac);
    
    void update( UUID id, MauSac mauSac);
    
    UUID delete(UUID id);
}
