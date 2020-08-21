package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.dangnhapbo;
import bo.khachhangbo;

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public logincontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	dangnhapbo dnbo = new dangnhapbo();
	khachhangbo khbo = new khachhangbo();
	khachhangbean khbean = new khachhangbean();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String user = request.getParameter("user");
			String tendangnhap = request.getParameter("username");
			String matkhau = request.getParameter("password");
			if (user != null && !user.isEmpty() && tendangnhap != null && !tendangnhap.isEmpty() && matkhau != null
					&& !matkhau.isEmpty()) {
				if (user.equals("admin")) {
					if (dnbo.KTDangNhap(tendangnhap, matkhau)) {
						RequestDispatcher rd = request.getRequestDispatcher("adhomecontroller");
						rd.forward(request, response);
					}
				} else if (user.equals("customer")) {
					if (khbo.KTDangNhap(tendangnhap, matkhau)) {
						khbean = khbo.timkhachhang(tendangnhap);
						HttpSession session = request.getSession();
						session.setAttribute("tendn", tendangnhap);
						session.setAttribute("makh", khbean.getMakh());
						RequestDispatcher rd = request.getRequestDispatcher("homecontroller");
						rd.forward(request, response);
					}
				}
				request.setAttribute("rs", "Fail");
			}
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
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
