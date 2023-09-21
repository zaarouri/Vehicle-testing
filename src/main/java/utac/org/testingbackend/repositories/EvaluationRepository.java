package utac.org.testingbackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import utac.org.testingbackend.entities.Evaluation;

import java.util.Collection;


public interface EvaluationRepository extends JpaRepository<Evaluation, String>  {
    @Override
    boolean existsById(String s);
}
