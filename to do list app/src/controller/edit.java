package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.todoDao;
import model.ToDo;


@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public int id;
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/Edit.jsp");
		rd.forward(request, response);
		
	}
	public void editView(HttpServletRequest request, HttpServletRequest response) throws ServletException, IOException{
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String todostatus=request.getParameter("status");
		String lastdate=request.getParameter("lastdate");
		LocalDate ldate=LocalDate.parse(lastdate);
		LocalDate date=LocalDate.now();
		todoDao tododao=new todoDao();
		ToDo Todo=new ToDo();
		Todo.setId(Integer.toString(id));
		Todo.setTitle(title);
		Todo.setDescription(description);
		Todo.setAddedOn(date);
		Todo.setLastDate(ldate);
		Todo.setTodoStatus(todostatus);
		try {
			tododao.updatetodo(Todo);
			response.sendRedirect("viewAll");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
