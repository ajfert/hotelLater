package web.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.pojo.Room;
import com.bdqn.service.RoomService;
@WebServlet("/CaculatePrice")
public class CaculatePrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int rid = Integer.parseInt(request.getParameter("rid"));
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");

		RoomService rs = new RoomService();
		Room room = rs.queryById(rid);
		int price = room.getPrice();//单价
		
		Date st = strtodate(starttime);
		Date et = strtodate(endtime);
		int count = numOfDay(st, et);//天数
		
		int eprice = price*count;//总价
		//System.out.println("单价"+price+"总价"+eprice+"天数"+count);
		String s = "{\"eprice\":"+eprice+"}";
		
		PrintWriter out = response.getWriter();
		out.print(s);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	//字符串转日期
	public Date strtodate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(str);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	//计算两个日期之间的天数
	public int numOfDay(Date start,Date end) {
		Calendar c = Calendar.getInstance();
		c.setTime(start);
		int count = 0;
		while(c.getTime().compareTo(end)!=0) {
			c.add(Calendar.DATE, 1);
			count++;
		}
		return count;
	}
}
