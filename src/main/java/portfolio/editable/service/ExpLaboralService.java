
package portfolio.editable.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.editable.exception.UserNotFoundException;
import portfolio.editable.model.ExpLaboral;
import portfolio.editable.repo.ExpLaboralRepo;

@Service
@Transactional
public class ExpLaboralService {
    
    @Autowired
    private ExpLaboralRepo expLaboralRepo;
    
    public ExpLaboral addExpLaboral(ExpLaboral expLaboral){
        return expLaboralRepo.save(expLaboral);
    }
    
    public List<ExpLaboral> findAllExpLaboral(){
        return expLaboralRepo.findAll();
    }
    
    public void deleteExpLaboral(Long id){
        expLaboralRepo.deleteExpLaboralById(id);
    }
    
    public ExpLaboral findExpLaboralById(Long id){
        return expLaboralRepo.findExpLaboralById(id).orElseThrow(
            () -> new UserNotFoundException("ExpLaboral " + id + "no existe"));
    }
    
    public ExpLaboral editExpLaboral(ExpLaboral expLaboral) {
        return expLaboralRepo.save(expLaboral);
    }
}
