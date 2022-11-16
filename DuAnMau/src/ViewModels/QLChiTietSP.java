/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;




import java.util.UUID;

/**
 *
 * @author ongbi
 */
public class QLChiTietSP {

    private UUID id;
    private QLSanPham idSP;
    private QLNSX idNSX;
    private QLMauSac idMauSac;
    private QLDongSp idDongSP;
    private int namBh;
    private String MoTa;
    private int SoLuongTon;
    private double GiaNhap;
    private double GiaBan;


    public QLChiTietSP() {
    }

    public QLChiTietSP(UUID id) {
        this.id = id;
    }

    public QLChiTietSP(UUID id, QLSanPham idSP, QLNSX idNSX, QLMauSac idMauSac, QLDongSp idDongSP, int namBh, String MoTa, int SoLuongTon, double GiaNhap, double GiaBan) {
        this.id = id;
        this.idSP = idSP;
        this.idNSX = idNSX;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.namBh = namBh;
        this.MoTa = MoTa;
        this.SoLuongTon = SoLuongTon;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
    }

    public QLChiTietSP(QLSanPham idSP, QLNSX idNSX, QLMauSac idMauSac, QLDongSp idDongSP, int namBh, String MoTa, int SoLuongTon, double GiaNhap, double GiaBan) {
        this.idSP = idSP;
        this.idNSX = idNSX;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.namBh = namBh;
        this.MoTa = MoTa;
        this.SoLuongTon = SoLuongTon;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public QLSanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(QLSanPham idSP) {
        this.idSP = idSP;
    }

    public QLNSX getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(QLNSX idNSX) {
        this.idNSX = idNSX;
    }

    public QLMauSac getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(QLMauSac idMauSac) {
        this.idMauSac = idMauSac;
    }

    public QLDongSp getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(QLDongSp idDongSP) {
        this.idDongSP = idDongSP;
    }

    public int getNamBh() {
        return namBh;
    }

    public void setNamBh(int namBh) {
        this.namBh = namBh;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

   
  
    


    
   
}
