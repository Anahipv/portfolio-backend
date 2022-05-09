
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
import portfolio.editable.model.Proyecto;
import portfolio.editable.service.ProyectoService;

//@CrossOrigin(origins = "https://portfolio-anahipv.herokuapp.com")
@CrossOrigin
@RestController
@RequestMapping("/proyectos")
public class ProyectoResource {
    
    @Autowired
    private ProyectoService proyectoService;   
    
    @GetMapping
    public ResponseEntity<List<Proyecto>> getAllProyectos(){
        List<Proyecto> proyectos = proyectoService.findAllProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Proyecto> addProyecto(@RequestBody Proyecto proyecto) {
        Proyecto newProyecto = proyectoService.addProyecto(proyecto);
        return new ResponseEntity<>(newProyecto, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Proyecto> editProyecto(@RequestBody Proyecto proyecto) {
        Proyecto editProyecto = proyectoService.editProyecto(proyecto);
        return new ResponseEntity<>(editProyecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProyecto(@PathVariable("id") Long id) {
        proyectoService.deleteProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
