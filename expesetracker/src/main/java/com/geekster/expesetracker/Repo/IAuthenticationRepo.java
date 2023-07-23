package com.geekster.expesetracker.Repo;

import com.geekster.expesetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<com.geekster.InstaBackend.model.AuthenticationToken,Long> {


    com.geekster.InstaBackend.model.AuthenticationToken findFirstByTokenValue(String authTokenValue);

    com.geekster.InstaBackend.model.AuthenticationToken findFirstByUser(User user);
}
