package bo;

import java.util.ArrayList;

import bean.dangnhapbean;
import dao.dangnhapdao;

public class dangnhapbo {
	dangnhapdao dndao = new dangnhapdao();

	public ArrayList<dangnhapbean> getdangnhap() throws Exception {
		return dndao.getdangnhap();
	}

//	public dangnhapbean timtendangnhap(String tendangnhap) throws Exception {
//		return dndao.timtendangnhap(tendangnhap);
//	}

	public boolean KTDangNhap(String TenDangNhap, String MatKhau) throws Exception {
		return dndao.KTDangNhap(TenDangNhap, MatKhau);
	}
}
