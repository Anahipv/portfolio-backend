
package portfolio.editable.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portfolio.editable.model.Skill;
import portfolio.editable.service.SkillService;

@CrossOrigin(origins = "https://portfolio-anahipv.herokuapp.com")
@RestController
@RequestMapping("/skills")
public class SkillResource {
    
    @Autowired
    private SkillService skillService;   
    
    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills(){
        List<Skill> skill = skillService.findAllSkills();
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
        Skill newSkill = skillService.addSkill(skill);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Skill> editSkill(@RequestBody Skill skill) {
        Skill editSkill = skillService.editSkill(skill);
        return new ResponseEntity<>(editSkill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") Long id) {
        skillService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
