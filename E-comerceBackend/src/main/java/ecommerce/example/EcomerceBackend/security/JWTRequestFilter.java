package ecommerce.example.EcomerceBackend.security;


import com.auth0.jwt.exceptions.JWTDecodeException;
import ecommerce.example.EcomerceBackend.model.Dao.LocalUserDAO;
import ecommerce.example.EcomerceBackend.model.LocalUser;
import ecommerce.example.EcomerceBackend.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {


    private JWTService jwtService;
    private LocalUserDAO localUserDAO;

    public JWTRequestFilter(JWTService jwtService, LocalUserDAO localUserDAO) {
        this.jwtService = jwtService;
        this.localUserDAO = localUserDAO;
    }



    // everytime we get request will come to this below method
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader=request.getHeader("Authorization");    //is it Aithorization
        if(tokenHeader!=null && tokenHeader.startsWith("Bearer "))   //start with bearer
        {
            String token = tokenHeader.substring(7);     // substring into 7
            try{
                String username= jwtService.getUsername(token);    // decode token
                Optional<LocalUser> opUser = localUserDAO.findByUsernameIgnoreCase(username);  // find user
                if(opUser.isPresent())     //if user is present
                {
                    LocalUser user = opUser.get();
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null, new ArrayList());  // build athentication object to the user
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // set some extra detail to the authentication object so web authenitication knows about request being authenticated
                    SecurityContextHolder.getContext().setAuthentication(authentication); // Security content set authentication we just created
                }
            }

            catch (JWTDecodeException ex)      //cannot decode come here and do nothing
            {

            }
            String username=jwtService.getUsername(token);

        }
        filterChain.doFilter(request, response);
    }
}
