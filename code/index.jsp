<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Add New Book</h1>
<form action="SaveServlet" method="post">
<table>
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
<tr><td>Author:</td><td><input type="text" name="author"/></td></tr>
<tr><td>Subject:</td><td>
<select name="subject" style="width:150px">
<option>Thriller</option>
<option>Comedy</option>
<option>Action</option>
<option>Drama</option>
</select>
</td></tr>
<tr><td>Date:</td><td><input type="date" name="date"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Save Book"/></td></tr>
</table>
</form>

<br/>
<a href="ViewServlet">view  Book</a>
</center>
</body>
</html>