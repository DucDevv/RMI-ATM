/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.TaiKhoanBean;
//import static dao.KetNoi.KetNoi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import sun.applet.Main;
import sun.security.krb5.internal.tools.Ktab;

/**
 *
 * @author ADMIN
 */
public class TaiKhoanDao {
    public TaiKhoanBean ktDn(String tk, String mk) throws  Exception{
        
        KetNoi kn = new KetNoi();
        kn.KetNoi();
        String sql = "select * from TaiKhoan where SoTaiKhoan=? and MatKhau=?";
        PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
        cmd.setString(1, tk);
        cmd.setString(2, mk);
        TaiKhoanBean taikhoan =null;
        ResultSet rs = cmd.executeQuery();
        if(rs.next() == true){
             String SoTaiKhoan = rs.getNString("SoTaiKhoan");
            String HoTen = rs.getString("HoTen");
            long SoTien =rs.getLong("SoTien");
            String Matkhau =rs.getString("MatKhau");
            taikhoan = new TaiKhoanBean(SoTaiKhoan, HoTen, SoTien, Matkhau);      
        
        }
        rs.close(); kn.KetNoi();
        return taikhoan;
    }
   
    
    public TaiKhoanBean VanTinTaiKhoan(String soTaiKhoan) throws  Exception{
        String sql = "select * from TaiKhoan where SoTaiKhoan=?";
        PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
        cmd.setString(1, soTaiKhoan);
        TaiKhoanBean taikhoan =null;
        ResultSet rs = cmd.executeQuery();
        if(rs.next() == true){
             String SoTaiKhoan = rs.getNString("SoTaiKhoan");
            String HoTen = rs.getString("HoTen");
            long SoTien =rs.getLong("SoTien");
            String Matkhau =rs.getString("MatKhau");
            taikhoan = new TaiKhoanBean(SoTaiKhoan, HoTen, SoTien, Matkhau);              
        }
        return taikhoan;
    }
    public int chuyenTien(String soTaiKhoanChuyen, long soTienChuyen, String soTaiKhoanNhan) throws Exception{
        rutTien(soTaiKhoanChuyen, soTienChuyen);
        String sql = "update TaiKhoan \n" +
                    "set SoTien = SoTien + ?\n" +
                    "where SoTaiKhoan =?";
        PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
        cmd.setLong(1, soTienChuyen);
        cmd.setString(2, soTaiKhoanNhan);
        return cmd.executeUpdate();
    }
    public int doiMatKhau(String soTaiKhoan, String matKhauCu, String matKhauMoi) throws Exception{
        
        String sql = "update TaiKhoan \n" +
                    "set MatKhau =?\n" +
                    "where SoTaiKhoan =? and MatKhau=?";
        PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
        cmd.setString(1, matKhauMoi);
        cmd.setString(2, soTaiKhoan);
        cmd.setString(3, matKhauCu);
        
        return cmd.executeUpdate();
        
        
    }
   public int rutTien(String soTaiKhoan, long soTienRut) throws  Exception{
       String sql = "update TaiKhoan \n" +
                    "set SoTien =SoTien - ?\n" +
                    "where SoTaiKhoan =?";
        PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
        cmd.setLong(1, soTienRut);
        cmd.setString(2, soTaiKhoan);
              
        return cmd.executeUpdate();
        
   }
   public static void main(String[] args){
        try {
//            TaiKhoanDao tkDao = new TaiKhoanDao();
//            if(tkDao.ktDn("111111", "100720") == null){
//                System.out.println("tk ko đúng");
//            }else{
//                System.out.println("Ok");
//            }
           
        } catch (Exception e) {
        }
    }
}
