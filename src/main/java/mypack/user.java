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
@WebServlet("/user")
public class user extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		String phone=req.getParameter("phone");
		String address=req.getParameter("address");
		String gender=req.getParameter("gender");
		String pin=req.getParameter("pin");
		String city=req.getParameter("city");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","siba@123");
			String q="insert into user_info(name,email,phone,password,city,pincode,address,gender)values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, pass);
			ps.setString(5, city);
			ps.setString(6, pin);
			ps.setString(7, address);
			ps.setString(8, gender);
			
			ps.executeUpdate();
			
			RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
			rd.forward(req, resp);
			
		}
		catch(Exception e) {
		out.println(e);
		}
		
	}

}
