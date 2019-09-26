package com.test.demo1.config;


import com.test.demo1.entity.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UDSConfig implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TestUser testUser = new TestUser();
        testUser.setUsername(username);
        testUser.setPassword(passwordEncoder.encode("123465"));
        System.out.println(testUser.getPassword());
        //System.out.println(AuthorityUtils.commaSeparatedStringToAuthorityList("admin").getClass());
        return new User(username,testUser.getPassword(),testUser.isEnabled(),
                testUser.isAccountNonExpired(),testUser.isCredentialsNonExpired(),
                testUser.isAccountNonLocked(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));


    }
}
