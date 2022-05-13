

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Book</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Book b=BookDao.getBookById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+b.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+b.getName()+"'/></td></tr>");
		out.print("<tr><td>Author:</td><td><input type='author' name='author' value='"+b.getAuthor()+"'/></td></tr>");
		out.print("<tr><td>Subject:</td><td>");
                out.print("<select name='subject' style='width:150px'>");
		out.print("<option>Thriller</option>");
		out.print("<option>Comedy</option>");
		out.print("<option>Action</option>");
		out.print("<option>Drama</option>");
		out.print("</select>");
		out.print("</td></tr>");
                out.print("<tr><td>Date:</td><td><input type='date' name='date' value='"+b.getDate()+"'/></td></tr>");
		
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
