package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dungchung {
	public Connection cn;

	public void KetNoi() throws Exception {
		// b1: Xac dinh HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.print("Da xac dinh HQTCSDL\n");
		// b2: Ket noi vao csdl
		String dburl="jdbc:sqlserver://DESKTOP-622VA52\\SQLEXPRESS:1433;databaseName=Qlsach;user=sa;password=123 \r\n" + "";
		//String url = "jdbc:sqlserver://DESKTOP-HK50P6J\\SQLEXPRESS:1433;databaseName=QlSach;user=sa;password=1234";
		cn = DriverManager.getConnection(dburl);
		System.out.print("Da ket noi\n");
	}
}
