package out.simplilearnproject.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/user")
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		resp.setContentType("text/html");
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String date=req.getParameter("date");
		String address=req.getParameter("address");
		String mobilenumber=req.getParameter("mobile");
		LocalDate d=LocalDate.parse(date);
		
		UserData ref=new UserData(name,age,d,address,mobilenumber);
		
		
		//open session
				SessionFactory factory=HibernateUtil.method();
				Session session=factory.openSession();
				
				Transaction tx = session.beginTransaction();
				
				session.save(ref);
		        tx.commit();
		       
		        out.print("<b>Changes successfully done </b><br><br>");
		        HttpSession s=req.getSession();
				s.setAttribute("ref", ref.getId());
		        out.print("<form action='payment.html'>");
		        out.print("<input type='submit' value='Payment Gateway'>");
		        out.print("</form>");
				session.close();
	}

}
