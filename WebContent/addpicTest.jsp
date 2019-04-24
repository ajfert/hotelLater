<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addUpictureServlet" method="post" enctype="multipart/form-data">
		用户id：<input type="hidden" name="uid" value="5"><br>
		用户头像：<input type="file" name="upicture"><br>
		<p><%=request.getContextPath()%></p>
		<input type="submit" value="提交">
	</form>
</body>
</html>