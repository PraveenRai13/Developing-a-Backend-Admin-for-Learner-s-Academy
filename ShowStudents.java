package operations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.Util;

import AllDetails.StudentDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/liststudents")
public class ShowStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			SessionFactory factory = Util.buildConnection();
			
			Session session = factory.openSession();
			
			List<StudentDetails> list = session.createQuery("from StudentDetails").list();
			
			out.println("<h2>LIST OF STUDENTS");
			
			out.println("<style> table,td,th{"
					+ "border:2px solid red; "
					+ "padding:2px;); "
					+ "</style>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>S.No</th>");
			out.println("<th>Student Name</th>");
			out.println("<th>Student RollNo</th>");
			out.println("<th>Student Class</th>");
			out.println("<tr>");
			
			for(StudentDetails stdet : list) {
				out.println("<tr>");
				out.println("<td>"+ stdet.getId() +"</td>");
				out.println("<td>"+ stdet.getName() +"</td>");
				out.println("<td>"+ stdet.getRollNo() +"</td>");
				out.println("<td>"+ stdet.getStudentClass() +"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<a href='admin-page.html'>Back To MainMenu</a>");
			session.close();
		} catch (Exception e) {
			out.println("<h2 style='color:red'>Operation Failed<h2>");
			out.println("<a href='admin-page.html'>Back To MainMenu</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
