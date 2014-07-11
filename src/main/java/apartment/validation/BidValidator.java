package apartment.validation;

import apartment.domain.Bid;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.TreeSet;

/**
 * Created by yar on 11.07.14.
 */
public class BidValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Bid.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //ValidationUtils.rejectIfEmpty(errors, "price", "price.empty");
        Bid bid = (Bid) o;
        TreeSet<Bid> bids = new TreeSet<Bid>(bid.getApartment().getBids());
        if(bids.size()>0 && bids.first().getPrice()>=bid.getPrice()){
            errors.rejectValue("Price", "To small");
        }
        if(bid.getClient()==null){
            errors.rejectValue("Client", "Null");
        }
        if(bid.getApartment()==null){
            errors.rejectValue("Apartment", "Null");
        }
    }
}
