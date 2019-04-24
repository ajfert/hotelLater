package web.servlet.order;

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

import com.bdqn.pojo.Order;
import com.bdqn.service.OrderService;
@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int oid = Integer.parseInt(request.getParameter("oid"));
		int rid = Integer.parseInt(request.getParameter("rid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		int eid = Integer.parseInt(request.getParameter("eid"));
		Date starttime = strtodate(request.getParameter("starttime"));
		Date endtime = strtodate(request.getParameter("endtime"));
		int eprice = Integer.parseInt(request.getParameter("eprice"));
		Date booktime = strtodate(request.getParameter("booktime"));
		String status = request.getParameter("status");
		String remark = request.getParameter("remark");
		
		Order order = new Order(oid, rid, uid, eid, starttime, endtime, eprice, status, booktime, remark);
	
		OrderService os = new OrderService();
		boolean result = os.updateById(oid, order);
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
