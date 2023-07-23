package com.geekster.expesetracker.Service;

import com.geekster.expesetracker.Repo.IAuthenticationRepo;
import com.geekster.expesetracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo authenticationRepo;

    public boolean authenticate(String email, String authTokenValue)
    {
        com.geekster.InstaBackend.model.AuthenticationToken authToken = authenticationRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getUser().getUserEmail();

        return tokenConnectedEmail.equals(email);
    }

    public void saveAuthToken(com.geekster.InstaBackend.model.AuthenticationToken authToken)
    {
        authenticationRepo.save(authToken);
    }

    public com.geekster.InstaBackend.model.AuthenticationToken findFirstByUser(User user) {
        return authenticationRepo.findFirstByUser(user);
    }

    public void removeToken(com.geekster.InstaBackend.model.AuthenticationToken token) {
        authenticationRepo.delete(token);
    }
}
