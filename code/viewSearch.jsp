<%@ page import="java.util.*" %> 
<html>
<head>
</head>
<body>

<br><br><br><br><br><br>
<table width="700px" align="center"  style="border:1px solid #000000;">
<tr>
<td colspan=8 align="center" style="background-color:ffeeff"><b>Book Record</b></td>
</tr>
<tr style="background-color:efefef;">
<td><b>ID</b></td>
<td><b>Name</b></td>
<td><b>Author</b></td>
<td><b>Subject</b></td>
<td><b>Date</b></td>
</tr>
<%
int count=0;
String color = "#F9EBB3";


if(request.getAttribute("bookList")!=null)
{
 ArrayList al = (ArrayList)request.getAttribute("bookList");
	Iterator itr = al.iterator();
	
	
	while(itr.hasNext())
	{
		
		if((count%2)==0)
		{
			
			color = "#eeffee";
			
			
		}
		else
		{
			 color = "#F9EBB3";
		}
		count++;
		ArrayList empList = (ArrayList)itr.next();
		%>
<tr style="background-color:<%=color%>;">
<td><%=empList.get(0)%></td>
<td><%=empList.get(1)%></td>
<td><%=empList.get(3)%></td>
<td><%=empList.get(4)%></td>
<td><%=empList.get(5)%></td>
<td><%=empList.get(6)%></td>
<td><%=empList.get(7)%></td>
<td><%=empList.get(8)%></td>

</tr>
		<%
	
	}
}

%>

<%
if(count==0)
{
	%>
<tr>
<td colspan=8 align="center" style="background-color:eeffee"><b>No Record</b></td>


</tr>
	<%
}
%>
</table>
</body>
</html>