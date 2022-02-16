package com.example.ex4.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*default scope of this Bean is "singleton"*/
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String search);
    List<User> findByPswd(String password);
    //List<User> findByName(String name);
}

