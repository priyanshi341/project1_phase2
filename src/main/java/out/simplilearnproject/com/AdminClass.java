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

@WebServlet("/change")
public class AdminClass extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//writer object
		PrintWriter out=resp.getWriter();
		
		//open session
		SessionFactory factory=HibernateUtil.method();
		Session session=factory.openSession();
		
		//get the data from changepassword.html file
		String oldpassword=req.getParameter("oldpass");
		String newpassword=req.getParameter("newpass");
		String confirmpassword=req.getParameter("confirmpass");
		String check=null;
	  List<AdminTable> ref=session.createQuery("from AdminTable").list();
		for(AdminTable ref1:ref)
		{
			if(ref1.getPassword().equals(oldpassword))
			{
				if(newpassword.equals(confirmpassword))
				{
					Transaction tx = session.beginTransaction();
					
					AdminTable newref=session.get(AdminTable.class, ref1.getAid());
	                newref.setPassword(confirmpassword);
			        session.update(newref);
			        tx.commit();
			        out.print("Changes successfully done");
					session.close();
				}
				else
				{
					out.print("new password doenot match with the confirmpassword");
				}
			}
			else
			{
				out.print("old password is not correct");
			}
			
		}
	

	}

}
