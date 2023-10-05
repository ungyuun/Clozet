package com.clozet.clozet.repository;

import com.clozet.model.entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import java.util.List;
@SpringBootTest
@RunWith(SpringRunner.class)
public interface UserRepositoryTest extends JpaRepository<User,String> {

    User findByUserId(String userId);

    List<User> findAllByUserId(String searchKeyword);

    List<User> findAllByUserName(String searchKeyword);
}