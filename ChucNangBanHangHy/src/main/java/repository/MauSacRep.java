/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.Query;
import model.MauSac;
import org.hibernate.Session;
import utilities.HybernateUtil;

/**
 *
 * @author Admin
 */
public class MauSacRep {
    
    Session session = HybernateUtil.getFACTORY().openSession();
    
    public List<MauSac> getMauSac() {
        Query q = session.createQuery(" From MauSac"
                + " Order by maMauSac");
        List<MauSac> list = q.getResultList();
        return list;
    }
    
    public MauSac getByMa(String maMS){
        Query q = session.createQuery(" From MauSac"
                + " Where maMauSac = :maMauSac");
        q.setParameter("maMauSac", maMS);
        MauSac ms = (MauSac) q.getSingleResult();
        return ms;
    }
    
}
