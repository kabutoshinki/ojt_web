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
                .antMatchers("/", "/homePage","/view/**","/oauth2/authorization/google","/webjars/**","/webapp/**", "/oauth/**","/img/**","/CSS/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/oauth2/authorization/google").permitAll()
                .and().logout().logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/homePage").and()
                .oauth2Login()
                    .loginPage("/oauth2/authorization/google")
                    .userInfoEndpoint()
                        .userService(oauthUserService).and()
                        .successHandler(oAuth2LoginSucessHandler);    
    }
     
    @Autowired
    private CustomOAuth2UserService oauthUserService;
    @Autowired
    private OAuth2LoginSucessHandler oAuth2LoginSucessHandler;
}
