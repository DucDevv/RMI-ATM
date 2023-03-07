/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
//Serializable kkhia báo để client hiểu được kiểu bên server gửi về
public class ChiTietTaiKhoanBean implements Serializable{
    private long Id;
    private Date NgayRutTien;
    private Long SoTienRutRa;
    private String SoTaiKhoan;
    private String GhiChu;

    public ChiTietTaiKhoanBean() {
    }

    public ChiTietTaiKhoanBean(long Id, Date NgayRutTien, Long SoTienRutRa, String SoTaiKhoan, String GhiChu) {
        this.Id = Id;
        this.NgayRutTien = NgayRutTien;
        this.SoTienRutRa = SoTienRutRa;
        this.SoTaiKhoan = SoTaiKhoan;
        this.GhiChu = GhiChu;
    }

    public long getId() {
        return Id;
    }

    public Date getNgayRutTien() {
        return NgayRutTien;
    }

    public Long getSoTienRutRa() {
        return SoTienRutRa;
    }

    public String getSoTaiKhoan() {
        return SoTaiKhoan;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public void setNgayRutTien(Date NgayRutTien) {
        this.NgayRutTien = NgayRutTien;
    }

    public void setSoTienRutRa(Long SoTienRutRa) {
        this.SoTienRutRa = SoTienRutRa;
    }

    public void setSoTaiKhoan(String SoTaiKhoan) {
        this.SoTaiKhoan = SoTaiKhoan;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    @Override
    public String toString() {
        return "ChiTietTaiKhoanBean{" + "Id=" + Id + ", NgayRutTien=" + NgayRutTien + ", SoTienRutRa=" + SoTienRutRa + ", SoTaiKhoan=" + SoTaiKhoan + ", GhiChu=" + GhiChu + '}';
    }

   
}
