package operations;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.Util;

import AllDetails.SubjectDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/subject")
public class CreateSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("add-subject.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("Name");
		String code = request.getParameter("code");
		String teacher = request.getParameter("teacher");
		
		try {
			SessionFactory factory = Util.buildConnection();
			
			Session session = factory.openSession();
			
			SubjectDetails subjectdetails = new SubjectDetails(name, code, teacher);
			
			Transaction tx = session.beginTransaction();
			
			session.save(subjectdetails);
			
			tx.commit();
			
			if(session != null) {
				out.println("<div align='center'><h2 style='color:green'>SUBJECT ADDED SUCCESSFULLY!</h2>"
						+ "<a href='admin-page.html'>RETURN To MainMenu</a>"
						+ "</div>");
			}
			session.close();
		} catch (Exception e) {
			out.println("<div align='center'><h2 style='color:red'>TRY AGAIN! OPERATION FAILED...</h2>"
					+ "<a href='admin-page.html'>RETURN To MainMenu</a>"
					+ "</div>");
		}
	}

}