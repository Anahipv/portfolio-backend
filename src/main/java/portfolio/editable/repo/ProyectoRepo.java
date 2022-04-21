
package portfolio.editable.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.editable.model.Proyecto;

@Repository
public interface ProyectoRepo extends JpaRepository<Proyecto, Long> {

    public void deleteProyectoById(Long id);

    public Optional <Proyecto> findProyectoById(Long id);
    
}
