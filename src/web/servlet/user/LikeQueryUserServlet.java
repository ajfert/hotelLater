package web.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.pojo.User;
import com.bdqn.service.UserService;
import com.bdqn.util.Page;

@WebServlet("/LikeQueryUserServlet")
public class LikeQueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int p = Integer.parseInt(request.getParameter("page"));
		int l = Integer.parseInt(request.getParameter("limit"));
		
		String uname = request.getParameter("uname");
		String utruename = request.getParameter("utruename");
		String uemail = request.getParameter("uemail");
		
		
		UserService us = new UserService();
		Page<User> page = us.queryLike(uname, utruename, uemail, p, l);
		
		int count = page.getTotle();
		String ss = JSONObject.toJSONStringWithDateFormat(page.getData(), "yyyy-MM-dd");
		
		String s = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+ss+"}";
		PrintWriter out = response.getWriter();
		out.print(s);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
