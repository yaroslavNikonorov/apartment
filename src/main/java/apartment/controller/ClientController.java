package apartment.controller;

import apartment.domain.Client;
import apartment.repository.ClientRepository;
import apartment.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by yar on 6/16/14.
 */
@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(@RequestParam(value = "apartmentId", required = false) String apartmentId,
                          @RequestParam(value = "price", required = false) String price, ModelMap model){
        if(apartmentId!=null && price!=null){
            model.addAttribute("apartmentId", apartmentId);
            model.addAttribute("price", price);
        }
        return "/client/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addClient(@Valid @ModelAttribute("client")Client client, HttpServletResponse response,
                            @RequestParam(value = "apartmentId", required = false) String apartmentId,
                            @RequestParam(value = "price", required = false) String price){
        clientRepository.save(client);
        Cookie cookie = new Cookie("ClientID", client.getId().toString());
        cookie.setPath("/");
        response.addCookie(cookie);
        if(apartmentId!=null&&price!=null){
            return "redirect:/apartment/addbid?apartmentId="+apartmentId+"&price="+price;
        }
        return "redirect:/apartment/all";
    }

    @RequestMapping(value = "/all")
    public String all(ModelMap modelMap){
        modelMap.addAttribute("clients", clientRepository.findAll());
        return "/client/all";
    }

}
