package own.halone.imageboard.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import own.halone.imageboard.Database.Users.ROLES;
import own.halone.imageboard.Database.Users.Users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserPrincipal implements UserDetails {
    private Users user;

    public CustomUserPrincipal(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for(ROLES role : ROLES.values()){
            grantedAuthorityList.add(new SimpleGrantedAuthority(role.name()));
        }
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isEnabled();
    }

    @Override
    public String toString() {
        return "CustomUserPrincipal{" +
                "user=" + user.toString() +
                '}';
    }
}
