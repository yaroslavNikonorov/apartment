package apartment.controller;

import apartment.domain.Group;
import apartment.domain.Role;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listAll(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return "user/all";
    }

//    @Secured("ROLE_USER")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(ModelMap model){
        model.addAttribute("roles", Role.class.getEnumConstants());
        return "user/add";
    }

//    @Secured("ROLE_USER")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(@RequestBody Client client) {
    public String add(@RequestParam("username") String username, @RequestParam("groups") List<Role> roles, @RequestParam("password") String password) {
        User user = new User();
        user.setUsername(username);
        List<Group> groups = new ArrayList<Group>();
//        for (Long id: groupIds){
//            groups.add(groupService.findById(id));
//        }
        user.setRoles(roles);
        user.setPassword(password);
        userService.add(user);
        return "redirect:/user/all";
    }
}
