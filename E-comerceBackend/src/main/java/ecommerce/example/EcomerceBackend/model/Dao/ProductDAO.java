package ecommerce.example.EcomerceBackend.model.Dao;

import ecommerce.example.EcomerceBackend.model.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductDAO extends ListCrudRepository<Product,Long> {

}
