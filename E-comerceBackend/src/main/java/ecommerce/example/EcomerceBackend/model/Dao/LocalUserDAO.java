package ecommerce.example.EcomerceBackend.model.Dao;

import ecommerce.example.EcomerceBackend.model.LocalUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.awt.*;
import java.util.Optional;


//DAO mwean data access object
// localUserDao data access object for local user
public interface LocalUserDAO extends ListCrudRepository<LocalUser,Long> {
    Optional<LocalUser> findByUsernameIgnoreCase(String username);

    Optional<LocalUser> findByEmailIgnoreCase(String email);
}
