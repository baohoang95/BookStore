package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.dangnhapbean;

public class dangnhapdao {
	dungchung dc = new dungchung();

	public ArrayList<dangnhapbean> getdangnhap() throws Exception {
		ArrayList<dangnhapbean> ds = new ArrayList<dangnhapbean>();
		// b1: Ket noi vao csdl
		dc.KetNoi();
		// b2: Lay du lieu ve
		String sql = "select * from DangNhap";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		// Lay du lieu ve
		while (rs.next()) {
			// Duyet qua tap du lieu de luu vao mang ds
			String TenDangNhap = rs.getString("TenDangNhap");
			String MatKhau = rs.getString("MatKhau");
			boolean Quyen = rs.getBoolean("Quyen");
			ds.add(new dangnhapbean(TenDangNhap, MatKhau, Quyen));
		}
		// b3: Dong ket noi
		rs.close();
		dc.cn.close();
		return ds;
	}

//	public dangnhapbean timtendangnhap(String tendangnhap) throws Exception {
//		// b1: Ket noi vao csdl
//		dc.KetNoi();
//		// b2: Lay du lieu ve
//		String sql = "select * from DangNhap where TenDangNhap=?";
//		PreparedStatement cmd = dc.cn.prepareStatement(sql);
//		cmd.setString(1, tendangnhap);
//		ResultSet rs = cmd.executeQuery();
//		dangnhapbean dnbean = null;
//		if (rs.next()) {
//			String tendn = rs.getString("TenDangNhap");
//			String mk = rs.getString("MatKhau");
//			boolean quyen = rs.getBoolean("Quyen");
//			dnbean = new dangnhapbean(tendn, mk, quyen);
//		}
//		// b3: Dong ket noi
//		rs.close();
//		dc.cn.close();
//		return dnbean;
//	}

	public boolean KTDangNhap(String TenDangNhap, String MatKhau) throws Exception {
		dc.KetNoi();
		String sql = "select TenDangNhap from DangNhap where TenDangNhap = ? and MatKhau = ? and Quyen = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, TenDangNhap);
		cmd.setString(2, MatKhau);
		cmd.setBoolean(3, true);
		ResultSet rs = cmd.executeQuery();
		boolean kq = rs.next();
		rs.close();
		dc.cn.close();
		return kq;
	}
}
