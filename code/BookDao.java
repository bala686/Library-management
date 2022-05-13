import java.util.*;

import java.sql.*;

public class BookDao {

static Connection con=null;
	
	public static Connection getCon()
	{
	String URL="jdbc:postgresql://localhost:3030/postgres";
	String pwd="1234";
	String name="postgres";
		try
		{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL,name,pwd);
            System.out.println("Connected to the PostgreSQL server successfully.");
        
        } catch (Exception b) {
            System.out.println(b);
        }
		
		return con;
	}
	public static int save(Book b){
		int status=0;
		try{
			Connection con=BookDao.getCon();
			PreparedStatement ps=con.prepareStatement("insert into book(name,author,subject,date) values (?,?,?,?)");
			ps.setString(1,b.getName());
			ps.setString(2,b.getAuthor());
			ps.setString(3,b.getSubject());
			ps.setString(4,b.getDate());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Book b){
		int status=0;
		try{
			Connection con=BookDao.getCon();
			PreparedStatement ps=con.prepareStatement("update book set name=?,author=?,subject=?,date=? where id=?");
			ps.setString(1,b.getName());
			ps.setString(2,b.getAuthor());
			ps.setString(3,b.getSubject());
			ps.setString(4,b.getDate());
			ps.setInt(5,b.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=BookDao.getCon();
			PreparedStatement ps=con.prepareStatement("delete from book where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception b){b.printStackTrace();}
		
		return status;
	}
	public static Book getBookById(int id){
		Book b=new Book();
		
		try{
			Connection con=BookDao.getCon();
			PreparedStatement ps=con.prepareStatement("select * from book where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setSubject(rs.getString(4));
				b.setDate(rs.getString(5));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return b;
	}
	public static List<Book> getAllBook(){
		List<Book> list=new ArrayList<Book>();
		
		try{
			Connection con=BookDao.getCon();
			PreparedStatement ps=con.prepareStatement("select * from book");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Book b=new Book();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setSubject(rs.getString(4));
				b.setDate(rs.getString(5));
				list.add(b);
			}
			con.close();
		}catch(Exception b){b.printStackTrace();}
		
		return list;
	}
	public boolean validate(Book Book)
	{
		boolean status = false;
		
		
		Connection con = getCon();
		
		String sql = "select * from login where username = ? and password =?";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, Book.getUsername());
		ps.setString(2, Book.getPassword());
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		
		} catch (SQLException b) {
			// TODO Auto-generated catch block
			b.printStackTrace();
		}
		return status;
	}
}
