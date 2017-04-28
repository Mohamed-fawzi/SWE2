package fizo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fizo.entities.Student;

public interface StudentRepo extends CrudRepository<Student,Integer> {
	 @Query("SELECT s FROM Student  s where s.UserName = :Name")
	 List<Student> Exist(@Param("Name")String Name);

}
