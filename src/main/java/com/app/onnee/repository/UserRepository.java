package com.app.onnee.repository;

import com.app.onnee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u where u.username=:username")
    public Optional<User> getUserByUsername(@Param("username") String username);
}
