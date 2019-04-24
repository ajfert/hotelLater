package web.Filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.pojo.Emjur;
import com.bdqn.pojo.Employee;
import com.bdqn.service.EmjurService;

@WebFilter("/model/index.jsp")
public class VisitFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
//		String path = req.getContextPath();
//		System.out.println(path);
		Object emp = session.getAttribute("employee");
		if(emp==null) {
			resp.sendRedirect("/Hotel/model/page-login.jsp");
		}else {
			Employee employee = (Employee)emp;
			int eid = employee.getEid();
			
			EmjurService es = new EmjurService();
			List<Emjur> list = es.queryById(eid);
			session.setAttribute("emjurlist", list);
			
			chain.doFilter(request, response);
		}
		
		
	}
}
