package io.swagger.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Home redirection to swagger api documentation 
 */
@Controller
public class HomeController {
    Logger logger = Logger.getLogger("logger");
    @RequestMapping(value = "/")
    public String index() {
        logger.log(Level.INFO,"swagger-ui.html");
        return "redirect:swagger-ui.html";
    }
}
