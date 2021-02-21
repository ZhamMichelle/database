package zham.example.database.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {


    @GetMapping(value = "/hello")
    @ResponseBody
    public String helloPage(HttpServletRequest request){
        System.out.println("REQUEST: "+request.getParameter("name"));
        return "Hello Jersey";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "goodbye";
    }
}
