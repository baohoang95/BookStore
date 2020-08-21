package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	dungchung dc = new dungchung();

	public boolean KtMa(String maloai) throws Exception {
		// Kiem tra xem co maloai nay trong bang loai hay ko?
		// Tao cau lenh sql
		// Tao cau lenh
		// Truyen tham so
		// Cho thuc hien cau lenh
		// Neu lay ve duoc 1 dong thi return true
		// Nguoc lai return false
		// nen select maloai thay vi select *-->chay nhanh hon
		String sql = "select maloai from loai where maloai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		boolean kq = rs.next();
		rs.close();
		return kq;
	}

	public int Them(String maloai, String tenloai) throws Exception {
		// Neu trung ma thi thoat
		// Nguoc lai thi them vao 1 loai
		// B1: ket noi
		// B2: thiet lap cau lenh sql
		// B3: tao cau lenh
		// B4:truyen tham so vao cau lenh
		// B5: chay cau lenh
		// B6: Dong cau lenh
		dc.KetNoi();
		if (KtMa(maloai))
			return 0;
		String sql = "insert into loai(maloai,tenloai) values(?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}

	public int Sua(String maloai, String tenloaimoi) throws Exception {
		dc.KetNoi();
		String sql = "update loai set tenloai=? where maloai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tenloaimoi);
		cmd.setString(2, maloai);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}

	public boolean KtLoaiSach(String maloai) throws Exception {
		// Kiem tra xem maloai nay co sach hay ko
		// Co: true, nguoc lai tra ve false
		String sql = "select maloai from sach where maloai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		boolean kq = rs.next();
		rs.close();
		return kq;
	}

	public int Xoa(String maloai) throws Exception {
		dc.KetNoi();
		if (KtLoaiSach(maloai))
			return 0;
		String sql = "delete from loai where maloai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}

	public loaibean TimMaLoai(String maloai) throws Exception {
		// b1: Ket noi vao csdl
		dc.KetNoi();
		// b2: Lay du lieu ve
		String sql = "select * from loai where maloai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		loaibean l = null;
		if (rs.next()) {
			String ml = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			l = new loaibean(ml, tenloai);
		}
		// b3: Dong ket noi
		rs.close();
		dc.cn.close();
		return l;
	}

	public ArrayList<loaibean> getsach() throws Exception {
		ArrayList<loaibean> ds = new ArrayList<loaibean>();
		// b1: Ket noi vao csdl
		dc.KetNoi();
		// b2: Lay du lieu ve
		String sql = "select * from loai";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		// Lay du lieu ve
		while (rs.next()) {
			// Duyet qua tap du lieu de luu vao mang ds
			String maloai = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			ds.add(new loaibean(maloai, tenloai));
		}
		// b3: Dong ket noi
		rs.close();
		dc.cn.close();
		return ds;
	}
}
