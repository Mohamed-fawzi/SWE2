package fizo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fizo.entities.Question;



@Entity
public class Game implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String Name;
	private String Description;
	private int NumOfQuestions;
	@Column
	@ElementCollection(targetClass=Question.class)
	private List<Question> Questions = new ArrayList<Question>();
	public Game(){
	}
	public Game(String name, String description, int numOfQuestions, List<Question> questions) {
		super();
		Name = name;
		Description = description;
		NumOfQuestions = numOfQuestions;
		Questions = questions;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getNumOfQuestions() {
		return NumOfQuestions;
	}
	public void setNumOfQuestions(int numOfQuestions) {
		NumOfQuestions = numOfQuestions;
	}
	public List<Question> getQuestions() {
		return Questions;
	}
	public void setQuestions(List<Question> questions) {
		Questions = questions;
	}
	
	
	
}
