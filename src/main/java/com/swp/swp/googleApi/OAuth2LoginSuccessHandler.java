package com.swp.swp.googleApi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.swp.swp.service.AccountService;


@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    AccountService accountService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getEmail();
        HttpSession session = request.getSession();
        if(accountService.isExist(email)==false || (accountService.isExist(email) == true && accountService.findByEmail(email).getStatus().equals("Inactive"))){
            System.out.println("This account not have permission");
            session.setAttribute("warningMessage", "This account not have permission");
            response.sendRedirect("/logout");

        }else{
            System.out.println("login success");

            System.out.println(accountService.getByString(email).getRole());
            session.setAttribute("successMessage", "Login success");
            session.setAttribute("true", "true");
            session.setAttribute("email", oAuth2User.getEmail());
            session.setAttribute("userName", oAuth2User.getName());
            session.setAttribute("account", accountService.getByString(email));
            if (accountService.checkRole("STUDENT", request))
                response.sendRedirect("/home");
            else if (accountService.checkRole("COMPANY", request))
                response.sendRedirect("/company");
            else if (accountService.checkRole("EMPLOYEE", request) || accountService.checkRole("ADMIN", request))
                response.sendRedirect("/employee");
        }
    }
    
}
