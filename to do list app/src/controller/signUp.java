package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.userDao;
import model.user;


@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public signUp() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/Signup.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		LocalDate date=LocalDate.now();
		user user=new user();
		user.setName(name);
		user.setEmail(username);
		user.setPassword(password);
		userDao userdao= new userDao();
		int checkUser=userdao.signup(user);
		if(checkUser!=0) {
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			request.setAttribute("message", "registration successful");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/Signup.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("message", "check your credential");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/Signup.jsp");
			rd.forward(request, response);
		}
	}

}
