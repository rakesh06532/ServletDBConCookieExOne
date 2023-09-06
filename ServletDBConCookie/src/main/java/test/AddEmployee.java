package test;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import javax.servlet.*;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddEmployee extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	   throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		if(c==null) {
			pw.println("Session expired... Please Login again");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else {
			String fname=c[0].getValue();
			EmployeeBean eb=new EmployeeBean();
			eb.setId(req.getParameter("empid"));
			eb.setName(req.getParameter("empname"));
			eb.setDesg(req.getParameter("empdesg"));
			eb.setBsal(Integer.parseInt(req.getParameter("empbsal")));
			eb.setMailId(req.getParameter("empmail"));
			eb.setPhone(Long.parseLong(req.getParameter("empphone")));
			int Bsal=Integer.parseInt(req.getParameter("empbsal"));
			float totSal=Bsal+(0.82f*Bsal)+(0.62f*Bsal);
			eb.settotSal(totSal);
			
			int k=new InsertDAO().insert(eb);
			if(k>0) {
				pw.println("Admin name: "+fname+"<br>");
				pw.println("Employee added successfully...<br>");
				RequestDispatcher rd=req.getRequestDispatcher("link.html");
				rd.include(req, res);
			}
			else {
				pw.println("Please give valid Information...<br>");
				pw.println("Make sure Employee Id should be unique...<br>");
				RequestDispatcher rd=req.getRequestDispatcher("link.html");
				rd.include(req, res);
			}
		}
	}

}
