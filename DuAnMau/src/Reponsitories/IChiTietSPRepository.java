/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import java.util.List;
import DomainModels.ChiTietSP;
import java.util.UUID;

/**
 *
 * @author ongbi
 */
public interface IChiTietSPRepository {

    List<ChiTietSP> getAll();

    boolean insert(ChiTietSP chiTietSP);

    boolean update(UUID id, ChiTietSP chiTietSP);

    UUID delete(UUID id);
}
