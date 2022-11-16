/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.Query;
import model.DongSanPham;
import org.hibernate.Session;
import utilities.HybernateUtil;

/**
 *
 * @author Admin
 */
public class DongSanPhamRep {

    Session session = HybernateUtil.getFACTORY().openSession();

    public List<DongSanPham> getDongSanPham() {
        Query q = session.createQuery(" From DongSanPham"
                + " Order by maDongSP");
        List<DongSanPham> list = q.getResultList();
        return list;
    }

    public DongSanPham getByMa(String maDongSP) {
        Query q = session.createQuery(" From DongSanPham"
                + " Where maDongSP = :maDongSP");
        q.setParameter("maDongSP", maDongSP);
        DongSanPham dsp = (DongSanPham) q.getSingleResult();
        return dsp;
    }

}
