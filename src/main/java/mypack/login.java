package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class login extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","siba@123");
			String q="select * from user_info where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1,email);
			ps.setString(2, password);
			
			ResultSet p=ps.executeQuery();
			if(p.next()) {
				HttpSession session=req.getSession();
				session.setAttribute("session_name",p.getString("name"));
				RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);
			}else {
				out.print("no data found......");
				RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
			}
			
		}
		catch(Exception e) {
		out.println(e);
		}
	 
}
}