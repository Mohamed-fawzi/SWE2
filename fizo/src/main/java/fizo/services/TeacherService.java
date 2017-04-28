package fizo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fizo.entities.Teacher;
import fizo.repos.TeacherRepo;

@Service
@Transactional
public class TeacherService {
	public final TeacherRepo teacherRepo;

	public TeacherService(TeacherRepo teacherRepo) {
		this.teacherRepo = teacherRepo;
	}
	
	public void addTeacher(Teacher teacher){
		teacherRepo.save(teacher);		
	}
	
	public void removeTeacher(int id){
		teacherRepo.delete(id);
	}
	public Boolean Login(String userName, String password){
		List <Teacher> list=teacherRepo.Exist(userName);
		for(Teacher teacher :list){
			if( teacher.getPassword().equals(password)) return true;
		}
		return false;
	}
	public int Exist(String userName){
		List<Teacher> list=teacherRepo.Exist(userName);
		return (list.size()>0)? list.get(0).getId() :-1;
	}
}
