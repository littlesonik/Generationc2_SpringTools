package cl.securityApp.web.services;

import java.util.Optional;

import cl.securityApp.web.models.User;

public interface UserService  {

    public Optional<User> getUserById(Long id);
    
}
