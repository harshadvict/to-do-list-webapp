package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.todoDao;
import model.ToDo;



@WebServlet("/newTodo")
public class newTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public newTodo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getting into add new todo");
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/ToDoListView.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entering do blog");
		String Title=request.getParameter("title");
		String lastdate=request.getParameter("lastdate");
		LocalDate ldate=LocalDate.parse(lastdate);
		String status=request.getParameter("status");
		String description=request.getParameter("description");
		LocalDate addedOn=LocalDate.now();
		ToDo todo=new ToDo();
		
		todo.setTitle(Title);
		todo.setLastDate(ldate);
		todo.setDescription(description);
		todo.setTodoStatus(status);
		todo.setAddedOn(addedOn);
		todoDao tododao=new todoDao();
		try {
			tododao.inserttodo(todo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("viewAll");
	}

}
