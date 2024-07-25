package ecommerce.example.EcomerceBackend.api.order;


import ecommerce.example.EcomerceBackend.model.LocalUser;
import ecommerce.example.EcomerceBackend.model.WebOrder;
import ecommerce.example.EcomerceBackend.service.OrderService;
import jakarta.validation.constraints.Max;
import jdk.dynalink.linker.LinkerServices;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<WebOrder> getOrders(@AuthenticationPrincipal LocalUser user)
    {
        return orderService.getOrders(user);
    }
}
