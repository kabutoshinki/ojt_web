package com.swp.swp.googleApi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests()
        //     .antMatchers("/","/account/loginPage", "/oauth/**").permitAll()
        //     .anyRequest().authenticated()
        //     .and()
        //     .formLogin().loginPage("/account/loginPage").permitAll()
        //     .and()
        //     .oauth2Login()
        //     .loginPage("/account/loginPage")
        //     .userInfoEndpoint().userService(oauthUserService)
        // ;

            http.csrf().disable().httpBasic().and().authorizeRequests()
                .antMatchers("/", "/account/loginPage","/webjars/**", "/oauth/**","/img/**","/CSS/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/account/loginPage").permitAll()
                .and().logout().logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/").and()
                .oauth2Login()
                    .loginPage("/account/loginPage")
                    .userInfoEndpoint()
                        .userService(oauthUserService).and();
        
        
        
        
    }
     
    @Autowired
    private CustomOAuth2UserService oauthUserService;
}
