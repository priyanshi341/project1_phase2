package out.simplilearnproject.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/add")
public class AddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		//getting data from adminadddatabbase.html
		String nameofflight=req.getParameter("nameofflight");
		String destination=req.getParameter("destination");
		String source=req.getParameter("source");
		String destinationtime=req.getParameter("destinationtime");
		String arrivaltime=req.getParameter("arrivaltime");
		String price=req.getParameter("price");
		
		AdminAddData ref=new AdminAddData(nameofflight, source, destination,  Time.valueOf(destinationtime),  Time.valueOf(arrivaltime),
				new BigDecimal(price));
		
		SessionFactory factory=HibernateUtil.method();
		Session session=factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(ref);
        tx.commit();
        out.print("Changes successfully done");
		session.close();
	}

}
