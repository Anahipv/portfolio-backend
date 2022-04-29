
package portfolio.editable.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.editable.exception.UserNotFoundException;
import portfolio.editable.model.Idioma;
import portfolio.editable.repo.IdiomaRepo;


@Service
@Transactional
public class IdiomaService {
    
    @Autowired
    private IdiomaRepo idiomaRepo;
    
    public Idioma addIdioma(Idioma idioma){
        return idiomaRepo.save(idioma);
    }
    
    public List<Idioma> findAllIdiomas(){
        return idiomaRepo.findAll();
    }
    
    public void deleteIdioma(Long id){
        idiomaRepo.deleteIdiomaById(id);
    }
    
    public Idioma findIdiomaById(Long id){
        return idiomaRepo.findIdiomaById(id).orElseThrow(
            () -> new UserNotFoundException("Idioma " + id + "no existe"));
    }
    
    public Idioma editIdioma(Idioma idioma) {
        return idiomaRepo.save(idioma);
    }
}
