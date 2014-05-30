package apartment.controller;

import apartment.domain.Apartment;
import apartment.domain.User;
import apartment.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    public String listAll(@AuthenticationPrincipal User user, ModelMap model) {
//    public String listAll(ModelMap model) {
        model.addAttribute("apartments", apartmentService.all());
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user.getUsername());
        System.out.println(user.getUsername());
        return "apartment/all";
    }

//    @Secured("ROLE_USER")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(){
        return "apartment/add";
    }

//    @Secured("ROLE_USER")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(@RequestBody Client client) {
    public String add(@ModelAttribute Apartment apartment) {
        apartmentService.add(apartment);
        return "redirect:all";
    }
}
