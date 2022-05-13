

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String subject=request.getParameter("subject");
		String date=request.getParameter("date");
		
		Book b=new Book();
		b.setName(name);
		b.setDate(date);
		b.setAuthor(author);
		b.setSubject(subject);
		
		int status=BookDao.save(b);
		if(status>0){
			out.print("<center>");
			out.print("<p>Record saved successfully!</p>");
			out.print("<a href=\"index.jsp\">view  Book</a>");
			out.print("</center>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
