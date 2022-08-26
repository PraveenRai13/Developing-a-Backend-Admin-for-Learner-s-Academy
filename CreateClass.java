package operations;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.Util;

import AllDetails.ClassDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/class")
public class CreateClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("add-class.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("Name");
		String section = request.getParameter("section");
		String roomNo = request.getParameter("roomno");
		
		try {
			SessionFactory factory = Util.buildConnection();
			
			Session session = factory.openSession();
			
			ClassDetails classdetails = new ClassDetails(name, section, roomNo);
			
			Transaction tx = session.beginTransaction();
			
			session.save(classdetails);
			
			tx.commit();
			
			if(session != null) {
				out.println("<div align='center'><h2 style='color:green'>CLASS ADDED SUCCESSFULLY!</h2>"
						+ "<a href='admin-page.html'>RETURN TO MainMenu</a>"
						+ "</div>");
			}
			session.close();
		} catch (Exception e) {
			out.println("<div align='center'><h2 style='color:red'>TRY AGAIN! OPERATION FAILED...</h2>"
					+ "<a href='admin-page.html'>RETURN TO MainMenu</a>"
					+ "</div>");
		}
	}

}
