package testweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import testweb.model.Currency;
import testweb.model.EOrder;
import testweb.service.RemoteCallService;

@Controller
public class OrderController {


    @Autowired
    private RemoteCallService remoteCallService;

    @RequestMapping(value = "/makeAnOrder", method = RequestMethod.GET)
    String makeAnOrder() {
        return "Order";
    }


    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    String validateOrder(@ModelAttribute("SpringWeb") EOrder eOrder, ModelMap model) {

        if ((eOrder.getSum() > 5000D) && (eOrder.getCurrency().equals(Currency.USD))) {
            model.addAttribute("status", "1");
        }

        model.addAttribute("EOrder", eOrder);

        return "Order";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String testEJB(ModelMap model) throws Exception {



        int res = remoteCallService.getRemoteValue();

        model.addAttribute("result", res);
        return "Result";
    }
}
