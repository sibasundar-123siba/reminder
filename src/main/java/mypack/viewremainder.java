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
@WebServlet("/remainder")
public class viewremainder extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<link rel='stylesheet' href='css/bootstrap.css'>");
		out.println("<script src=\"js/bootstrap.bundle.min.js\"></script>");
		out.print("  <nav class=\"navbar navbar-expand-lg navbar-light bg-primary\">\r\n"
				+ "    <div class=\"container-fluid\">\r\n"
				+ "      <a class=\"navbar-brand\" href=\"#\" style=\"color:crimson\">Remainder-list</a>\r\n"
				+ "      \r\n"
				+ "      <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
				+ "        <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n"
				+ "          <li class=\"nav-item\">\r\n"
				+ "            <li class=\"nav-item px-4\">\r\n"
				+ "              <button type=\"button\" class=\"btn btn-info\">\r\n"
				+ "                <a class=\"nav-link active\" href=\"index.jsp\">Set Remainder</a></button>\r\n"
				+ "            </li>\r\n"
				+ "          \r\n"
				+ "          \r\n"
				+ "          \r\n"
				+ "        </ul>\r\n"
				+ "        \r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "  </nav>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/remainder","root","siba@123");
			String q="select * from time1";
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet p= ps.executeQuery();
			out.print("<table class=\"table table-dark table-striped container\">");
			out.print("<tr>");
			out.print("<th>id</th>");
			out.print("<th>name</th>");
			out.print("<th>work</th>");
			out.print("<th>completed</th>");
			out.print("<th>date</th>");
			out.print("<th>address</th>");
			out.print("<th>phone</th>");
			out.print("<th>email</th>");
			out.print("<th>days</th>");
			out.print("<th>EDIT</th>");
			out.print("<th>DELETE</th>");
			out.print("</tr>");
			while(p.next()) {
				out.print("<tr>");
				out.print("<td>"+p.getInt(1)+"</td>");
				out.print("<td>"+p.getString(2)+"</td>");
				out.print("<td>"+p.getString(3)+"</td>");
				out.print("<td>"+p.getString(4)+"</td>");
				out.print("<td>"+p.getString(5)+"</td>");
				out.print("<td>"+p.getString(6)+"</td>");
				out.print("<td>"+p.getString(7)+"</td>");
				out.print("<td>"+p.getString(8)+"</td>");
				out.print("<td>"+p.getString(9)+"</td>");
				out.print("<td><button type=\"button\" class=\"btn btn-primary \"><a style='text-decoration:none;color:white;' href='edit?id="+p.getInt(1)+"'>edit</a></button></td>");
				out.print("<td>  <button type=\"button\" class=\"btn btn-danger \"><a style='text-decoration:none;color:white;' href='delete?id="+p.getInt(1)+"'>delete</a></button></td>");
				
				out.print("</tr>");
			}
			out.print("</table>");
			
		}
		catch(Exception e) {
		out.println(e);
		}
	       
	}

}
