package com.geekster.expesetracker.Repo;

import com.geekster.expesetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String newEmail);
}
