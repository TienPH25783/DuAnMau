/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.Query;
import model.NhaSanXuat;
import org.hibernate.Session;
import utilities.HybernateUtil;

/**
 *
 * @author Admin
 */
public class NhaSanXuatRep {

    Session session = HybernateUtil.getFACTORY().openSession();

    public List<NhaSanXuat> getNhaSanXuat() {
        Query q = session.createQuery(" From NhaSanXuat"
                + " Order by maNSX");
        List<NhaSanXuat> list = q.getResultList();
        return list;
    }

    public NhaSanXuat getByMa(String maNSX) {
        Query q = session.createQuery(" From NhaSanXuat"
                + " Where maNSX = :maNSX");
        q.setParameter("maNSX", maNSX);
        NhaSanXuat nsx = (NhaSanXuat) q.getSingleResult();
        return nsx;
    }

}
