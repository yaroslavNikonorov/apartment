package apartment.controller;

import apartment.domain.Group;
import apartment.domain.User;
import apartment.service.GroupService;
import apartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 4/16/14.
 */
@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;


    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect:all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listAll(ModelMap model) {
        model.addAttribute("groups", groupService.getAll());
        return "group/all";
    }

//    @Secured("ROLE_USER")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(){
        return "group/add";
    }

//    @Secured("ROLE_USER")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="text/html")
//    public String add(@RequestBody Client client) {
    public String add(@ModelAttribute Group group) {
        groupService.add(group);
        return "redirect:all";
    }
}
