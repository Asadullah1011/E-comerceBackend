package ecommerce.example.EcomerceBackend.service;


import ecommerce.example.EcomerceBackend.model.Dao.WebOrderDAO;
import ecommerce.example.EcomerceBackend.model.LocalUser;
import ecommerce.example.EcomerceBackend.model.WebOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private WebOrderDAO webOrderDAO;

    public OrderService(WebOrderDAO webOrderDAO) {
        this.webOrderDAO = webOrderDAO;
    }

    public List<WebOrder> getOrders(LocalUser user)
    {
        return webOrderDAO.findByUser(user);
    }

}
