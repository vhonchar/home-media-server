package com.ghome.media.beanconverters;

import com.ghome.media.service.authentication.model.Authority;
import com.ghome.media.service.authentication.model.User;
import com.ghome.media.web.rest.model.UserDto;
import org.dozer.DozerConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserDtoConverter extends DozerConverter<User, UserDto> {

    public UserToUserDtoConverter() {
        super(User.class, UserDto.class);
    }

    @Override
    public UserDto convertTo(User source, UserDto dest) {
        if (dest == null) {
            dest = new UserDto();
        }

        dest.setId(source.getId().toString());
        dest.setLogin(source.getUsername());
        dest.setRoles(toString(source.getRoles()));

        return dest;
    }

    private List<String> toString(List<Authority> roles) {
        List<String> stringRoles = new ArrayList<>();
        for (Authority authority : roles) {
            stringRoles.add(authority.getAuthority());
        }
        return stringRoles;
    }

    @Override
    public User convertFrom(UserDto source, User dest) {
        if (dest == null) {
            dest = new User();
        }

        dest.setId(new Long(source.getId()));
        dest.setLogin(source.getLogin());
        dest.getAuthorities().clear();
        dest.getAuthorities().addAll(toAuthorities(dest, source.getRoles()));

        return dest;
    }

    private List<Authority> toAuthorities(User user, List<String> roles) {
        List<Authority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new Authority(user, role));
        }
        return authorities;
    }
}
