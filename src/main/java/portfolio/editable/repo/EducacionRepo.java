
package portfolio.editable.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.editable.model.Educacion;


public interface EducacionRepo extends JpaRepository<Educacion, Long> {

    public void deleteEducacionById(Long id);

    public Optional <Educacion> findEducacionById(Long id);
    
}
