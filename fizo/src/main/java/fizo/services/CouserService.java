package fizo.services;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fizo.entities.Course;
import fizo.entities.Game;
import fizo.repos.CourseRepo;

@Service
@Transactional
public class CouserService implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private final CourseRepo courseRepo ;
		@Autowired
		private GameService gameService;
		
		public CouserService(CourseRepo courseRepo) {
			this.courseRepo = courseRepo;
		}
		public String getCourseName(int id){
			Course tmp =courseRepo.findOne(id);
			return tmp.getName();
		}
		public void setCourseName(String name, int id ){
			Course tmp =courseRepo.findOne(id);
			tmp.setName(name);
			courseRepo.save(tmp);
		}
		public String getCourseDescription(int id){
			Course tmp =courseRepo.findOne(id);
			return tmp.getDescription();
		}
		public void setCouresDescription(String description,int id){
			Course tmp =courseRepo.findOne(id);
			tmp.setDescription(description);
			courseRepo.save(tmp);
		}

		public List<Game> getGames(int id){
			Course tmp =courseRepo.findOne(id);
			return tmp.getGames();
		}
		
		public void setGames (List<Game> list,int id){
			Course tmp =courseRepo.findOne(id);
			tmp.setGames(list);
			courseRepo.save(tmp);
		}
		public void addGame(Game game , int id){
			Course tmp =courseRepo.findOne(id);
			gameService.addGame(game);
			List<Game> games = tmp.getGames();
			games.add(game);
			tmp.setGames(games);
			courseRepo.save(tmp);
		}
		public List<Course> getAllCourses(){
					List <Course>tmp =(List<Course>) courseRepo.findAll();
					return tmp;
		}
		public void addCourse(Course course){
			courseRepo.save(course);
		}
		public void removeCourse(int id){
			courseRepo.delete(id);
		}
		public void removeCourse(Course course){
			courseRepo.delete(course);
		}
		public void removeGame(int courseid, int gameid){
			Course tmp =courseRepo.findOne(courseid);
			List<Game> games=tmp.getGames();
			games.remove(gameid);
			gameService.removeGame(gameid);
			tmp.setGames(games);
			courseRepo.save(tmp);
			
		}
		public Game getGame(int courseid, int gameid){
			Course tmp =courseRepo.findOne(courseid);
			List<Game> games=tmp.getGames();
			for (Game game : games) {
				if(game.getId()==gameid) return game;
			}
			return null;
		}
		
}
