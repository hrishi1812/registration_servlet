package registration_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/reg")
public class SignUpController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long phone=Long.parseLong(req.getParameter("phone"));
		int age=Integer.parseInt(req.getParameter("age"));
		String fatherName=req.getParameter("FatherName");
		String motherName=req.getParameter("MotherName");
		String email=req.getParameter("email");
        String password=req.getParameter("password");

		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		user.setMotherNmae(motherName);
		user.setAge(age);user.setFatherName(fatherName);
		user.setEmail(email);
		user.setPassword(password);
		UserCRUD userCRUD=new UserCRUD();
		try {
			PrintWriter out=res.getWriter();
			int count=userCRUD.signUp(user);
			if(count!=0) {
				out.print("Sign Up Succes");
			}else {
				out.print("Sign Up Failed");
			}
		} catch (Throwable e) {
			
			e.printStackTrace();
		}

	}
	

}
