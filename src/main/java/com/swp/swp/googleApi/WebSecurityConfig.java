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

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests()
        //     .antMatchers("/", "/login", "/oauth/**").permitAll()
        //     .anyRequest().authenticated()
        //     .and()
        //     .formLogin().permitAll()
        //     .and()
        //     .oauth2Login()
        //         .loginPage("/login")
        //         .userInfoEndpoint()
        //             .userService(oauthUserService);

        http.oauth2Login().loginPage("/login")
        .userInfoEndpoint().userService(oauthUserService).and()
        .successHandler(new AuthenticationSuccessHandler() {

            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                    Authentication authentication) throws IOException, ServletException {
                    CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
                    
                    response.sendRedirect("/listCompany");

                
            }
            
        });
    }

     
    @Autowired
    private CustomOAuth2UserService oauthUserService;
}
