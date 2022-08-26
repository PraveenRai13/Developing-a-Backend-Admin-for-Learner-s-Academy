package operations;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.Util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/init")
public class InitializeConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.jsp").include(request, response);
		
		try {
			SessionFactory factory = Util.buildConnection();
			Session session = factory.openSession();
			
			if(session != null) {
				out.println("<div align='center'><h2 style='color:green'>CONNECTED SUCCESSFULLY</h2></div>");
			}
			session.close();
		} catch (Exception e) {
				out.println("<div align='center'><h2 style='color:red'>UNABLE TO CONNECT!</h2></div>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}