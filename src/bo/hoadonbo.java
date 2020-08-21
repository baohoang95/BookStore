package bo;

import java.util.ArrayList;

import bean.hoadonbean;
import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao = new hoadondao();

	public ArrayList<hoadonbean> gethoadon() throws Exception {
		return hddao.gethoadon();
	}

	public void xacnhan(String mahoadon) throws Exception {
		hddao.xacnhan(mahoadon);
	}

	public ArrayList<hoadonbean> gethoadon(String makh) throws Exception {
		return hddao.gethoadon(makh);
	}

	public int Them(String makh) throws Exception {
		return hddao.Them(makh);
	}

}
