package web.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.pojo.User;
import com.bdqn.service.UserService;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("uname");
		String utruename = request.getParameter("utruename");
		String ugender = request.getParameter("ugender");
		String uemail = request.getParameter("uemail");
		String uphone = request.getParameter("uphone");
		String uidentity = request.getParameter("uidentity");
		String upassword = request.getParameter("upassword");
		Date uborn = strtodate(request.getParameter("uborn"));
		String upicture = request.getParameter("upicture");
	
		User user = new User(uid, uname, ugender, upassword, uidentity, uemail, uborn, uphone, utruename, upicture);
		//System.out.println(uid+","+uname+","+utruename+","+ugender+","+uemail+","+uphone+","+uidentity+","+upassword+","+uborn);
		UserService us = new UserService();
		boolean result = us.updateById(uid, user);
		if(result) {
			String s = "{\"result\":\"成功\"}";
			PrintWriter writer = response.getWriter();
			writer.print(s);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public Date strtodate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(str);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
