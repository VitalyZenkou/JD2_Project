package com.itacademy.zenkou.jdb2project.web.config;

import com.itacademy.zenkou.jdb2project.database.entity.UserRoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.itacademy.zenkou.jdb2project.web.util.constant.UrlPath.ADMIN;
import static com.itacademy.zenkou.jdb2project.web.util.constant.UrlPath.HOME;
import static com.itacademy.zenkou.jdb2project.web.util.constant.UrlPath.USER;
import static com.itacademy.zenkou.jdb2project.web.util.constant.WebParameterConstant.LOGIN;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final String[] adminPageAvailable = {UserRoleType.SUPER_ADMIN.name(), UserRoleType.ADMIN.name()
            , UserRoleType.NEWBIE_ADMIN.name()};
    private final String[] homePageAvailable = {UserRoleType.SUPER_ADMIN.name(), UserRoleType.ADMIN.name()
            , UserRoleType.NEWBIE_ADMIN.name(), UserRoleType.CUSTOMER.name()};

    // @formatter::off
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/" + ADMIN, "/" + USER)
                    .hasAnyAuthority(adminPageAvailable)
                .antMatchers("/" + HOME)
                    .hasAnyAuthority(homePageAvailable)
                .anyRequest()
                    .permitAll()
                .and()
                    .formLogin()
                        .usernameParameter(LOGIN)
                        .defaultSuccessUrl("/" + HOME)
                .and()
                    .httpBasic()
                .and()
                    .logout();
    }
    // @formatter::on

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider());
    }
}
