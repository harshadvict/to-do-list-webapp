package model;

import java.time.LocalDate;

public class ToDo {
	private String id;
	
	private String title;
	private LocalDate LastDate;
	private String TodoStatus;
	private String description;
	private LocalDate addedOn;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getLastDate() {
		return LastDate;
	}
	public void setLastDate(LocalDate lastDate) {
		LastDate = lastDate;
	}
	public LocalDate getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(LocalDate addedOn) {
		this.addedOn = addedOn;
	}
	public String getTodoStatus() {
		return TodoStatus;
	}
	public void setTodoStatus(String todoStatus) {
		TodoStatus = todoStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
