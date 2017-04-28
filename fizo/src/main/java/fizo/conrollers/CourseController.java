package fizo.conrollers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fizo.entities.Course;
import fizo.services.CouserService;

@Controller
public class CourseController {
	@Autowired
	private CouserService courseService;
	@Autowired
	private AccessController accessController;
	
	@GetMapping("/add-course")
	public String addCourse(HttpServletRequest request){
		if(accessController.getLogged() == false || accessController.getType().equals("Student"))
			return "redirect";
		else{
			
			return "addCourse";
		}
	}
	@PostMapping("/save-course")
	public String addCourse2(HttpServletRequest request){
		if(accessController.getLogged() == false || accessController.getType().equals("Student")){
			request.setAttribute("mode","MODE_INDEX");
			return "redirect";
		}
		String Name= request.getParameter("name");
		String desc = request.getParameter("desc");
		Course tmp =new Course();
		tmp.setName(Name);
		tmp.setDescription(desc);
		
		courseService.addCourse(tmp);
		request.setAttribute("mode","MODE_SHOWCOURSES");
		return "redirect";
		
	}
	@GetMapping("/show-courses")
	public String Allcourses(HttpServletRequest request){
		List <Course> list=courseService.getAllCourses();
		request.setAttribute("courses", list);
		request.setAttribute("logged", accessController.getLogged());
		request.setAttribute("type", accessController.getType());
		return "showcourses";
	}
	@GetMapping("/delete-course")
	public String deleteCourse(@RequestParam int id, HttpServletRequest request ){
		
		courseService.removeCourse(id);
		
		request.setAttribute("mode","MODE_SHOWCOURSES");
		return "redirect"; 
	}

}
