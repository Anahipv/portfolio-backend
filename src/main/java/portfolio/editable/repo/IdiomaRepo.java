
package portfolio.editable.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.editable.model.Idioma;

@Repository
public interface IdiomaRepo extends JpaRepository<Idioma, Long> {

    public void deleteIdiomaById(Long id);

    public Optional <Idioma> findIdiomaById(Long id);
    
}
