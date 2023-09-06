package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewEmployee extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	   throws IOException,ServletException {
		ArrayList<EmployeeBean> al=new RetrieveDAO().retrieve();
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		if(al.size()==0) {
			pw.println("Employee Table has no any data...<br> ");
			pw.println("Please add employee data...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("employee.html");
			rd.include(req, res);
		}
		else {
			Iterator<EmployeeBean> it=al.iterator();
			while(it.hasNext()) {
				EmployeeBean eb=(EmployeeBean)it.next();
				pw.println(eb.getId()+"&nbsp&nbsp"+eb.getName()+"&nbsp&nbsp"+eb.getDesg()
				+"&nbsp&nbsp"+eb.getBsal()+"&nbsp&nbsp"+eb.getMailId()+"&nbsp&nbsp"+
						eb.getPhone()+"&nbsp&nbsp"+eb.gettotSal()+"<br>");
			}
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
		}
	}

}
