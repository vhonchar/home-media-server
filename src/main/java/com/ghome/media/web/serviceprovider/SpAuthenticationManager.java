package com.ghome.media.web.serviceprovider;

import com.ghome.media.web.serviceprovider.model.SpUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * Service Provider Authentication Manager
 *
 * This authentication is trust to the incoming principals,
 * assuming that they were approved by the IDP service.
 *
 * For trusting SP and IDP services should communicate via secure protocol
 */
@Component
public class SpAuthenticationManager implements AuthenticationProvider {

    /**
     * Check that token has't been expired, if not throw TODO: something like TokenExpireException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return authentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(SpUser.class);
    }
}
