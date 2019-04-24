<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="adduserServlet" method="post" enctype="multipart/form-data">
		用户id：<input type="text" name="uid"><br>
		用户名：<input type="text" name="uname"><br>
		用户真名：<input type="text" name="utruename"><br>
		用户性别：<input type="text" name="ugender"><br>
		用户密码：<input type="text" name="upassword"><br>
		用户身份证号：<input type="text" name="uidentity"><br>
		用户手机号：<input type="text" name="uphone"><br>
		用户邮箱：<input type="text" name="uemail"><br>
		用户出生年月：<input type="text" name="uborn"><br>
		用户头像：<input type="file" name="upicture"><br>
		<p><%=request.getContextPath()%></p>
		<input type="submit" value="提交">
	</form>
</body>
</html>