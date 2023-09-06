package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class Logout extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	   throws IOException,ServletException {
	  Cookie c[]=req.getCookies();
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  if(c==null) {
		  pw.println("Session expired... Please Login...<br>");
	  }
	  else {
		  c[0].setMaxAge(10);
		  pw.println("Admin Logged Out Successfully...<br>");
	  }
	  RequestDispatcher rd=req.getRequestDispatcher("login.html");
	  rd.include(req, res);
	}
	

}
