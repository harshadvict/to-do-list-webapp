package dao;

import java.sql.SQLException;
import java.util.List;

import model.ToDo;


public interface todoInterface {
	void inserttodo(ToDo todo) throws SQLException;
	List<ToDo> selectAlltodo();
	boolean deletetodo(int id) throws SQLException;
	boolean updatetodo(ToDo todo) throws SQLException,Exception;
}
