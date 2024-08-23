package tacos.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.model.Order;
import tacos.repository.OrderRepository;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@SessionAttributes("order")
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String OrderForm(Model model,@ModelAttribute Order order){
        model.addAttribute("order",order);
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "orderForm";
        }

        orderRepository.save(order);
        sessionStatus.setComplete();
        //log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
