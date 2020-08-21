package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khdao = new khachhangdao();
	//kt dang nhap
	public boolean KTDangNhap(String tendn, String pass) throws Exception {
		return khdao.KTDangNhap(tendn, pass);
	}

	public ArrayList<khachhangbean> getloai() throws Exception {
		return khdao.getkhachhang();
	}
	//lay makh
	public khachhangbean timkhachhang(String tendangnhap) throws Exception {
		return khdao.timkhachhang(tendangnhap);
	}
}
