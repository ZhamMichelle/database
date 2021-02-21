package zham.example.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zham.example.database.dao.PersonDAO;
import zham.example.database.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    //@Autowired
    //private PersonDAO personDAO;

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO){
        this.personDAO=personDAO;
    }

    @GetMapping()
    @ResponseBody
    public String index(){
        System.out.println("INDEX: "+personDAO.index());
        return null;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String show(@PathVariable("id") int id){
        //System.out.println("SHOW: "+personDAO.show(id));
        return null;
    }

    @PostMapping("/create")
    @ResponseBody
    public String create(@Valid @RequestBody Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "Error";

        personDAO.save(person);

        System.out.println("CREATE: "+personDAO.index());
        return null;
    }

    @PatchMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable("id") int id){
        //personDAO.update(id);
        return null;
    }
}
