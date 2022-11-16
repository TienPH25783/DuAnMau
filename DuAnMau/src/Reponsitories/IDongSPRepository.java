/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import java.util.List;
import DomainModels.DongSP;
import ViewModels.QLDongSp;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IDongSPRepository {

    List<DongSP> getAll();

    void insert(DongSP dongSP);

    void update(UUID id, DongSP dongSP);

    UUID delete(UUID id);

}
