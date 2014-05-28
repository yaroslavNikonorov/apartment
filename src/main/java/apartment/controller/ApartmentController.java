package apartment.controller;

import apartment.domain.Apartment;
import apartment.domain.Group;
import apartment.domain.User;
import apartment.service.ApartmentService;
import apartment.service.GroupService;
import apartment.service.UserService;
import com.sun.org.apache.regexp.internal.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 4/16/14.
 */
@Controller
@RequestMapping("/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect:all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listAll(ModelMap model) {
        model.addAttribute("apartments", apartmentService.all());
        return "apartment/all";
    }

//    @Secured("ROLE_USER")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(){
        return "apartment/add";
    }

//    @Secured("ROLE_USER")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="text/html")
//    public String add(@RequestBody Client client) {
    public String add(@ModelAttribute Apartment apartment) {
        apartmentService.add(apartment);
        return "redirect:all";
    }
}
