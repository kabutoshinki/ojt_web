package com.swp.swp.googleApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.swp.swp.service.AccountService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private AccountService accountService;
   
    
    
    
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
        // 

            http.csrf().disable().httpBasic().and().authorizeRequests()
                .antMatchers("/", "/home","/view/**","/oauth2/authorization/google","/webjars/**","/webapp/**", "/oauth/**","/img/**","/CSS/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/oauth2/authorization/google").permitAll()
                .and().logout().logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/home").and()
                .oauth2Login()
                    .loginPage("/oauth2/authorization/google")
                    .userInfoEndpoint()
                        .userService(oauthUserService).and()
                        .successHandler(oAuth2LoginSuccessHandler);
    }
    @Autowired
    private CustomOAuth2UserService oauthUserService;
    @Autowired
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
}
