package fizo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import fizo.entities.Teacher;



public interface TeacherRepo extends CrudRepository<Teacher,Integer>  {
	 @Query("SELECT s FROM Teacher  s where s.UserName = :Name")
	 List<Teacher> Exist(@Param("Name")String Name);

}
