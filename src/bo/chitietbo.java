package bo;

import java.util.ArrayList;

import bean.chitietbean;
import dao.chitietdao;

public class chitietbo {
	chitietdao ctdao = new chitietdao();
//
//	public ArrayList<chitietbean> getchitiet() throws Exception {
//		return ctdao.getchitiet();
//	}

	public ArrayList<chitietbean> getchitiet(int mahoadon) throws Exception {
		return ctdao.getchitiet(mahoadon);
	}

	public void Them(int mahoadon, giohangbo gh) throws Exception {
		ctdao.Them(mahoadon, gh);
	}
}
