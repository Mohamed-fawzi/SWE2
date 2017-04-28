package fizo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fizo.entities.Game;
import fizo.entities.Question;
import fizo.repos.GameRepo;

@Service
@Transactional
public class GameService {
	@Autowired
	private final GameRepo gameRepo;
	@Autowired
	private QuestoinService questionService;
	
	public GameService(GameRepo gameRepo) {
		this.gameRepo = gameRepo;
	}

	public int addGame(Game game){
			gameRepo.save(game);
			return game.getId();
		}
	public void removeGame(int id){
		gameRepo.delete(id);
	}
	public void removeGame(Game game){
		gameRepo.delete(game);
	}

	public Game getGame(int id){
		Game tmp = gameRepo.findOne(id);
		return tmp;
	}
	public String getGameName(int id){
		Game tmp = gameRepo.findOne(id);
		return tmp.getName();
	}
	public void setGameName(String name, int id){
		Game tmp = gameRepo.findOne(id);
		tmp.setName(name);
		gameRepo.save(tmp);
	}
	public void addQuestion(Question question,int id){
		Game tmp = gameRepo.findOne(id);
		questionService.addQuestion(question);
		
		List<Question> questions = tmp.getQuestions();
		questions.add(questionService.getQuestion(question.getId()));
		gameRepo.save(tmp);
	}
	public List<Question> getQuestions(int id){
		Game tmp = gameRepo.findOne(id);
		return tmp.getQuestions();
	}
	public void setQuestions(List<Question>list, int id){
		Game tmp = gameRepo.findOne(id);
		tmp.setQuestions(list);
		gameRepo.save(tmp);
	}
	public void setGameDescrition(String desc,int id){
		Game tmp = gameRepo.findOne(id);
		tmp.setDescription(desc);
		gameRepo.save(tmp);
	}
	public String getGameDescription(int id){
		Game tmp = gameRepo.findOne(id);
		return tmp.getDescription();
	}
	public Question getQuestion(int gameid, int questoinid){
		Game tmp = gameRepo.findOne(gameid);
		List<Question> questions= tmp.getQuestions();
		for (Question question : questions) {
			if(question.getId() == questoinid) return question;
		}
		return null;
	}
	public void removeQuestion(int gameid,int questionid){
		Game tmp = gameRepo.findOne(gameid);
		Question question = questionService.getQuestion(questionid);
		List<Question> questions= tmp.getQuestions();
		questions.remove(question);
		questionService.removeQuestion(questionid);
		tmp.setQuestions(questions);
		gameRepo.save(tmp);
	}
}
