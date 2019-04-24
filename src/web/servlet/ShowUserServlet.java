package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.pojo.User;
import com.bdqn.service.UserService;
import com.bdqn.util.Page;
@WebServlet("/showUserServlet")
public class ShowUserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = new UserService();
		//拿到传过来的页码
		String c = req.getParameter("current");
		//页码
		int cur = 0;
		//如果是第一次跳转过来就为空，就显示第一页
		if(c==null) {
			cur = 1;
		}else {
			cur = Integer.parseInt(c);
		}
		
		//调用分页方法
		Page<User> page = userService.paging(cur, 4);
		//得到分页的所有数据然后跳转回去
		req.getSession().setAttribute("page", page);
		resp.sendRedirect("show.jsp");
		
	}
}
