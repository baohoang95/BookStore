package controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class adbookcontroller
 */
@WebServlet("/adbookcontroller")
public class adbookcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adbookcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	sachbo sbo = new sachbo();
	loaibo lbo = new loaibo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "image_sach";
		response.getWriter().println(dirUrl1);
		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Láº¥y vá»� cÃ¡c Ä‘á»‘i tÆ°á»£ng gá»­i lÃªn
			String txtmasach = "";
			String txttensach = "";
			String txttacgia = "";
			String txtgia = "";
			String txtngaynhap = "";
			String txtmaloai = "";
			String nameimg = "";
			String butthem = "";
			String butsua = "";
			// duyá»‡t qua cÃ¡c Ä‘á»‘i tÆ°á»£ng gá»­i lÃªn tá»« client gá»“m file vÃ  cÃ¡c control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Náº¿u ko pháº£i cÃ¡c control=>upfile lÃªn
					// xá»­ lÃ½ file
					nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Láº¥y Ä‘Æ°á»�ng dáº«n hiá»‡n táº¡i, chá»§ Ã½ xá»­ lÃ½ trÃªn dirUrl Ä‘á»ƒ cÃ³ Ä‘Æ°á»�ng dáº«n Ä‘Ãºng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "image_sach";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// náº¿u ko cÃ³ thÆ° má»¥c thÃ¬ táº¡o ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// táº¡o file
						try {
							fileItem.write(file);// lÆ°u file
							System.out.println("Upload Thành Công");
							System.out.println("Đường dẫn lưu file là : " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("txtmasach"))
						txtmasach = fileItem.getString();
					if (tentk.equals("txttensach"))
						txttensach = fileItem.getString();
					if (tentk.equals("txttacgia"))
						txttacgia = fileItem.getString();
					if (tentk.equals("txtgia"))
						txtgia = fileItem.getString();
					if (tentk.equals("txtngaynhap"))
						txtngaynhap = fileItem.getString();
					if (tentk.equals("txtmaloai"))
						txtmaloai = fileItem.getString();
					if (tentk.equals("butthem"))
						butthem = fileItem.getString();
					if (tentk.equals("butsua"))
						butsua = fileItem.getString();
				}
			}
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				Date date = formatter.parse(txtngaynhap);
				if (butthem.equals("Add")) {
					int n = sbo.Them(txtmasach, txttensach, txttacgia, Long.parseLong(txtgia), "image_sach/" + nameimg,
							date, txtmaloai);
					if (n == 0)
						request.setAttribute("ktnhap", 0);
				} else if (butsua.equals("Edit")) {
					sbo.Sua(txtmasach, txttensach, txttacgia, Long.parseLong(txtgia), "image_sach/" + nameimg, date,
							txtmaloai);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		try {
			if (request.getParameter("mschon") != null) {
				request.setAttribute("chon", sbo.TimMaSach(request.getParameter("mschon")));
			}
			if (request.getParameter("msxoa") != null) {
				sbo.Xoa(request.getParameter("msxoa"));
			}
			request.setAttribute("dsloai", lbo.getloai());
			request.setAttribute("dssach", sbo.getsach());
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("adbook.jsp");
		rd.forward(request, response);
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
