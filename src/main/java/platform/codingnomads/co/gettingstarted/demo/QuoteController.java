package platform.codingnomads.co.gettingstarted.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// The @Controller annotation indicates that this class is a Spring MVC web controller
// A web controller listens to inbound requests and returns a view
@Controller
public class QuoteController {

    // injection of a Quote bean
    @Autowired
    QuoteService quoteService;

    // definition of the endpoint(http://localhost:8080/quote)
    @GetMapping("/quote")
    public String quote (Model model){
        //Get a random quote from the service
        String quote = quoteService.getRandomQuote();

        //Attach that quote to the data model
        model.addAttribute("quote", quote);

        //Return the view "getting_started/quote.html"
        return "getting_started/quote";
    }


}
