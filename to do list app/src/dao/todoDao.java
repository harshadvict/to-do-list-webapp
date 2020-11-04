package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ToDo;
import utility.ConnectionManager;

public class todoDao implements todoInterface{

	@Override
	public void inserttodo(ToDo todo) throws SQLException {
		String stmt1="insert into todolist (title,lastdate,addedOn,todostatus,description) values (?,?,?,?,?)";
		try {
			ConnectionManager con = new ConnectionManager();
			Connection conn=con.getConnection();
			PreparedStatement stmt=conn.prepareStatement(stmt1);
			stmt.setString(1,todo.getTitle());
			stmt.setDate(2,java.sql.Date.valueOf(todo.getLastDate()));
			stmt.setDate(3,java.sql.Date.valueOf(todo.getAddedOn()));
			stmt.setString(4,todo.getTodoStatus());
			stmt.setString(5,todo.getDescription());
			stmt.executeUpdate();
			System.out.println("storing the value");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public List<ToDo> selectAlltodo() {
		String stmt1="select * from todolist";
		try {
			ConnectionManager con = new ConnectionManager();
			Connection conn=con.getConnection();
			PreparedStatement stmt=conn.prepareStatement(stmt1);
			ResultSet rs=stmt.executeQuery();
			System.out.println("to get the data of to do from database");
			
			List<ToDo> list= new ArrayList<>();
			
			while(rs.next()) {
				String Id=Integer.toString(rs.getInt("id"));
				String title=rs.getString("title");
				LocalDate lastdate=rs.getDate("lastdate").toLocalDate();
				LocalDate addedOn=rs.getDate("addedon").toLocalDate();
				String status=rs.getString("todostatus");
				String description=rs.getString("description");
				ToDo todo=new ToDo();
				todo.setId(Id);
				todo.setTitle(title);
				todo.setLastDate(lastdate);
				todo.setTodoStatus(status);
				todo.setAddedOn(addedOn);
				todo.setDescription(description);
				list.add(todo);
				
			}
			return list;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public boolean deletetodo(int id) throws SQLException {
		String stmt3="delete from todolist where id=?";
		System.out.println(id);
		boolean rowdeleted;
		try {
			ConnectionManager con = new ConnectionManager();
			Connection conn=con.getConnection();
			PreparedStatement stmt=conn.prepareStatement(stmt3);
			stmt.setInt(1,id);
			rowdeleted=stmt.executeUpdate()>0;
			return rowdeleted;
			
			}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatetodo(ToDo todo) throws SQLException, Exception {
		String stmt1="update todolist set title=?,lastdate=?,addedOn=?,todostatus=?,description=? where id=?";
		try {
			ConnectionManager con = new ConnectionManager();
			Connection conn=con.getConnection();
			PreparedStatement stmt=conn.prepareStatement(stmt1);
			stmt.setString(1,todo.getTitle());
			stmt.setDate(2,java.sql.Date.valueOf(todo.getLastDate()));
			stmt.setDate(3,java.sql.Date.valueOf(todo.getAddedOn()));
			stmt.setString(4,todo.getTodoStatus());
			stmt.setString(5,todo.getDescription());
			stmt.setInt(6,Integer.parseInt(todo.getId()));
			stmt.executeUpdate();
			System.out.println("update the value");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

}
