<%@ page import="java.sql.*" %> 
<html>
<head>
</head>
<body>

<br><br><br><br><br><br>

<form method="post" name="frm" action="viewSearch.jsp">
<h3>Search Book</h3></td></tr>
<tr><td ><b>Name</b></td><td>: <input  type="text" name="name" id="name">
</td></tr>
<tr><td ><b>Author</b></td><td>: <input  type="text" name="author" id="author">
</td></tr>
<tr><td ><b>Subject</b></td><td>: <input  type="text" name="subject" id="subject">
</td></tr>
<tr><td ><b>Date</b></td><td>: <input  type="date" name="date" id="date">
</td></tr>
<tr><td colspan=2 align="center"><input  type="submit" name="submit" value="Submit"></td></tr>
</table>
</form>
</body>
</html>