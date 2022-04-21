
package portfolio.editable.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.editable.model.Skill;


@Repository
public interface SkillRepo extends JpaRepository<Skill, Long> {

    public void deleteSkillById(Long id);

    public Optional <Skill> findSkillById(Long id);
    
}
