package web.servlet.comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.service.CommentService;
import com.bdqn.util.NewComment;
import com.bdqn.util.Page;

@WebServlet("/ShowCommentServlet")
public class ShowCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int cur = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("limit"));
		
		CommentService cs = new CommentService();
		Page<NewComment> paging = cs.paging(cur, pageSize);
		int count = paging.getTotle();
		String ss = JSONObject.toJSONStringWithDateFormat(paging.getData(), "yyyy-MM-dd");
		String s = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+ss+"}";
		
		PrintWriter out = response.getWriter();
		out.print(s);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
