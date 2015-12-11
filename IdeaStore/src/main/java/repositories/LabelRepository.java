package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Label;;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {

	@Query("select c from Label c where c.idea.id= ?1")
	Collection<Label> findLabelByIdea(int ideaId);

}
