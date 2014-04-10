package apartment.controller;

import apartment.domain.Client;
import apartment.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yar on 4/10/14.
 */
@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public String redirectToAll() {
        return "redirect:/client/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllClients(ModelMap model) {
        model.addAttribute("allClients", clientService.getAll());
        return "/client/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String emptyAddForm(){
        return "/client/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addClient(@ModelAttribute Client client, ModelMap modelMap){
        clientService.addClient(client);
        return "redirect:/client/all";
    }
}
