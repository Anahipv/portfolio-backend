
package portfolio.editable.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portfolio.editable.model.Persona;
import portfolio.editable.service.PersonaService;

@RestController
@RequestMapping("/home")
public class PersonaResource {
    
    @Autowired
    private PersonaService personaService;   
    
    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas(){
        List<Persona> personas = personaService.findAllPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Persona> getEmployeeById (@PathVariable("id") Long id) {
        Persona persona = personaService.findPersonaById(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona) {
        Persona newPersona = personaService.addPersona(persona);
        return new ResponseEntity<>(newPersona, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Persona> editPersona(@RequestBody Persona persona) {
        Persona editPersona = personaService.editPersona(persona);
        return new ResponseEntity<>(editPersona, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable("id") Long id) {
        personaService.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
