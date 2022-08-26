package operations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.Util;

import AllDetails.ClassDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listclasses")
public class ShowClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			SessionFactory factory = Util.buildConnection();
			
			Session session = factory.openSession();
			
			List<ClassDetails> list = session.createQuery("from ClassDetails").list();
			
			out.println("<h2>LIST OF CLASSES");
			
			out.println("<style> table,td,th{"
					+ "border:2px solid red; "
					+ "padding:2px;); "
					+ "</style>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>S.No</th>");
			out.println("<th>Class Name</th>");
			out.println("<th>Section</th>");
			out.println("<th>Room No</th>");
			out.println("<tr>");
			
			for(ClassDetails classdet : list) {
				out.println("<tr>");
				out.println("<td>"+ classdet.getId() +"</td>");
				out.println("<td>"+ classdet.getClassName() +"</td>");
				out.println("<td>"+ classdet.getClassSection()+"</td>");
				out.println("<td>"+ classdet.getClassRoomNo() +"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<a href='admin-page.html'>RETURN To MainMenu!</a>");
			session.close();
		} catch (Exception e) {
			out.println("<h2 style='color:red'>TRY AGAIN! OPERATION FAILED...<h2>");
			out.println("<a href='admin-page.html'>RETURN To MainMenu!</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
