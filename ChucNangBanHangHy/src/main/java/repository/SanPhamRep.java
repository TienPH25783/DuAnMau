/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.Query;
import model.SanPham;
import org.hibernate.Session;
import utilities.HybernateUtil;

/**
 *
 * @author Admin
 */
public class SanPhamRep {

    Session session = HybernateUtil.getFACTORY().openSession();

    public List<SanPham> getSanPham() {
        Query q = session.createQuery("From SanPham"
                + " Order by maSP");
        List<SanPham> list = q.getResultList();
        return list;
    }

    public SanPham getByMa(String maSP) {
        Query q = session.createQuery("From SanPham"
                + " Where maSP = :maSP");
        q.setParameter("maSP", maSP);
        SanPham sp = (SanPham) q.getSingleResult();
        return sp;
    }

}
