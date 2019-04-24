package web.servlet.room;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.pojo.Room;
import com.bdqn.service.RoomService;
@WebServlet("/UpdateRoomServlet")
public class UpdateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		int rid = Integer.parseInt(request.getParameter("rid"));
		String type = request.getParameter("type");
		int price = Integer.parseInt(request.getParameter("price"));
		String peoplenum = request.getParameter("peoplenum");
		String status = request.getParameter("status");
		String remark = request.getParameter("remark");
		
		Room room = new Room(rid, type, price, peoplenum, status, remark);
		
		RoomService os = new RoomService();
		boolean result = os.updateById(rid, room);
		if(result) {
			String s = "{\"result\":\"成功\"}";
			PrintWriter writer = response.getWriter();
			writer.print(s);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
