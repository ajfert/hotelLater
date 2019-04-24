package web.servlet.Emjur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.service.EmjurService;
import com.bdqn.util.EmjurMess;
import com.bdqn.util.Page;
@WebServlet("/UpdateEmjurServlet")
public class UpdateEmjurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int eid = Integer.parseInt(request.getParameter("eid"));
		
		String jname = request.getParameter("jname");
		
		EmjurService es = new EmjurService();
		boolean result = es.add(eid, jname);
		if(result) {
			Page<EmjurMess> mess = es.getMess(eid,1,10);
			String ss = JSONObject.toJSONStringWithDateFormat(mess.getData(), "yyyy-MM-dd");
			String s = "{\"code\":0,\"msg\":\"\",\"count\":"+mess.getTotle()+",\"data\":"+ss+"}";
			PrintWriter out = response.getWriter();
			out.print(s);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
