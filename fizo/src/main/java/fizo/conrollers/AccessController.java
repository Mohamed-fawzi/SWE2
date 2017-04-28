package fizo.conrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fizo.entities.Student;
import fizo.entities.Teacher;
import fizo.services.StudentService;
import fizo.services.TeacherService;

@Controller
public class AccessController {
	private  Boolean Logged;
	private String Type;
	private int Id;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	public AccessController() {
		Logged=false;
		Type = "Student";
		Id=0;
	}
	
	public Boolean getLogged() {
		return Logged;
	}
	public void setLogged(Boolean logged) {
		Logged = logged;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	@GetMapping("/sign-in")
	public String signin(HttpServletRequest request){
		if (Logged == true) return "redirect";
		request.setAttribute("logged", Logged);
		request.setAttribute("type", Type);
		request.setAttribute("id", Id);
		return "signin";
	}
	
	@PostMapping("/sign-in")
	public String signin2(HttpServletRequest request){
		
		String Name= request.getParameter("Name");
		String pass = request.getParameter("password");
		 Type= request.getParameter("Type");
		 request.setAttribute("mode","MODE_INDEX");
		
		if(Type.equals("Student")){
			if(studentService.Login(Name, pass)){
				Logged=true;
				Type="Student";
				Id=studentService.Exist(Name);
				return "redirect";
			}
		}else {
			if(teacherService.Login(Name, pass)){
				Logged=true;
				Type="Teacher";
				Id=studentService.Exist(Name);
				return "redirect";
			}
		}
		
		return "signin";
	}
	
	@GetMapping("/sign-out")
	public String signout(HttpServletRequest request){
		Logged=false;
		request.setAttribute("logged", Logged);
		request.setAttribute("type", Type);
		request.setAttribute("id", Id);
		return "index";
	}
	@GetMapping("/sign-up")
	public String signup(HttpServletRequest request){
		request.setAttribute("mode","MODE_VALID");
		return "signup";
	}
	@PostMapping("/sign-up")
	public String signup2(HttpServletRequest request){
		String Name = request.getParameter("Name");
		String UserName = request.getParameter("UserName");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		String Type = request.getParameter("Type");
		 if (Type.equals("Student")){
			 if(studentService.Exist(UserName) ==-1){
				 studentService.addStudent(new Student(UserName,Password,Name,Email,0));
				 Logged=true;
				 Type="Student";
				 Id=studentService.Exist(UserName) ;
				 request.setAttribute("mode","MODE_INDEX");
				 return "redirect";
			 }else{
				 request.setAttribute("mode","MODE_NOT_VALID");
				 return "signup";
			 }
		 }else{
			 if(teacherService.Exist(UserName) ==-1){
				 teacherService.addTeacher(new Teacher(UserName,Password,Name,Email));
				 Logged=true;
				 Type="Teacher";
				 Id=studentService.Exist(UserName) ;
				 request.setAttribute("mode","MODE_INDEX");
				 return "redirect";
			 }else{
				 request.setAttribute("mode","MODE_NOT_VALID");
				 return "signup";
			 }
		 }
		
	}
}
