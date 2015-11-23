package com.ghome.media.web.serviceprovider.filter;

import com.ghome.media.web.Constants;
import com.ghome.media.web.json.JsonUtils;
import com.ghome.media.web.serviceprovider.model.SpUser;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class SpTokenUnmarshallingFilter extends GenericFilterBean {

    private static final Gson GSON = JsonUtils.createGson();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String tokenInJson = getFromHeader((HttpServletRequest) request);

        if (tokenInJson == null) {
            tokenInJson = getFromCookie((HttpServletRequest) request);
        }

        if (!StringUtils.isEmpty(tokenInJson)) {
            SpUser user = GSON.fromJson(tokenInJson, SpUser.class);
            request.setAttribute(Constants.SSO.UNMARSHALED_TOKEN_PROPERTY, user);
        }

        chain.doFilter(request, response);
    }

    private String getFromHeader(HttpServletRequest request) {
        return request.getHeader(Constants.SSO.HTTP_HEADER_FOR_TOKEN);
    }

    private String getFromCookie(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(Constants.SSO.HTTP_HEADER_FOR_TOKEN)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
