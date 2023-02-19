package out.simplilearnproject.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

@WebServlet("/fee")
public class FinalUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//writer object
				PrintWriter out=resp.getWriter();
				
				//
				resp.setContentType("text/html");
				
				//open session
				SessionFactory factory=HibernateUtil.method();
				Session session=factory.openSession();
				
				//getting data stored in session
				HttpSession d=req.getSession();
				String to=(String)d.getAttribute("to");
				String from=(String)d.getAttribute("from");
				LocalDate date=(LocalDate) d.getAttribute("date");
				long ref1=(long)d.getAttribute("ref");
				BigDecimal b=(BigDecimal)d.getAttribute("price");
				
				/*out.print("done ");
				out.print(to+" ");
				out.print(from+" ");
				out.print(date+" ");
				out.print(ref1+" ");*/
				Query query=session.createQuery("from UserData where id= :id");
				query.setParameter("id", ref1);
				
				//showing the details of booking to user
				out.print("<h3><b>Details Of  Booking</b></h3><br>");
				List<UserData>l=query.list();
				for(UserData u:l)
				{
					out.print("<b>Name: </b>"+u.getName()+"<br>");
					out.print("<b>Age: </b>"+u.getAge()+"<br>");
					out.print("<b>Mobile No.: </b>"+u.getMobilno()+"<br>");
					out.print("<b>Date Of Birth: </b>"+u.getDateofbirth()+"<br>");
					out.print("<b>Address: </b>"+u.getAddress()+"<br>");
					out.print("<b>From(Destination): </b>"+from+"<br>");
					out.print("<b>To(Source): </b>"+to+"<br>");
					out.print("<b>Date of Booking: </b>"+date+"<br>");
					out.print("<b>Price:</b>"+b);
				
				}
	}

}
