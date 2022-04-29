
package portfolio.editable.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.editable.exception.UserNotFoundException;
import portfolio.editable.model.Proyecto;
import portfolio.editable.repo.ProyectoRepo;


@Service
@Transactional
public class ProyectoService {
    
    @Autowired
    private ProyectoRepo proyectoRepo;
    
    public Proyecto addProyecto(Proyecto proyecto){
        return proyectoRepo.save(proyecto);
    }
    
    public List<Proyecto> findAllProyectos(){
        return proyectoRepo.findAll();
    }
    
    public void deleteProyecto(Long id){
        proyectoRepo.deleteProyectoById(id);
    }
    
    public Proyecto findProyectoById(Long id){
        return proyectoRepo.findProyectoById(id).orElseThrow(
            () -> new UserNotFoundException("Proyecto" + id + "no existe"));
    }
    
    public Proyecto editProyecto(Proyecto proyecto) {
        return proyectoRepo.save(proyecto);
    }
    
}
