
package rmi;

import bean.ChiTietTaiKhoanBean;
import bean.TaiKhoanBean;
import java.rmi.Remote;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ITinhToan extends  Remote{
    public TaiKhoanBean ktDn(String tk, String mk) throws  Exception;
    public TaiKhoanBean VanTinTaiKhoan(String tk) throws  Exception;
    public String rutTien(String soTaiKhoan, long soTienRut) throws  Exception;
    public String chuyenTien(String soTaiKhoanChuyen, long soTienChuyen, String soTaiKhoanNhan) throws Exception;
    public String doiMatKhau(String soTaiKhoan, String matKhauCu, String matKhauMoi) throws Exception;
    public List<ChiTietTaiKhoanBean> lichSuGD(String soTaiKhoan) throws Exception;
}
