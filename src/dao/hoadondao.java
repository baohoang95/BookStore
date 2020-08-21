package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.hoadonbean;

public class hoadondao {
	dungchung dc = new dungchung();

	public ArrayList<hoadonbean> gethoadon() throws Exception {
		ArrayList<hoadonbean> ds = new ArrayList<hoadonbean>();
		// b1: Ket noi vao csdl
		dc.KetNoi();
		// b2: Lay du lieu ve
		String sql = "select * from hoadon where damua=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setBoolean(1, false);
		ResultSet rs = cmd.executeQuery();
		// Lay du lieu ve
		while (rs.next()) {
			// Duyet qua tap du lieu de luu vao mang ds
			int MaHoaDon = rs.getInt("MaHoaDon");
			String makh = rs.getString("makh");
			Date NgayMua = rs.getDate("NgayMua");
			boolean damua = rs.getBoolean("damua");
			ds.add(new hoadonbean(MaHoaDon, makh, NgayMua, damua));
		}
		// b3: Dong ket noi
		rs.close();
		dc.cn.close();
		return ds;
	}

	public void xacnhan(String mahoadon) throws Exception {
		dc.KetNoi();
		String sql = "update hoadon set damua=? where MaHoaDon=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setBoolean(1, true);
		cmd.setString(2, mahoadon);
		cmd.executeUpdate();
		dc.cn.close();
	}

	public ArrayList<hoadonbean> gethoadon(String makh) throws Exception {
		ArrayList<hoadonbean> ds = new ArrayList<hoadonbean>();
		// b1: Ket noi vao csdl
		dc.KetNoi();
		// b2: Lay du lieu ve
		String sql = "select * from hoadon where makh=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, makh);
		ResultSet rs = cmd.executeQuery();
		// Lay du lieu ve
		while (rs.next()) {
			// Duyet qua tap du lieu de luu vao mang ds
			int MaHoaDon = rs.getInt("MaHoaDon");
			String makhachhang = rs.getString("makh");
			Date NgayMua = rs.getDate("NgayMua");
			boolean damua = rs.getBoolean("damua");
			ds.add(new hoadonbean(MaHoaDon, makhachhang, NgayMua, damua));
		}
		// b3: Dong ket noi
		rs.close();
		dc.cn.close();
		return ds;
	}

	public int sinhmahoadon() throws Exception {
		String sql = "select top 1 * from hoadon order by  MaHoaDon desc";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();
		int count = 0;
		while (r.next()) {
			String MaHoaDon = r.getString("MaHoaDon");
			count = Integer.parseInt(MaHoaDon);
		}
		return count;
	}

	public int Them(String makh) throws Exception {
		dc.KetNoi();
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		String sql = "insert into hoadon(MaHoaDon,makh,NgayMua,damua) values(?,?,?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		int mahoadon = sinhmahoadon() + 1;
		cmd.setInt(1, mahoadon);
		cmd.setString(2, makh);
		cmd.setDate(3, date);
		cmd.setBoolean(4, false);
		cmd.executeUpdate();
		dc.cn.close();
		return mahoadon;
	}
}
