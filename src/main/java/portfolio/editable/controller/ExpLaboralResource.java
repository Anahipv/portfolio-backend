
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
import portfolio.editable.model.ExpLaboral;
import portfolio.editable.service.ExpLaboralService;

//@CrossOrigin(origins = "https://portfolio-anahipv.herokuapp.com")
@CrossOrigin
@RestController
@RequestMapping("/explaboral")
public class ExpLaboralResource {
    
    @Autowired
    private ExpLaboralService expLaboralService;   
    
    @GetMapping
    public ResponseEntity<List<ExpLaboral>> getAllExpLaboral(){
        List<ExpLaboral> expLaboral = expLaboralService.findAllExpLaboral();
        return new ResponseEntity<>(expLaboral, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ExpLaboral> addExpLaboral(@RequestBody ExpLaboral expLaboral) {
        ExpLaboral newExpLaboral = expLaboralService.addExpLaboral(expLaboral);
        return new ResponseEntity<>(newExpLaboral, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<ExpLaboral> editExpLaboral(@RequestBody ExpLaboral expLaboral) {
        ExpLaboral editExpLaboral = expLaboralService.editExpLaboral(expLaboral);
        return new ResponseEntity<>(editExpLaboral, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExpLaboral(@PathVariable("id") Long id) {
        expLaboralService.deleteExpLaboral(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
