package allegro.movieplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {

    @RequestMapping("/documentation")
    public String index(){
        return "redirect:swagger-ui.html";
    }
}
