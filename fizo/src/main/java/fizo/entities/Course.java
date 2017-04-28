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
public class Course  implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String Name;
	private String Description;
	@Column
	@ElementCollection(targetClass=Game.class)
	private List<Game> Games=new ArrayList<Game>();
	public Course(){
		
	}
	public Course(String name, String description, List<Game> games) {
		super();
		Name = name;
		Description = description;
		Games = games;
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
	public List<Game> getGames() {
		return Games;
	}
	public void setGames(List<Game> games) {
		Games = games;
	}
	
	
	
}
