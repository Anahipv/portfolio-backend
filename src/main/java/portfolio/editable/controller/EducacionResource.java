
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
import portfolio.editable.model.Educacion;
import portfolio.editable.service.EducacionService;

@CrossOrigin(origins = "https://portfolio-anahipv.herokuapp.com")
@RestController
@RequestMapping("/educacion")
public class EducacionResource {
    
    @Autowired
    private EducacionService educacionService;   
    
    @GetMapping
    public ResponseEntity<List<Educacion>> getAllEducacion(){
        List<Educacion> educaciones = educacionService.findAllEducaciones();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Educacion> addEducacion(@RequestBody Educacion educacion) {
        Educacion newEducacion = educacionService.addEducacion(educacion);
        return new ResponseEntity<>(newEducacion, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Educacion> editEducacion(@RequestBody Educacion educacion) {
        Educacion editEducacion = educacionService.editEducacion(educacion);
        return new ResponseEntity<>(editEducacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable("id") Long id) {
        educacionService.deleteEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
