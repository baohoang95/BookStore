package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	sachdao sdao = new sachdao();
	ArrayList<sachbean> ds;

	public ArrayList<sachbean> getsach() throws Exception {
		ds = sdao.getsach();
		return ds;
	}

	public int Them(String masach, String tensach, String tacgia, long gia, String anh, Date ngaynhap, String maloai)
			throws Exception {
		return sdao.Them(masach, tensach, tacgia, gia, anh, ngaynhap, maloai);
	}

	public int Sua(String masach, String tensachmoi, String tacgiamoi, long giamoi, String anhmoi, Date ngaynhapmoi,
			String maloaimoi) throws Exception {
		return sdao.Sua(masach, tensachmoi, tacgiamoi, giamoi, anhmoi, ngaynhapmoi, maloaimoi);
	}

	public int Xoa(String masach) throws Exception {
		return sdao.Xoa(masach);
	}

	public sachbean TimMaSach(String masach) throws Exception {
		return sdao.TimMaSach(masach);
	}

	public ArrayList<sachbean> TimTheoMaLoai(String maloai) throws Exception {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean sach : ds) {
			if (sach.getMaloai().equals(maloai))
				tam.add(sach);
		}
		return tam;
	}

	public ArrayList<sachbean> TimKiem(String key) throws Exception {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean sach : ds) {
			if (sach.getTensach().trim().toLowerCase().contains(key.trim().toLowerCase())
					|| sach.getTacgia().trim().toLowerCase().contains(key.trim().toLowerCase()))
				tam.add(sach);
		}
		return tam;
	}

	public sachbean getonesach(String masach) throws Exception {
		for (sachbean sach : sdao.getsach())
			if (sach.getMasach().equals(masach))
				return sach;
		return null;
	}
}
