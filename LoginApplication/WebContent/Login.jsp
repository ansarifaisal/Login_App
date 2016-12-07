<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title># LOGIN #</title>
</head>
<body>
	<!-- create a from with 2 field and 2 button  -->
	<form action="LoginServlet" method="post">
		USER NAME : <input type="text" placeholder="ENTER USER NAME" name="username"> 
		<br /> <br /> 
		PASSWORD : <input type="password" placeholder="ENTER PASSWORD" name="password">
		<br/> <br/>
		<input type="submit" value="LOG-IN">
		<br/> <br/>
		<input type="reset" value="RESET">
	</form>
</body>
</html>