package servletRagistration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

/**
 * Servlet implementation class regForm
 */
@WebServlet("/regform")
public class regForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

response.setContentType("text/html"); 	
 PrintWriter out=response.getWriter();

String name=request.getParameter("name");
String email=request.getParameter("email");

String gender=request.getParameter("Gender");
String password=request.getParameter("password");

	
	out.println("name is "+name+"<br>");
	out.println("email is"+email+"<br>");
	out.println("gender is"+gender+"<br>");
	out.println("password is"+password+"<br>");
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajstyle","root","root");
		if(con!=null) {
			PreparedStatement stmt=con.prepareStatement("insert into ragiform values('0',?,?,?,?)");
			stmt.setString(1,name);
			stmt.setString(2, email);
			stmt.setString(3, gender);
			stmt.setString(4, password);
			int value=stmt.executeUpdate();
			if(value>0) {
				out.println("save the successfully");
			}else {
				out.println("not save sucessfully");
			}
		} else {
			out.println("not connected");
		}
	}catch(Exception ex) {
		out.println("Error is"+ex);
			
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
