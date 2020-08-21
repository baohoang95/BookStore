package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.sachbean;
import bo.giohangbo;
import bo.sachbo;

/**
 * Servlet implementation class cartcontroller
 */
@WebServlet("/cartcontroller")
public class cartcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cartcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	sachbo sbo = new sachbo();
	sachbean sbean = new sachbean();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			giohangbo gh = new giohangbo();
			if (session.getAttribute("gh") == null) {
				session.setAttribute("gh", gh);
			}
			gh = (giohangbo) session.getAttribute("gh");
			String ms = request.getParameter("ms");
			String soluong = request.getParameter("sl");
			if (ms != null && !ms.isEmpty()) {
				sbean = sbo.getonesach(ms);
				if (soluong != null && !soluong.isEmpty()) {
					long sl = Long.parseLong(soluong);
					gh.Them(sbean.getMasach(), sbean.getTensach(), sbean.getAnh(), (long) sl, sbean.getGia());
				} else
					gh.Them(sbean.getMasach(), sbean.getTensach(), sbean.getAnh(), (long) 1, sbean.getGia());
			}
			String x = request.getParameter("x");
			if (x != null && !x.isEmpty()) {
				gh.Xoa(x);
				if(gh.TongSoLuong()==0) {
					session.setAttribute("gh", gh);
					session.setAttribute("dsgh", gh.ds);
					session.setAttribute("tsl", gh.TongSoLuong());
					request.setAttribute("tt", gh.TongTien());
					RequestDispatcher rd = request.getRequestDispatcher("shopcontroller");
					rd.forward(request, response);
				}
			}
			String cn = request.getParameter("cn");
			String sl = request.getParameter("sl");
			if (cn != null && !cn.isEmpty() && sl != null && !sl.isEmpty()) {
				long n = Long.parseLong(sl);
				sbean = sbo.getonesach(cn);
				gh.CapNhat(cn, n);
			}
			String xoagiohang = request.getParameter("xoagiohang");
			if (xoagiohang != null && !xoagiohang.isEmpty()) {
				gh.XoaTatCa();
				session.setAttribute("gh", gh);
				session.setAttribute("dsgh", gh.ds);
				session.setAttribute("tsl", gh.TongSoLuong());
				request.setAttribute("tt", gh.TongTien());
				RequestDispatcher rd = request.getRequestDispatcher("shopcontroller");
				rd.forward(request, response);
			}
			session.setAttribute("gh", gh);
			session.setAttribute("dsgh", gh.ds);
			session.setAttribute("tsl", gh.TongSoLuong());
			request.setAttribute("tt", gh.TongTien());
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
