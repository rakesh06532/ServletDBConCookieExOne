package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/log")
public class AdminLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	  throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String fname=new LoginDAO().login(req);
		if(fname==null) {
			pw.println("Invalid Login details...");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else {
			pw.println("Welcome Admin: "+fname+"<br>");
			Cookie ck=new Cookie("fname",fname);
			res.addCookie(ck);
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
		}
	}

}
