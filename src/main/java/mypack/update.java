package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class update extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<link rel='stylesheet' href='css/bootstrap.css'>");
		out.println("<script src=\"js/bootstrap.bundle.min.js\"></script>");
		String name=req.getParameter("name");
		String work=req.getParameter("work");
		String completed=req.getParameter("completed");
		String date=req.getParameter("date");
		String address=req.getParameter("address");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String days=req.getParameter("days");
		
		
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/remainder","root","siba@123");
			String q="update time1 set name=?,work=?,completed=?,date=?,address=?,phone=?,email=?,days=? where id=?";
			PreparedStatement ps=con.prepareStatement(q);
				ps.setString(1, name);
				ps.setString(2, work);
				ps.setString(3, completed);
				ps.setString(4, date);
				ps.setString(5, address);
				ps.setString(6, phone);
				ps.setString(7, email);
				ps.setString(8, days);
			
				ps.setInt(9, id);
			int count=ps.executeUpdate();
			
			if(count==1) {
				out.print("<h1>record is edited successfully</h1>");
			}else {
				out.print("sorry");
			}
				
		}
		catch(Exception e) {
		out.println(e);
		}
		
		out.print("<div class=\"btn-group\" role=\"group\" aria-label=\"Basic mixed styles example\">\r\n"
				+ "  <button type=\"button\" class=\"btn btn-danger\"><a href='remainder'style='text-decoration:none;color:white;'>booklist</a></button>\r\n"
				+ "  <button type=\"button\" class=\"btn btn-warning\"><a style='text-decoration:none;color:white;' href='index.jsp'>home</a></button>\r\n"
				+ ""
				+ "</div>");
	       
	}

}
