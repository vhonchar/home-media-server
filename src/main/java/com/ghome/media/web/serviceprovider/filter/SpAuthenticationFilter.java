package com.ghome.media.web.serviceprovider.filter;

import com.ghome.media.web.Constants;
import com.ghome.media.web.serviceprovider.model.SpUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class SpAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SpUser user = (SpUser) request.getAttribute(Constants.SSO.UNMARSHALED_TOKEN_PROPERTY);
        if(user != null){
            SecurityContextHolder.getContext().setAuthentication(user);
        }

        chain.doFilter(request, response);
    }
}
