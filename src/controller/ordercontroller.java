package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.chitietbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class ordercontroller
 */
@WebServlet("/ordercontroller")
public class ordercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ordercontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	hoadonbo hdbo = new hoadonbo();
	//chitietbo ctbo = new chitietbo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			if (session.getAttribute("makh") == null) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} else {
				String makh = (String) session.getAttribute("makh");
				int mahoadon = hdbo.Them(makh);
				giohangbo gh = new giohangbo();
				if (session.getAttribute("gh") == null) {
					session.setAttribute("gh", gh);
				}
				gh = (giohangbo) session.getAttribute("gh");
				chitietbo ctbo = new chitietbo();
				ctbo.Them(mahoadon, gh);
				gh.XoaTatCa();
				session.setAttribute("gh", gh);
				session.setAttribute("dsgh", gh.ds);
				session.setAttribute("tsl", gh.TongSoLuong());
				request.setAttribute("tt", gh.TongTien());
				RequestDispatcher rd = request.getRequestDispatcher("historycontroller");
				rd.forward(request, response);
			}
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
