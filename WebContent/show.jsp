<%@page import="java.util.List"%>
<%@page import="com.bdqn.pojo.User"%>
<%@page import="com.bdqn.util.Page"%>
<%@page import="com.bdqn.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示</title>
</head>
<script type="text/javascript" src='<c:url value="/js/jquery-3.3.1.js"/>'></script>
<body>
	<%
	Page<User> p = (Page<User>)session.getAttribute("page");
	//第一次访问就为null
	if(p==null){
		response.sendRedirect("showUserServlet");
	}else{
		//不是第一次就直接得到数据
		List<User> list = p.getData();
		request.setAttribute("list", list);
		request.setAttribute("p", p);
	}
	
	%>

	<table>
		<tr>
			<td>用户名</td>
			<td>用户真实姓名</td>
			<td>性别</td>
			<td>密码</td>
			<td>身份证号</td>
			<td>邮箱</td>
			<td>出生年月</td>
			<td>手机号</td>
			<td>备注</td>
			<td>头像</td>
		</tr>
	
		<c:forEach var="user" items="${requestScope.list }" varStatus="i">
			<tr>
				<td>${user.uid }</td>
				<td>${user.uname }</td>
				<td>${user.ugender }</td>
				<td>${user.upassword }</td>
				<td>${user.uidentity }</td>
				<td>${user.uemail }</td>
				<td>${user.uborn }</td>
				<td>${user.uphone }</td>
				<td>${user.remark }</td>
				<td>
					<c:if test="${user.upicture ne null }">
						<img height="50px" width="50px" alt="tupian" src="<%=request.getContextPath()%>/upload/${user.upicture }">
					</c:if>
					
				
				</td>
			</tr>
		</c:forEach>
		
	</table>
	<a href="showUserServlet?current=1">首页</a>
	<a href="showUserServlet?current=${p.current-1 }">上一页</a>
	<a href="showUserServlet?current=${p.current+1 }">下一页</a>
	<a href="showUserServlet?current=${p.totlePage }">尾页</a>
	
	
</body>
</html>