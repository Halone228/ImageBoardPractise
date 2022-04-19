package own.halone.imageboard.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import own.halone.imageboard.Security.CryptoPasswordEncoder;

import javax.servlet.http.Cookie;

@Configuration
@EnableWebSecurity
public class SecurityMvc extends WebSecurityConfigurerAdapter {

    private CustomUserService customUserService;
    private PasswordEncoder passwordEncoder;

    public SecurityMvc(CustomUserService customUserService, PasswordEncoder passwordEncoder) {
        this.customUserService = customUserService;
        passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resource/**").anonymous()
                .antMatchers("/").authenticated()
                .antMatchers("/register").authenticated()
                .and()
                .formLogin()
                .and()
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .addLogoutHandler((request, response, auth) -> {
                            for (Cookie cookie : request.getCookies()) {
                                String cookieName = cookie.getName();
                                Cookie cookieToDelete = new Cookie(cookieName, null);
                                cookieToDelete.setMaxAge(0);
                                response.addCookie(cookieToDelete);
                            }
                        }
                        )
                );
    }
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.customUserService);
        daoAuthenticationProvider.setPasswordEncoder(new CryptoPasswordEncoder().CustomPasswordEncoder());
        return daoAuthenticationProvider;
    }
}
