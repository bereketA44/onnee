package com.app.onnee.repository;

import com.app.onnee.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query("SELECT p FROM User_profile p where p.user.id =:userId")
    public Profile getProfileByUserId(@Param("userId") Long userId);
}
