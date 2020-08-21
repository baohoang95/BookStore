package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();

	public void Them(String masach, String tensach, String anh, long soluong, long gia) {
		for (giohangbean g : ds) {
			if (g.getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				long sl = g.getSoluong() + soluong;
				g.setSoluong(sl);
				g.setThanhtien(sl*g.getGia());
				return;
			}
		}
		ds.add(new giohangbean(masach, tensach, anh, soluong, gia));
	}

	public long TongTien() {
		long s = 0;
		for (giohangbean g : ds) {
			s+=g.getThanhtien();
		}
		return s;
	}

	public long TongSoLuong() {
		long s = 0;
		for (giohangbean g : ds) {
			s +=g.getSoluong();
		}
		return s;
	}

	public void Xoa(String ms) {
		for (giohangbean g : ds)
			if (g.getMasach().toLowerCase().trim().equals(ms.toLowerCase().trim())) {
				ds.remove(g);
				return;
			}
	}

	public void XoaTatCa() {
		ds.clear();
	}

	public void CapNhat(String masach, long soluong) {
		for (giohangbean g : ds) {
			if (g.getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				g.setSoluong(soluong);
				return;
			}
		}
	}
}
