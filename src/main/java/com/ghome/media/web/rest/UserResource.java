package com.ghome.media.web.rest;

import com.ghome.media.service.authentication.UserDao;
import com.ghome.media.service.authentication.model.User;
import com.ghome.media.web.rest.model.UserDto;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/user")
@Component
public class UserResource {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getAll() {
        List<User> users = userDao.getAll();

        List<UserDto> dtos = new ArrayList<UserDto>();

        for (User user : users) {
            dtos.add(mapper.map(user, UserDto.class));
        }

        return dtos;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(UserDto userDto) {
        User user = userDao.get(new Long(userDto.getId()));
        mapper.map(userDto, user);
        return Response.ok().build();
    }
}
