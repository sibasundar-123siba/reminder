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
@WebServlet("/set")
public class setremainder extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String work=req.getParameter("work");
        String progress=req.getParameter("progress");
        String date=req.getParameter("date");
        String address=req.getParameter("address");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        String days=req.getParameter("day");
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/remainder","root","siba@123");
    		String q="insert into time1(name,work,completed,date,address,phone,email,days)values(?,?,?,?,?,?,?,?)";
    		PreparedStatement ps=con.prepareStatement(q);
    		ps.setString(1, name);
    		ps.setString(2, work);
    		ps.setString(3, progress);
    		ps.setString(4, date);
    		ps.setString(5, address);
    		ps.setString(6, phone);
    		ps.setString(7, email);
    		ps.setString(8, days);
    		ps.executeUpdate();
    		RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
    		rd.forward(req, resp);
        }
        catch(Exception e) {
        	out.print(e);
        }
	}

}
