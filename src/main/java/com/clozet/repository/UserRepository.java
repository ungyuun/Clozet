package com.clozet.repository;


import com.clozet.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
//    Optional<Object> findByEmail(String email);
    User findByKakaoEmail(String email);

//    User findByUserId(String userId);

//    User findByUsername(String username);
//    Optional<User> findByUsername(String username);
//    Optional<User> findByKakaoId(Long kakaoId);
}