package ecommerce.example.EcomerceBackend.api.controller.auth;


import ecommerce.example.EcomerceBackend.Exception.UserAlreadyExistsException;
import ecommerce.example.EcomerceBackend.api.model.LoginBody;
import ecommerce.example.EcomerceBackend.api.model.LoginResponse;
import ecommerce.example.EcomerceBackend.api.model.RegistrationBody;
import ecommerce.example.EcomerceBackend.model.LocalUser;
import ecommerce.example.EcomerceBackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class
AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody)
    {
        try
        {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();

        }
        catch (UserAlreadyExistsException ex)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody) {
        String jwt = userService.loginUser(loginBody);
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
        else {
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            return ResponseEntity.ok(response);

        }
    }


        @GetMapping("/me")
        public LocalUser getLoggedInUserProfile(@AuthenticationPrincipal LocalUser user)
        {
            return  user;
        }

}
