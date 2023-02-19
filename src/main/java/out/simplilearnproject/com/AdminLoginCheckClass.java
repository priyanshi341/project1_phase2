package out.simplilearnproject.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/click")
public class AdminLoginCheckClass extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//writer object
			PrintWriter out=resp.getWriter();
			//
			resp.setContentType("text/html");
			
			//open session
			SessionFactory factory=HibernateUtil.method();
			Session session=factory.openSession();
			
			//get the data from changepassword.html file
			String userid=req.getParameter("uid");
			String password=req.getParameter("pass");
			
		  List<AdminTable> ref=session.createQuery("from AdminTable").list();
			for(AdminTable ref1:ref)
			{
				if(userid.equals(ref1.getUid()))
				{
					if(password.equals(ref1.getPassword()))
					{
						out.print("<form action='admindashboard.html'>");
						out.print("<input type='submit' value='Go'>");
						out.print("</form>");
					}
				}
				else
				{
					out.print("wrong details");
				}
			}
		
	}
}
