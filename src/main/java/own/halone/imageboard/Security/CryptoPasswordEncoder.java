package own.halone.imageboard.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CryptoPasswordEncoder {
    @Bean
    PasswordEncoder CustomPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}