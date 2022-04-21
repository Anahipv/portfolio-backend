
package portfolio.editable.service;

import portfolio.editable.exception.UserNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.editable.model.Persona;
import portfolio.editable.repo.PersonaRepo;

@Service
public class PersonaService {
    
    @Autowired
    private PersonaRepo personaRepo;
    
    public Persona addPersona(Persona persona){
        return personaRepo.save(persona);
    }
    
    public List<Persona> findAllPersonas(){
        return personaRepo.findAll();
    }
    
    public void deletePersona(Long id){
        personaRepo.deletePersonaById(id);
    }
    
    public Persona findPersonaById(Long id){
        return personaRepo.findPersonaById(id).orElseThrow(
            () -> new UserNotFoundException("Persona " + id + "no existe"));
    }
    
    public Persona editPersona(Persona persona) {
        return personaRepo.save(persona);
    }
}
