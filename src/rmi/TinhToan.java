/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import bean.ChiTietTaiKhoanBean;
import bean.TaiKhoanBean;
import dao.ChiTietTaiKhoanDao;
import dao.TaiKhoanDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TinhToan extends UnicastRemoteObject implements ITinhToan{
    public  TinhToan() throws RemoteException{};
    TaiKhoanDao tkDao = new TaiKhoanDao();
    ChiTietTaiKhoanDao cttkDao = new ChiTietTaiKhoanDao();
    @Override
    public TaiKhoanBean ktDn(String tk, String mk) throws Exception {
        
       TaiKhoanBean taikhoan = tkDao.ktDn(tk, mk);
       return taikhoan;
    }

    @Override
    public String rutTien(String soTaiKhoan, long soTienRut) throws Exception {
        if(soTienRut < 50000)
            return "Số tiền rút > 50.000đ" ;
        else if(soTienRut%50000 != 0)
            return "Số tiền rút phải là bội của 50.0000đ " ;
        else if(VanTinTaiKhoan(soTaiKhoan).getSoTien() < soTienRut )
            return "Số tiền rút phải nhỏ hơn số dư";
        else{
            tkDao.rutTien(soTaiKhoan, soTienRut);
            cttkDao.them(new java.util.Date(), -soTienRut, soTaiKhoan,"rút oke" );
            return "Bạn đã rút thành công:"+ soTienRut;
        }                       
    }

    @Override
    public String chuyenTien(String soTaiKhoanChuyen, long soTienChuyen, String soTaiKhoanNhan) throws Exception {
        if(tkDao.VanTinTaiKhoan(soTaiKhoanNhan) == null || soTaiKhoanChuyen.equals(soTaiKhoanNhan)){
            return "Số tài khoản người nhận không hợp lệ!";
        }else if(soTienChuyen > tkDao.VanTinTaiKhoan(soTaiKhoanChuyen).getSoTien()){
            return "Số tiền chuyển phải nhỏ hơn số dư!";
        }else{
            tkDao.chuyenTien(soTaiKhoanChuyen, soTienChuyen, soTaiKhoanNhan);
            cttkDao.them(new java.util.Date(), -soTienChuyen, soTaiKhoanChuyen, 
                    "Bạn đã chuyển cho STK: "+ soTaiKhoanNhan +" số tiền: "+soTienChuyen +"đ");
            cttkDao.them(new java.util.Date(), soTienChuyen, soTaiKhoanNhan, 
                    "Bạn đã nhận được từ STK: "+soTaiKhoanChuyen +" số tiền là: "+soTienChuyen +"đ");
            return "Bạn đã chuyển tiền thành công";
            
        }
    }

    @Override
    public String doiMatKhau(String soTaiKhoan, String matKhauCu, String matKhauMoi) throws Exception {
        if(matKhauCu.equals(matKhauMoi))
            return "mật khẩu mới không được trùng với mật khẩu củ";
        else if( tkDao.doiMatKhau(soTaiKhoan, matKhauCu, matKhauMoi) == 0){
            return "Mật khẩu củ không đúng!";
        }else{
            return "Bạn đã đổi mật khẩu thành công";
        }
    }

    @Override
    public TaiKhoanBean VanTinTaiKhoan(String tk) throws Exception {
        return tkDao.VanTinTaiKhoan(tk);
    }

    @Override
    public List<ChiTietTaiKhoanBean> lichSuGD(String soTaiKhoan) throws Exception {
        return cttkDao.lichSuGD(soTaiKhoan);
    }
//     public static void main(String[] args) {
//         try {
//             TinhToan t = new TinhToan();
//             for(ChiTietTaiKhoanBean ctt: t.lichSuGD("111111"))
//                 System.out.println(ctt.toString());
//         } catch (Exception e) {
//         }
//     }
    
}
