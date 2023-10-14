package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/edit")
public class edit extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<link rel='stylesheet' href='css/bootstrap.css'>");
		out.println("<script src=\"js/bootstrap.bundle.min.js\"></script>");
		out.print("<nav class=\"navbar navbar-expand-lg navbar-light bg-success\">\r\n"
				+ "    <div class=\"container-fluid\">\r\n"
				+ "      <button type=\"button\" class=\"btn btn-info\">\r\n"
				+ "      <a class=\"navbar-brand\" href=\"#\" style=\"color:crimson\">EDIT-HERE</a></button>\r\n"
				+ "      \r\n"
				+ "     \r\n"
				+ "    </div>\r\n"
				+ "  </nav>");
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/remainder","root","siba@123");
			String q="select name,work,completed,date,address,phone,email,days from time1 where id=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, id);
		ResultSet r=ps.executeQuery();
		
		if(r.next()) {
			out.print("<form  action='update?id="+id+"'method='post'>");
			out.print("<table class='table table-success table-striped container'>");
			out.print("<tr>");
			out.print("<td class=\"form-label\">username</td>");
			out.print("<td><input class=\"form-control\" type='text'name='username'value='"+r.getString(1)+"'></td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td class=\"form-label\">work</td>");
			out.print("<td><input class=\"form-control\" type='text'name='work'value='"+r.getString(2)+"'></td>");
			out.print("</tr>");
			out.print("<tr class=\"form-label\">");
			out.print("<td>completed</td>");
			out.print("<td><input class=\"form-control\" type='text'name='completed'value='"+r.getString(3)+"'></td>");
			out.print("</tr>");
			out.print("</tr>");
			out.print("<tr class=\"form-label\">");
			out.print("<td>date</td>");
			out.print("<td><input class=\"form-control\" type='text'name='date'value='"+r.getString(4)+"'></td>");
			out.print("</tr>");
			out.print("</tr>");
			out.print("<tr class=\"form-label\">");
			out.print("<td>address</td>");
			out.print("<td><input class=\"form-control\" type='text'name='address'value='"+r.getString(5)+"'></td>");
			out.print("</tr>");
			out.print("</tr>");
			out.print("<tr class=\"form-label\">");
			out.print("<td>phone</td>");
			out.print("<td><input class=\"form-control\" type='text'name='phone'value='"+r.getString(6)+"'></td>");
			out.print("</tr>");
			out.print("</tr>");
			out.print("<tr class=\"form-label\">");
			out.print("<td>email</td>");
			out.print("<td><input class=\"form-control\" type='text'name='email'value='"+r.getString(7)+"'></td>");
			out.print("</tr>");
			out.print("</tr>");
			out.print("<tr class=\"form-label\">");
			out.print("<td>days</td>");
			out.print("<td><input class=\"form-control\" type='text'name='days'value='"+r.getString(8)+"'></td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td><input class=\"btn btn-primary mb-3\" type='submit'value='update'></td>");
			out.print("<td><input class=\"btn btn-danger mb-3\" type='reset'value='cancel'></td>");
			out.print("</tr>");
			out.print("</table>");
			
			out.print("</form>");
			
		}
			
		}
		catch(Exception e) {
		out.println(e);
		}
	       
	}

}
