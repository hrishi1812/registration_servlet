package registration_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/log")
public class LogInController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		UserCRUD userCRUD=new UserCRUD();
		
		try {
//			PrintWriter out=res.getWriter();
		String dbPassword=	userCRUD.logIn(email);
		if(dbPassword!=null) {
			if(password.equals(dbPassword)) {
//				out.print("Login Sucess");
//				RequestDispatcher dispatcher=req.getRequestDispatcher("success.html");
//				dispatcher.forward(req, res);
				res.sendRedirect("success.html");
			}else {
//				out.print("Invalid Password");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
				dispatcher.forward(req, res);
				
			}
			
		}else {
//			out.print("User Not Register   "+email);
			RequestDispatcher dispatcher=req.getRequestDispatcher("signup.html");
			dispatcher.forward(req, res);
		}
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
	}
	

}
