package allegro.movieplatform.doc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class SwaggerController {

    @RequestMapping("/documentation")
    public String index(){
        return "redirect:swagger-ui.html";
    }
}
