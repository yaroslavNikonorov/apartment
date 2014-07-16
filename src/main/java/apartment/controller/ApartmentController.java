package apartment.controller;

import apartment.annotation.CookieAsObject;
import apartment.domain.Apartment;
import apartment.domain.Bid;
import apartment.domain.Client;
import apartment.repository.ApartmentRepository;
import apartment.repository.BidRepository;
import apartment.repository.ClientRepository;
import apartment.validation.BidValidator;
import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.TreeSet;

@Controller
@RequestMapping("/apartment")
public class ApartmentController {

    private Logger logger = Logger.getLogger(ApartmentController.class);

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect:all";
    }

    @RequestMapping(value = "/all")
    public String all(ModelMap model) {
        model.addAttribute("apartments", apartmentRepository.findAll());
//        for (Apartment apartment : apartmentService.all()) {
////            logger.info("Apartment ID: "+apartment.getId());
//            for (Bid bid : apartment.getBids()) {
//                System.out.println("Prices: " + bid.getPrice() + "Client: " + bid.getClient().getName());
//            }
//        }
        return "apartment/all";
    }


//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public String listAll(@AuthenticationPrincipal User user, @CookieValue("ClientID") String clientId, ModelMap model, HttpServletResponse response) {
//        logger.info("start all");
////    public String listAll(@AuthenticationPrincipal User user, ModelMap model) {
////    public String listAll(ModelMap model) {
//        model.addAttribute("apartments", apartmentService.all());
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        User user = (User) authentication.getPrincipal();
//        if(user!=null){
//            model.addAttribute("user", user.getUsername());
//            model.addAttribute("id", user.getId().toString());
//        } else {
////            model.addAttribute("user", "No user");
////            model.addAttribute("id", "No id");
//            if (clientId==null){
//                Client client = new Client("name");
//                Cookie cookie = new Cookie("ClientID", client.getId().toString());
//                cookie.setPath("/");
//                cookie.setMaxAge(10);
//                response.addCookie(cookie);
//                model.addAttribute("user", client.getName());
//                model.addAttribute("id", client.getId());
//            } else {
//                Client client = clientService.findById(Long.getLong(clientId));
//                if(client!=null){
//                    model.addAttribute("user", client.getName());
//                    model.addAttribute("id", client.getId());
//                } else {
//                    model.addAttribute("user", "Client no found");
//                    model.addAttribute("id", "no id");
//                }
//            }
//        }
////             System.out.println(user.getUsername());
//        return "apartment/all";
//    }

    //    @Secured("ROLE_USER")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm() {
        return "apartment/add";
    }

    //    @Secured("ROLE_USER")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid Apartment apartment, BindingResult result) {
        if (!result.hasErrors()) {
            apartmentRepository.save(apartment);
        }
        return "redirect:all";
    }

    @RequestMapping(value = "/addbid")
//    @Transactional
    public String addBid(@RequestParam("apartmentId") String apartmentId,
                         @RequestParam("price") String price, @CookieAsObject("ClientID") Client client) {
//        if (client != null) {
//            Apartment apartment = apartmentRepository.findOne(Long.parseLong(apartmentId));
//            if(apartment != null){
//                TreeSet<Bid> bids = new TreeSet<Bid>(apartment.getBids());
//                if(bids.size()>0 && bids.first().getPrice()<Double.parseDouble(price)){
//                    Bid bid = new Bid(apartment, Double.parseDouble(price), client);
//                    bidRepository.save(bid);
//                } else if(bids.size() == 0) {
//                    Bid bid = new Bid(apartment, Double.parseDouble(price), client);
//                    bidRepository.save(bid);
//                }
//            }
//            return "redirect:all";
//        }

        if (client == null) {
            return "redirect:/client/add?apartmentId=" + apartmentId + "&price=" + price;
        }
        try {
            Apartment apartment = apartmentRepository.findOne(Long.parseLong(apartmentId));
            if (apartment != null) {
                Bid bid = new Bid(apartment, Double.parseDouble(price), client);
                DataBinder binder = new DataBinder(bid);
                binder.setValidator(new BidValidator());
                binder.validate();
                BindingResult result = binder.getBindingResult();
                if (!result.hasErrors()) {
                    bidRepository.save(bid);
                }
            }
        } catch (NumberFormatException e) {
        }
        return "redirect:all";
    }
}
