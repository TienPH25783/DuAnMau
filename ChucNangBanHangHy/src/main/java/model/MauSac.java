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
@Table(name = "MauSac")
public class MauSac implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;
    
    @Column(name = "Ma", unique = true)
    private String maMauSac;
    
    @Column(name = "Ten")
    private String tenMauSac;

    @OneToMany(mappedBy = "mauSac", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> listCTSP;
    
    public MauSac() {
    }

    public MauSac(String maMauSac, String tenMauSac) {
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    @Override
    public String toString() {
        return "MauSac{" + "id=" + id + ", maMauSac=" + maMauSac + ", tenMauSac=" + tenMauSac + '}';
    }
    
}
