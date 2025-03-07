package ecommerce.example.EcomerceBackend.service;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
    @Value("${encryption.salt.rounds}")
    private int SaltRounds;

    private String salt;
    @PostConstruct
    public void postContruct()
    {
        salt = BCrypt.gensalt(SaltRounds);

    }


    public String encryptPassword(String password)
    {
        return BCrypt.hashpw(password,salt);
    }
    public boolean verifyPassword(String password, String hash)
    {
        return BCrypt.checkpw(password,hash);
    }
}
