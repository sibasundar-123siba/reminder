package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class delete extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/remainder","root","siba@123");
			String q="delete from time1 where id=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, id);
		ps.executeUpdate();
		RequestDispatcher rd=req.getRequestDispatcher("remainder");
		rd.forward(req, resp);
		
		
		
			
		}
		catch(Exception e) {
		out.println(e);
		}
	       
	}


}
