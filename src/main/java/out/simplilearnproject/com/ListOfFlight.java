package out.simplilearnproject.com;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@WebServlet("/list")
public class ListOfFlight extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Getting the parameters
		String to=req.getParameter("to");
		String from=req.getParameter("from");
		String passengers=req.getParameter("number");
		
		//Storing details in the session with the use of HTTP Session
		HttpSession s=req.getSession();
		s.setAttribute("to", to);
		s.setAttribute("from", from);
		
		//writer object
		PrintWriter out=resp.getWriter();
		
		//To write html
		resp.setContentType("text/html");
		
		//open session
		SessionFactory factory=HibernateUtil.method();
		Session session=factory.openSession();
		//Setting the query
		Query query=  session.createQuery("from AdminAddData where Source= :Source and destination=:destination");
		query.setParameter("Source", from);
		query.setParameter("destination", to);
		
		//Printing
		LocalDate d= LocalDate.now();
		
		 out.print("<b>Available Flights On -></b>  "+d+"<br><br>");
		
		//Storing Local Date in the HttpSession to get it further
		s.setAttribute("date", d);
		
		//Executing the query and getting all the available flights
	    List<AdminAddData> ref=query.list();
		for(AdminAddData ref1:ref)
		{
			
			out.print("<b>Arrival Time is: </b>"+ ref1.getArrivaltime()+"<br>");
			out.print("<b>Destination Time is: </b>"+ref1.getDestinationtime()+"<br>");
			out.print("<b>Price is: </b>"+ref1.getPrice()+"<br>");
		    out.print("<form action='userpersonaldetail.jsp'>");
		    out.print("<input type='hidden' name='val' value='"+ref1.getPrice()+"'>");
		    out.print("<input type='submit' value='Book'>");
		    out.print("</form>");
		    out.print("<br>");
		
			
		}
	}

}
