package fizo.repos;

import org.springframework.data.repository.CrudRepository;

import fizo.entities.Question;

public interface QuestoinRepo extends CrudRepository<Question,Integer> {

}
