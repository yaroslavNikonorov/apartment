package apartment.controller;

import apartment.domain.Apartment;
import apartment.domain.Bid;
import apartment.domain.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;

/**
 * Created by yar on 11.07.14.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        System.out.println("Init My Binder");
        binder.registerCustomEditor(Client.class, "client", new PropertyEditorSupport(){

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                System.out.println("Set text");
                Client client = new Client(text);
                setValue(client);
            }

            @Override
            public String getAsText() {
                System.out.println("dsadasdasd");
                return super.getAsText();
            }
        });
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(){
        return "test/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String test(@ModelAttribute @Valid Client client, BindingResult result){
        if(!result.hasErrors()){
            return "redirect:/test/add";
        }
        return "";
    }
}
