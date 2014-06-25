package apartment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yar on 6/13/14.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "/")
    public String index(){
        return "redirect:/apartment/all";
    }
}
