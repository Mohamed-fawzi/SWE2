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
@Entity
public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String Question;
	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> Answers;
	private String CorrectAnswer;
	private String GameType;
	public Question (){
		Answers = new ArrayList<String>();
	}
	public Question(String question, List<String> answers, String correctAnswer , String gameType) {
		super();
		GameType= gameType;
		Question = question;
		Answers = answers;
		CorrectAnswer = correctAnswer;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public List<String> getAnswers() {
		return Answers;
	}
	public void setAnswers(List<String> answers) {
		Answers = answers;
	}
	public String getCorrectAnswer() {
		return CorrectAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		CorrectAnswer = correctAnswer;
	}
	public String getGameType() {
		return GameType;
	}
	public void setGameType(String gameType) {
		GameType = gameType;
	}
	
	
}
