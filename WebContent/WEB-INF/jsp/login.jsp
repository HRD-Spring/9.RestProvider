<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body><h1>Login</h1>

<label style="color:red;">${errorMsg}</label>
<form action="${pageContext.request.contextPath}/login" method="post">
  First name:<br>
  <input type="text" name="username"/><br>
  Password:<br>
  <input type="text" name="password"/>
  <br><input type="submit" value="login"/>
</form>
</body>
</html>