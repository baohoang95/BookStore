package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.sachbean;

public class sachdao {
	dungchung dc = new dungchung();

	public ArrayList<sachbean> getsach() throws Exception {
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		// b1: Ket noi vao csdl
		dc.KetNoi();
		// b2: Lay du lieu ve
		String sql = "select * from sach";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		// Lay du lieu ve
		while (rs.next()) {
			// Duyet qua tap du lieu de luu vao mang ds
			String masach = rs.getString("masach");
			String tensach = rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			long gia = rs.getLong("gia");
			String anh = rs.getString("anh");
			Date ngaynhap = rs.getDate("ngaynhap");
			String maloai = rs.getString("maloai");
			ds.add(new sachbean(masach, tensach, tacgia, gia, anh, ngaynhap, maloai));
		}
		// b3: Dong ket noi
		rs.close();
		dc.cn.close();
		return ds;
	}

	public boolean KTMaSach(String masach) throws Exception {
		String sql = "select masach from sach where masach=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		ResultSet rs = cmd.executeQuery();
		boolean kq = rs.next();
		rs.close();
		return kq;
	}

	public int Them(String masach, String tensach, String tacgia, long gia, String anh, Date ngaynhap, String maloai)
			throws Exception {
		dc.KetNoi();
		if (KTMaSach(masach))
			return 0;
		String sql = "insert into sach(masach,tensach,tacgia,gia,anh,NgayNhap,maloai) values(?,?,?,?,?,?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		cmd.setString(2, tensach);
		cmd.setString(3, tacgia);
		cmd.setLong(4, gia);
		cmd.setString(5, anh);
		cmd.setDate(6, new java.sql.Date(ngaynhap.getTime()));
		cmd.setString(7, maloai);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}

	public int Sua(String masach, String tensachmoi, String tacgiamoi, long giamoi, String anhmoi, Date ngaynhapmoi,
			String maloaimoi) throws Exception {
		dc.KetNoi();
		int kq = 0;
		if (anhmoi.length() > 0) {
			String sql = "update sach set tensach=?, tacgia=?, gia=?, anh=?, NgayNhap=?, maloai=? where masach=?";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1, tensachmoi);
			cmd.setString(2, tacgiamoi);
			cmd.setLong(3, giamoi);
			cmd.setString(4, anhmoi);
			cmd.setDate(5, new java.sql.Date(ngaynhapmoi.getTime()));
			cmd.setString(6, maloaimoi);
			cmd.setString(7, masach);
			kq = cmd.executeUpdate();
			System.out.println("Thay doi anh");
		} else {
			String sql = "update sach set tensach=?, tacgia=?, gia=?, NgayNhap=?, maloai=? where masach=?";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1, tensachmoi);
			cmd.setString(2, tacgiamoi);
			cmd.setLong(3, giamoi);
			cmd.setDate(4, new java.sql.Date(ngaynhapmoi.getTime()));
			cmd.setString(5, maloaimoi);
			cmd.setString(6, masach);
			kq = cmd.executeUpdate();
			System.out.println("Khong doi anh");
		}
		dc.cn.close();
		return kq;
	}

	public int Xoa(String masach) throws Exception {
		dc.KetNoi();
		String sql = "delete from sach where masach=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}

	public sachbean TimMaSach(String masach) throws Exception {
		// b1: Ket noi vao csdl
		dc.KetNoi();
		// b2: Lay du lieu ve
		String sql = "select * from sach where masach=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		ResultSet rs = cmd.executeQuery();
		sachbean sbean = null;
		if (rs.next()) {
			String ms = rs.getString("masach");
			String tensach = rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			long gia = rs.getLong("gia");
			String anh = rs.getString("anh");
			Date ngaynhap = rs.getDate("NgayNhap");
			String maloai = rs.getString("maloai");
			sbean = new sachbean(ms, tensach, tacgia, gia, anh, ngaynhap, maloai);
		}
		// b3: Dong ket noi
		rs.close();
		dc.cn.close();
		return sbean;
	}
}
