package testweb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    String makeAnOrder() {
        return "Order";
    }
}
