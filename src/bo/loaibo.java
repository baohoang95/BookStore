package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();

	public ArrayList<loaibean> getloai() throws Exception {
		return ldao.getsach();
	}
	public int Them(String maloai, String tenloai) throws Exception {
		return ldao.Them(maloai, tenloai);
	}
	public int Sua(String maloai, String tenloaimoi) throws Exception {
		return ldao.Sua(maloai, tenloaimoi);
	}
	public int Xoa(String maloai) throws Exception {
		return ldao.Xoa(maloai);
	}
	public loaibean TimMaLoai(String maloai) throws Exception {
		return ldao.TimMaLoai(maloai);
	}
}
