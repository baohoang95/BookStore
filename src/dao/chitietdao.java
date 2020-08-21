package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.chitietbean;
import bean.giohangbean;
import bean.hoadonbean;
import bo.giohangbo;

public class chitietdao {
	dungchung dc = new dungchung();

	public ArrayList<chitietbean> getchitiet() throws Exception {
		ArrayList<chitietbean> ds = new ArrayList<chitietbean>();
		// b1: Ket noi vao csdl
		dc.KetNoi();
		// b2: Lay du lieu ve
		String sql = "select * from ChiTietHoaDon";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		// Lay du lieu ve
		while (rs.next()) {
			// Duyet qua tap du lieu de luu vao mang ds
			int MaChiTietHD = rs.getInt("MaChiTietHD");
			String MaSach = rs.getString("MaSach");
			int SoLuongMua = rs.getInt("SoLuongMua");
			int MaHoaDon = rs.getInt("MaHoaDon");
			ds.add(new chitietbean(MaChiTietHD, MaSach, SoLuongMua, MaHoaDon));
		}
		// b3: Dong ket noi
		rs.close();
		dc.cn.close();
		return ds;
	}

	public ArrayList<chitietbean> getchitiet(int mahoadon) throws Exception {
		ArrayList<chitietbean> ds = new ArrayList<chitietbean>();
		// b1: Ket noi vao csdl
		dc.KetNoi();
		// b2: Lay du lieu ve
		String sql = "select * from ChiTietHoaDon where MaHoaDon=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setInt(1, mahoadon);
		ResultSet rs = cmd.executeQuery();
		// Lay du lieu ve
		while (rs.next()) {
			// Duyet qua tap du lieu de luu vao mang ds
			int MaChiTietHD = rs.getInt("MaChiTietHD");
			String MaSach = rs.getString("MaSach");
			int SoLuongMua = rs.getInt("SoLuongMua");
			int MaHoaDon = rs.getInt("MaHoaDon");
			ds.add(new chitietbean(MaChiTietHD, MaSach, SoLuongMua, MaHoaDon));
		}
		// b3: Dong ket noi
		rs.close();
		dc.cn.close();
		return ds;
	}

	public int sinhmachitiet() throws Exception {
		String sql = "select top 1 * from ChiTietHoaDon order by MaChiTietHD desc";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();
		int count = 0;
		while (r.next()) {
			String MaChiTietHD = r.getString("MaChiTietHD");
			count = Integer.parseInt(MaChiTietHD);
		}
		return count;
	}

	public void Them(int mahoadon, giohangbo gh) throws Exception {
		dc.KetNoi();
		int macthd = sinhmachitiet() + 1;
		for (giohangbean g : gh.ds) {
			String sql = "insert into ChiTietHoaDon(MaChiTietHD,MaSach,SoLuongMua,MaHoaDon) values(?,?,?,?)";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setInt(1, macthd);
			cmd.setString(2, g.getMasach());
			cmd.setInt(3, (int)g.getSoluong());
			cmd.setInt(4, mahoadon);
			cmd.executeUpdate();
			macthd++;
		}
		dc.cn.close();
	}
}
