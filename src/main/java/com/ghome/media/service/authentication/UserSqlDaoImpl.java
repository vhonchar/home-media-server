package com.ghome.media.service.authentication;

import com.ghome.media.service.authentication.model.User;
import com.ghome.media.service.jpa.CrudDaoImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class UserSqlDaoImpl extends CrudDaoImpl<User, Long> implements UserDao, UserDetailsService {

    public UserSqlDaoImpl() {
        super(User.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            return (User) entityManager
                    .createQuery("select u from User u where u.login = :login")
                    .setParameter("login", username)
                    .getSingleResult();
        } catch (NoResultException noResult) {
            throw new UsernameNotFoundException(username + " not found", noResult);
        }

    }
}
