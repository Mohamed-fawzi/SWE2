package fizo.conrollers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fizo.entities.Question;
import fizo.services.CouserService;
import fizo.services.GameService;

@Controller
public class QuestionController {
	@Autowired
	private CouserService courseService;
	@Autowired
	private GameService gameService;
	@Autowired	
	private AccessController accessController;
	
	@GetMapping("/show-Question")
	public String showGameQuestion(@RequestParam int  gameid ,@RequestParam int courseid,HttpServletRequest request){
		List<Question> questions = courseService.getGame(courseid, gameid).getQuestions();
		request.setAttribute("questions",questions);
		request.setAttribute("gameid",gameid);
		request.setAttribute("courseid",courseid);
		return "showQuestion";
	}
	
	@GetMapping("/delete-Question")
	public String deleteQuestion(@RequestParam int questoinid,@RequestParam int  gameid ,@RequestParam int courseid,HttpServletRequest request){
		gameService.removeQuestion(gameid, questoinid);
		List<Question> questions = courseService.getGame(courseid, gameid).getQuestions();
		request.setAttribute("questions",questions);
		request.setAttribute("gameid",gameid);
		request.setAttribute("courseid",courseid);
		return "showQuestion";
	}
	@GetMapping("/add-quesion")
	public String addQuestion(@RequestParam int  gameid ,@RequestParam int courseid,HttpServletRequest request){
		request.setAttribute("gameid",gameid);
		request.setAttribute("courseid",courseid);
		return "addQuetion";
	}
	@GetMapping("/add-tfquesion")
	public String addTFQuestion(@RequestParam int  gameid ,@RequestParam int courseid,HttpServletRequest request){
		request.setAttribute("gameid",gameid);
		request.setAttribute("courseid",courseid);
		return "addTFQuestion";
	}
	@GetMapping("/add-mcqquesion")
	public String addMCQQuestion(@RequestParam int  gameid ,@RequestParam int courseid,HttpServletRequest request){
		request.setAttribute("gameid",gameid);
		request.setAttribute("courseid",courseid);
		return "addMcqQestion";
	}

	@PostMapping("/save-Question")
	public String saveQuesion( HttpServletRequest request){
		if(accessController.getLogged() == false || accessController.getType().equals("Student")){
			request.setAttribute("mode","MODE_INDEX");
			return "redirect";
		}
		String Type = request.getParameter("Type");
		int Courseid =Integer.parseInt( request.getParameter("courseid"));
		int Gameid =Integer.parseInt( request.getParameter("gameid"));
		
		if(Type.equals("TF")){
		String QuesionAsName = request.getParameter("Question");
		String Answer1 = request.getParameter("Answer1");
		String Answer2 = request.getParameter("Answer2");
		String Correct = request.getParameter("Correct");
		List<String> Answers = new ArrayList<String>();
		Answers.add(Answer1);
		Answers.add(Answer2);
		gameService.addQuestion(new Question(QuesionAsName,Answers,Correct,"TF"),Gameid );
		}else{
			String QuesionAsName = request.getParameter("Question");
			String Answer1 = request.getParameter("Answer1");
			String Answer2 = request.getParameter("Answer2");
			String Answer3 = request.getParameter("Answer3");
			String Answer4 = request.getParameter("Answer4");
			
			int Correct = Integer.parseInt(request.getParameter("Correct"));
			List<String> Answers = new ArrayList<String>();
			Answers.add(Answer1);Answers.add(Answer2);Answers.add(Answer3);Answers.add(Answer4);
			
			gameService.addQuestion(new Question(QuesionAsName,Answers,Answers.get(Correct),"MCQ"),Gameid );	
		}
		request.setAttribute("logged", accessController.getLogged());
		request.setAttribute("type", accessController.getType());
		request.setAttribute("courseid",Courseid);
		request.setAttribute("mode","MODE_SHOWGAMES");
		return "redirect";
	
	}
}
