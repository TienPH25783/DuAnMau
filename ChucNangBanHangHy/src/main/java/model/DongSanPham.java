/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "DongSP")
public class DongSanPham implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String idDongSP;
    
    @Column(name = "Ma", unique = true)
    private String maDongSP;
    
    @Column(name = "Ten")
    private String tenDongSP;

    @OneToMany(mappedBy = "dongSanPham", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> listCTSP;
    
    public DongSanPham() {
    }

    public DongSanPham(String maDongSP, String tenDongSP) {
        this.maDongSP = maDongSP;
        this.tenDongSP = tenDongSP;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public String getMaDongSP() {
        return maDongSP;
    }

    public void setMaDongSP(String maDongSP) {
        this.maDongSP = maDongSP;
    }

    public String getTenDongSP() {
        return tenDongSP;
    }

    public void setTenDongSP(String tenDongSP) {
        this.tenDongSP = tenDongSP;
    }

    @Override
    public String toString() {
        return "DongSanPham{" + "idDongSP=" + idDongSP + ", maDongSP=" + maDongSP + ", tenDongSP=" + tenDongSP + '}';
    }
    
}
