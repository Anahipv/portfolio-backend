
package portfolio.editable.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.editable.model.Persona;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Long> {

    public void deletePersonaById(Long id);

    public Optional <Persona> findPersonaById(Long id);
    
}
