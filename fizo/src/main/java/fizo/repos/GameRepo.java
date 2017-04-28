package fizo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fizo.entities.Game;

public interface GameRepo extends CrudRepository<Game,Integer>{
	 @Query("SELECT s FROM Game  s where s.Name = :Name")
	 List<Game> Exist(@Param("Name")String Name);
}
