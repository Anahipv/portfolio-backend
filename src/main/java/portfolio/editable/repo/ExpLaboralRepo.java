
package portfolio.editable.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.editable.model.ExpLaboral;


@Repository
public interface ExpLaboralRepo extends JpaRepository<ExpLaboral, Long> {

    public void deleteExpLaboralById(Long id);

    public Optional <ExpLaboral> findExpLaboralById(Long id);
    
    
}
