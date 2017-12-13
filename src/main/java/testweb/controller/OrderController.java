package testweb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

    @RequestMapping(value = "/testweb", method = RequestMethod.GET)
    String makeAnOrder() {
        return "Order";
    }


    //Если сумма заказа больше 5 тыс, то вернуть клиента обратно на страницу
//    С сообщением "неправильная сумма", все ранее заполненные поля должны сохраниться
    @RequestMapping(value = "/sendorder", method = RequestMethod.POST)
    String validateOrde(@PathVariable Double sum, final Model model) {
        if (sum > 5000D) {
            model.addAttribute("message", "Wrong sum");
        }
        return "Result";
    }
}
