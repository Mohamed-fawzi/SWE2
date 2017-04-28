package fizo.conrollers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@Autowired
	private AccessController accessController;
	@GetMapping("/")
	public String home(HttpServletRequest request){
		
		request.setAttribute("logged", accessController.getLogged());
		request.setAttribute("type", accessController.getType());
		request.setAttribute("id", accessController.getId());
		return "index";
	}
	

	
}
 