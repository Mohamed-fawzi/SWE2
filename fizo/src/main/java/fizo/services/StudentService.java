package fizo.services;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fizo.entities.Student;
import fizo.repos.StudentRepo;

@Service
@Transactional
public class StudentService {
	private final StudentRepo studentRepo;

	public StudentService(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}
	public void addStudent(Student student){
		studentRepo.save(student);
	}
	public void removeStudent(int id){
		studentRepo.delete(id);
	}
	public Boolean Login(String userName, String password){
		List <Student> list=studentRepo.Exist(userName);
		for(Student stduent :list){
			System.out.println(stduent.getName() + stduent.getPassword()+ password);
			if( stduent.getPassword().equals(password)) return true;
		}
		return false;
	}
	
	public int Exist(String userName){
		List<Student> list=studentRepo.Exist(userName);
		return (list.size()>0)? list.get(0).getId() :-1;
	}
}
