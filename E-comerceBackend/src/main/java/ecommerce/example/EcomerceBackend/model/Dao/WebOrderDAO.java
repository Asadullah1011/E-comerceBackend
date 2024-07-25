package ecommerce.example.EcomerceBackend.model.Dao;

import ecommerce.example.EcomerceBackend.model.LocalUser;
import ecommerce.example.EcomerceBackend.model.WebOrder;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WebOrderDAO extends ListCrudRepository<WebOrder,Long> {
    List<WebOrder> findByUser(LocalUser user);
}
