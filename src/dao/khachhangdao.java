package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;

public class khachhangdao {
	dungchung dc = new dungchung();
	//kt dang nhap
	public boolean KTDangNhap(String tendn, String pass) throws Exception {
		dc.KetNoi();
		String sql = "select makh from KhachHang where (tendn=? and pass=?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, pass);
		ResultSet rs = cmd.executeQuery();
		boolean kq = rs.next();
		rs.close();
		dc.cn.close();
		return kq;
	}
// get khachs hang
	public ArrayList<khachhangbean> getkhachhang() throws Exception {
		ArrayList<khachhangbean> ds = new ArrayList<khachhangbean>();
		// b1: Ket noi vao csdl
		dc.KetNoi();
		// b2: Lay du lieu ve
		String sql = "select * from KhachHang";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		// Lay du lieu ve
		while (rs.next()) {
			// Duyet qua tap du lieu de luu vao mang ds
			String makh = rs.getString("makh");
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sodt = rs.getString("sodt");
			String email = rs.getString("email");
			String tendn = rs.getString("tendn");
			String pass = rs.getString("pass");
			ds.add(new khachhangbean(makh, hoten, diachi, sodt, email, tendn, pass));
		}
		// b3: Dong ket noi
		rs.close();
		dc.cn.close();
		return ds;
	}
	//lay makh
	public khachhangbean timkhachhang(String tendangnhap) throws Exception {
		// b1: Ket noi vao csdl
		dc.KetNoi();
		// b2: Lay du lieu ve
		String sql = "select * from KhachHang where tendn=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tendangnhap);
		ResultSet rs = cmd.executeQuery();
		khachhangbean khbean = null;
		if (rs.next()) {
			String makh = rs.getString("makh");
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sodt = rs.getString("sodt");
			String email = rs.getString("email");
			String tendn = rs.getString("tendn");
			String pass = rs.getString("pass");
			khbean = new khachhangbean(makh, hoten, diachi, sodt, email, tendn, pass);
		}
		// b3: Dong ket noi
		rs.close();
		dc.cn.close();
		return khbean;
	}
}
