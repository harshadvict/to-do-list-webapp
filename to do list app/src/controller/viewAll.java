package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.todoDao;
import model.ToDo;


@WebServlet("/viewAll")
public class viewAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public viewAll() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("view all blog");
		System.out.print("getting all blog post");
		todoDao tododao=new todoDao();
		List<ToDo> list=tododao.selectAlltodo();
		for(ToDo list1:list) {
			System.out.println(list1.getDescription());
			System.out.println(list1.getTitle());
			System.out.println(list1.getAddedOn());
			System.out.println(list1.getLastDate());
			System.out.println(list1.getId());
		}
		request.setAttribute("list", list);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/ToDoListView.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
