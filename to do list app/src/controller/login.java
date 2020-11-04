package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import model.user;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/SignIn.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("username");
		System.out.println(email);
		String pass=request.getParameter("password");
		System.out.println(pass);
		user user = new user();
		user.setEmail(email);
		user.setPassword(pass);
		userDao userdao = new userDao();
		boolean validateUser = userdao.loginUser(user);
		if(validateUser) {
			System.out.print("valid");
			response.sendRedirect("newTodo");
		}else
		{
			System.out.print("in-valid");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/SignIn.jsp");
			rd.forward(request, response);
		}
	}

}
