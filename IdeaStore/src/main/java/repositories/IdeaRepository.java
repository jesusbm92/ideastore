package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Idea;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Integer>{
	//Here you should do queries in case you want to get something special from database

}
