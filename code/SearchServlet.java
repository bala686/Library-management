import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class SearchServlet extends HttpServlet{ 
 
   public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			Connection conn = null;
			String url = "jdbc:postgresql://localhost:3030/postgres";
			String driver = "org.postgresql.Driver";
			String userName = "postgres"; 
			String password = "1234";

			
			Statement st;
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,userName,password);
				System.out.println("Connected to the database");
				String  name  = request.getParameter("name");
				String  author  = request.getParameter("author");
				String  subject  = request.getParameter("subject");
				String  date  = request.getParameter("date");

				ArrayList al=null;
				ArrayList list =new ArrayList();
				String query = "select * from book where name='"+name+"' or author='"+author+"' or subject='"+subject+"' or date='"+date+"' order by name";
				System.out.println("query " + query);
				st = conn.createStatement();
				ResultSet  rs = st.executeQuery(query);


				while(rs.next())
				{
					al  = new ArrayList();
				
				  al.add(rs.getString(1));
				  al.add(rs.getString(2));
				  al.add(rs.getString(3));
				  al.add(rs.getString(4));
				  System.out.println("al :: "+al);
				  list.add(al);
				}

				request.setAttribute("booklist",list);
				
             System.out.println("booklist " + list);

			//   out.println("list " + list);

				String nextJSP = "/viewSearch.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				conn.close();
				System.out.println("Disconnected from database");
			} catch (Exception e) {
			e.printStackTrace();
			}
  }
}