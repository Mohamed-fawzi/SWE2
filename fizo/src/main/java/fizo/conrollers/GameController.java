package fizo.conrollers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fizo.entities.Game;
import fizo.entities.Question;
import fizo.services.CouserService;
import fizo.services.GameService;

@Controller
public class GameController {
	@Autowired
	private CouserService courseService;
	@Autowired
	private GameService gameService;
	@Autowired	
	private AccessController accessController;
	
	@GetMapping("/show-games")
	public String courseGame(@RequestParam int id,HttpServletRequest request){
		if(accessController.getLogged() == false || accessController.getType().equals("Student")){
			request.setAttribute("mode","MODE_INDEX");
			return "redirect";
		}
		
		List<Game> games = courseService.getGames(id);
		request.setAttribute("list", games);
		request.setAttribute("courseid", id);
		request.setAttribute("logged", accessController.getLogged());
		request.setAttribute("type", accessController.getType());
		return "coursegames";
	}
	
	
	@GetMapping("/add-game")
	public String addgame(@RequestParam int id , HttpServletRequest request){
		if(accessController.getLogged() == false || accessController.getType().equals("Student")){
			request.setAttribute("mode","MODE_INDEX");
			return "redirect";
		}
		request.setAttribute("classid", id);
		request.setAttribute("logged", accessController.getLogged());
		request.setAttribute("type", accessController.getType());
		
		return "addgame";
	}
	@PostMapping("/add-game")
	public String addgame2( HttpServletRequest request){
		if(accessController.getLogged() == false || accessController.getType().equals("Student")){
			request.setAttribute("mode","MODE_INDEX");
			return "redirect";
		}
		String Name = request.getParameter("name");
		int Courseid =Integer.parseInt( request.getParameter("courseid"));
		String description =request.getParameter("desc");
		Game tmp =new Game();
		tmp.setName(Name);
		tmp.setDescription(description);
		courseService.addGame( tmp, Courseid);
		
		request.setAttribute("logged", accessController.getLogged());
		request.setAttribute("type", accessController.getType());

		request.setAttribute("mode","MODE_SHOWCOURSES");
		return "redirect";
	
	}
	@GetMapping("/delete-game")
	public String deleteGame(@RequestParam int  gameid ,@RequestParam int courseid,HttpServletRequest request){
		courseService.removeGame(courseid, gameid);
		request.setAttribute("mode","MODE_INDEX");
		return "redirect";
	}
	@GetMapping("/play-game")
	public  String playGame(@RequestParam int  gameid ,HttpServletRequest request){
		List<Question> questions = gameService.getQuestions(gameid);
		request.setAttribute("questions", questions);
		request.setAttribute("numOfQuestions", questions.size());
		request.setAttribute("gameid", gameid);
		return "playGame";
	}
	@PostMapping("/score")
	public String Score(HttpServletRequest request){
		int gameid=Integer.parseInt(request.getParameter("gameid"));
		List<Question> questions = gameService.getQuestions(gameid);
		List<String>answers = new ArrayList<>();
		for (Question question : questions ) {
			answers.add(request.getParameter(question.getQuestion()));
			
		}
		int score = 0 ;
		for (int i = 0; i < questions.size(); i++) {
			if(answers.get(i).equals(questions.get(i).getCorrectAnswer())){ //checks if it a correct answer
				score++;
			}else{
				score --;
			}
		}
		request.setAttribute("score", score);
		return "Score";
	}
}
