/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ChiTietTaiKhoanBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChiTietTaiKhoanDao {
    public int them(Date ngayRutTien, long soTienRutRa,String soTaiKhoan,String ghiChu )throws  Exception{
        KetNoi kn= new KetNoi();
        kn.KetNoi();
        String sql = "insert into ChiTietTaiKhoan(NgayRutTien,SoTienRutRa,SoTaiKhoan,GhiChu)\n" +
"		values(?,?,?,?);";
        PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
//        SimpleDateFormat f= new SimpleDateFormat("yyyy/MM/dd");
//       String ngay=  f.format(ngayRutTien);
        cmd.setDate(1, new java.sql.Date(ngayRutTien.getTime()));       
        cmd.setLong(2, soTienRutRa);
        cmd.setString(3,soTaiKhoan );
        cmd.setString(4,ghiChu );
        ResultSet rs = cmd.executeQuery();
        return cmd.executeUpdate();
    }
    public ArrayList<ChiTietTaiKhoanBean> lichSuGD(String soTaiKhoan) throws  Exception{
        KetNoi kn= new KetNoi();
        kn.KetNoi();
        List<ChiTietTaiKhoanBean> result = new ArrayList<ChiTietTaiKhoanBean>();
        String sql = "select * from ChiTietTaiKhoan where SoTaiKhoan = ?"
                + " order by ChiTietTaiKhoan.id desc";
        PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
//        SimpleDateFormat f= new SimpleDateFormat("yyyy/MM/dd");
//       String ngay=  f.format(ngayRutTien);
        cmd.setString(1, soTaiKhoan );
        ResultSet rs = cmd.executeQuery();
        ArrayList<ChiTietTaiKhoanBean> ds = new ArrayList<ChiTietTaiKhoanBean>();
        while(rs.next()){
            long Id = rs.getLong("Id");
            Date NgayRutTien = rs.getDate("NgayRutTien");
            String SoTaiKhoan = rs.getString("SoTaiKhoan");
            String GhiChu = rs.getString("GhiChu");
            long SoTienRutRa = rs.getLong("SoTienRutRa");
            result.add( new ChiTietTaiKhoanBean(Id, NgayRutTien, SoTienRutRa, SoTaiKhoan, GhiChu));
        }
        rs.close();KetNoi.cn.close();
        return ds;
    }
    
}
