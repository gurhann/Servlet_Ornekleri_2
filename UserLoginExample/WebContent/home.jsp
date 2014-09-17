<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.gurhan.util.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ana Sayfa</title>
</head>
<body>
	<%User user = (User)session.getAttribute("User"); %>
	<h3>Merhaba,  <%=user.getName() %></h3><br />
	<strong>Email : </strong> <%=user.getEmail()%><br />
	<strong>Ülke : </strong> <%=user.getCountry() %><br />
	<form action = "LogOut" method="post">
		<input type="submit" value="Çıkış Yap" />
	</form>
</body>
</html>