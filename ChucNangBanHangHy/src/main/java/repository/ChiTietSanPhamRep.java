/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.Query;
import model.ChiTietSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HybernateUtil;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamRep {
    
    Session session = HybernateUtil.getFACTORY().openSession();
    
    public List<ChiTietSanPham> getListCTSP() {
        Query q = session.createQuery("From ChiTietSanPham");
        List<ChiTietSanPham> list = q.getResultList();
        return list;
    }
    
    public ChiTietSanPham getListCTSP(String Id) {
        Query q = session.createQuery("From ChiTietSanPham"
                + " where idCTSP = :idCTSP");
        q.setParameter("idCTSP", Id);
        ChiTietSanPham ctsp = (ChiTietSanPham) q.getSingleResult();
        return ctsp;
    }
 
    public Boolean saveCTSP(ChiTietSanPham ctsp){
        Transaction transaction = null;
        try(Session session = HybernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(ctsp);
            transaction.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean deleteCTSP(ChiTietSanPham ctsp){
        Transaction transaction = null;
        try(Session session = HybernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean updateCTSP(ChiTietSanPham ctsp){
        Transaction transaction = null;
        try(Session session = HybernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(ctsp);
            transaction.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    
}
