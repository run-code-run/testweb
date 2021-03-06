package testweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import testweb.service.RemoteCallService;
import entities.CurrencyEntity;
import entities.EOrderEntity;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.List;


@Controller
public class OrderController {


    @Autowired
    private RemoteCallService remoteCallService;


    @RequestMapping(value = "/getRegisteredOrders", method = RequestMethod.GET)
    String getRegisteredOrders(ModelMap modelMap) {

        try {
            List<EOrderEntity> orders = remoteCallService.getOrdersList();
            modelMap.addAttribute("orderList", orders);
        } catch (NamingException | RemoteException e) {
            e.printStackTrace();
        }


        return "OrdersList";
    }


    @RequestMapping(value = "/makeAnOrder", method = RequestMethod.GET)
    String makeAnOrder() {
        return "Order";
    }


    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    String validateOrder(@ModelAttribute("SpringWeb") EOrderEntity eOrder, ModelMap model) {

        if ((eOrder.getSum() > 5000D) && (eOrder.getCurrency().equals(CurrencyEntity.USD))) {
            model.addAttribute("status", "1");
            model.addAttribute("EOrder", eOrder);
            return "Order";
        }

        try {

            remoteCallService.placeNewOrder(eOrder);

        } catch (NamingException | RemoteException e) {
            e.printStackTrace();
        }

        return "Order";
    }

}
