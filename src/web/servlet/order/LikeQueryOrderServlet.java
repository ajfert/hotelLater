package web.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.pojo.Order;
import com.bdqn.service.OrderService;
import com.bdqn.util.DoDate;
import com.bdqn.util.Page;

@WebServlet("/LikeQueryOrderServlet")
public class LikeQueryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int p = Integer.parseInt(request.getParameter("page"));
		int l = Integer.parseInt(request.getParameter("limit"));
		
		String o = request.getParameter("oid");
		String r = request.getParameter("rid");
		String u = request.getParameter("uid");
		String e = request.getParameter("eid");
		String start = request.getParameter("starttime");
		String end = request.getParameter("endtime");
		String book = request.getParameter("booktime");
		String price = request.getParameter("eprice");
		String status = request.getParameter("status");
		
		int oid = o.equals("")?0:Integer.parseInt(o);
		int rid = r.equals("")?0:Integer.parseInt(r);
		int uid = u.equals("")?0:Integer.parseInt(u);
		int eid = e.equals("")?0:Integer.parseInt(e);
		Date starttime = start.equals("")?null:DoDate.strtodate(start);
		Date endtime = end.equals("")?null:DoDate.strtodate(end);
		Date booktime = book.equals("")?null:DoDate.strtodate(book);
		int eprice = price.equals("")?0:Integer.parseInt(price);
		
		
		
		Order order = new Order(oid, rid, uid, eid, starttime, endtime, eprice, status, booktime, "");
		
		
		OrderService os = new OrderService();
		Page<Order> page = os.check(order, p, l);
		
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
