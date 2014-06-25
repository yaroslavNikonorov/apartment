package apartment.controller;

import apartment.domain.Group;
import apartment.domain.Role;
import apartment.domain.User;
import apartment.service.GroupService;
import apartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
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

    @Autowired
    private BCryptPasswordEncoder encoder;

//    @Secured("ROLE_ANONYMOUS")
//    @RequestMapping(value = "/all", method = RequestMethod.GET,headers="Accept=application/json")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public @ResponseBody Iterable<User> listAll(@AuthenticationPrincipal User user, ModelMap model) {
//    public @ResponseBody Collection<String> listAll(@CookieValue("ClientID") String clientId, HttpServletResponse response) {
    public @ResponseBody String listAll(@CookieValue(value = "ClientID", required=false) String clientId, HttpServletResponse response) {
        //model.addAttribute("users", userService.getAll());
        //System.out.println(user);
        if(clientId==null){
            Cookie cookie = new Cookie("ClientID", "dsdsdsdsd");
            cookie.setMaxAge(10);
            response.addCookie(cookie);
            return "created new";
        }
        return clientId;
    }

//    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(ModelMap model){
        model.addAttribute("roles", Role.class.getEnumConstants());
        return "user/add";
    }

//    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("username") String username, @RequestParam("groups") List<Role> roles, @RequestParam("password") String password) {
        User user = new User();
        user.setUsername(username);
//        List<Group> groups = new ArrayList<Group>();
        user.setRoles(roles);
        user.setPassword(encoder.encode(password));
        userService.add(user);
        return "redirect:all";
    }
}
