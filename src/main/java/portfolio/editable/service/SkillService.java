
package portfolio.editable.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.editable.exception.UserNotFoundException;
import portfolio.editable.model.Skill;
import portfolio.editable.repo.SkillRepo;

@Service
public class SkillService {
    
    @Autowired
    private SkillRepo skillRepo;
    
    public Skill addSkill(Skill skill){
        return skillRepo.save(skill);
    }
    
    public List<Skill> findAllSkills(){
        return skillRepo.findAll();
    }
    
    public void deleteSkill(Long id){
        skillRepo.deleteSkillById(id);
    }
    
    public Skill findSkillById(Long id){
        return skillRepo.findSkillById(id).orElseThrow(
            () -> new UserNotFoundException("Skill " + id + "no existe"));
    }
    
    public Skill editSkill(Skill skill) {
        return skillRepo.save(skill);
    }
    
}
