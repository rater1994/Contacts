package security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class userDetails implements UserDetails {

    private String username;
    private Integer token;
    private String id;

    private Collection<? extends  GrantedAuthority> authorities;


    public userDetails(String username,
                       Integer token,
                       String id,
                       Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.token = token;
        this.id = id;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true;
    }


    public String getId() {
        return id;
    }
}