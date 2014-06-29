package pl.java.borowiec.controller.word;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/word")
public class WordController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String word(){
        return "word";
    }
}
