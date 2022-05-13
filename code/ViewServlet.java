import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		out.println("<h1>Book List</h1>");
		out.println("<a href='search.jsp'>Search Book</a>");
		
		List<Book> list=BookDao.getAllBook();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Author</th><th>Subject</th><th>Date</th><th>Edit</th><th>Delete</th></tr>");
		for(Book b:list){
			out.print("<tr><td>"+b.getId()+"</td><td>"+b.getName()+"</td><td>"+b.getAuthor()+"</td><td>"+b.getSubject()+"</td><td>"+b.getDate()+"</td><td><a href='EditServlet?id="+b.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+b.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.println("<a href='index.jsp'>Add New Book</a>");
		out.close();
	}
}
