
package portfolio.editable.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.editable.exception.UserNotFoundException;
import portfolio.editable.model.Educacion;
import portfolio.editable.repo.EducacionRepo;


@Service
public class EducacionService {
    
    @Autowired
    private EducacionRepo educacionRepo;
    
    public Educacion addEducacion(Educacion educacion){
        return educacionRepo.save(educacion);
    }
    
    public List<Educacion> findAllEducaciones(){
        return educacionRepo.findAll();
    }
    
    public void deleteEducacion(Long id){
        educacionRepo.deleteEducacionById(id);
    }
    
    public Educacion findEducacionById(Long id){
        return educacionRepo.findEducacionById(id).orElseThrow(
            () -> new UserNotFoundException("Educacion " + id + "no existe"));
    }
    
    public Educacion editEducacion(Educacion educacion) {
        return educacionRepo.save(educacion);
    }
    
}
