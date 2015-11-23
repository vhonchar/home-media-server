package com.ghome.media.web.identityprovider;

import com.ghome.media.web.json.JsonUtils;
import com.ghome.media.web.serviceprovider.model.SpUser;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Component
@Path("/token")
@Produces(MediaType.APPLICATION_JSON)
public class TokenResource {

    @Autowired
    @Qualifier("idpAuthenticationManager")
    private AuthenticationManager authenticationManager;

    private static final Gson GSON = JsonUtils.createGson();;

    @POST
    public Response create(@FormParam("login")String login, @FormParam("password") String password){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
        if(authentication == null){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        SpUser user = createDto((User)authentication.getPrincipal());
        return Response.ok().entity(GSON.toJson(user)).build();
    }

    private SpUser createDto(User user) {
        SpUser dto = new SpUser();

        dto.setName(user.getUsername());
        dto.setTtl("15");
        dto.setCreationDate(new Date().toString());
        dto.setGrantedAuthorities(user.getAuthorities());

        return dto;
    }

    @GET
    public String ping(){
        return "Hello";
    }
}
