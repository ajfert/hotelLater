package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.pojo.Employee;
import com.bdqn.service.EmployeeService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String result = "错误";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		EmployeeService es = new EmployeeService();
		List<Employee> totlelist = es.getTotle();
		for(Employee emp:totlelist) {
			if(emp.getEmail().equals(email) && emp.getEpassword().equals(password)) {
				result = "正确";
				request.getSession().setAttribute("employee", emp);
				break;
			}
		}
		String ss = "{\"result\":\""+result+"\"}";
		PrintWriter out = response.getWriter();
		out.print(ss);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
