/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
//Serializable
public class TaiKhoanBean implements Serializable{
    private String SoTaiKhoan;
    private String HoTen;
    private long SoTien;
    private String Matkhau;

    public TaiKhoanBean(String SoTaiKhoan, String HoTen, long SoTien, String Matkhau) {
        this.SoTaiKhoan = SoTaiKhoan;
        this.HoTen = HoTen;
        this.SoTien = SoTien;
        this.Matkhau = Matkhau;
    }

    public TaiKhoanBean() {
    }
    
    public String getSoTaiKhoan() {
        return SoTaiKhoan;
    }

    public String getHoTen() {
        return HoTen;
    }

    public long getSoTien() {
        return SoTien;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setSoTaiKhoan(String SoTaiKhoan) {
        this.SoTaiKhoan = SoTaiKhoan;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setSoTien(long SoTien) {
        this.SoTien = SoTien;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    @Override
    public String toString() {
        return "TaiKhoanBean{" + "SoTaiKhoan=" + SoTaiKhoan + ", HoTen=" + HoTen + ", SoTien=" + SoTien + ", Matkhau=" + Matkhau + '}';
    }
    
    
}
