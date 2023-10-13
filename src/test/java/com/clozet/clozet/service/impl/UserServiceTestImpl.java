package com.clozet.clozet.service.impl;


import com.clozet.clozet.service.UserServiceTest;
import com.clozet.model.entity.User;
import com.clozet.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestImpl implements UserServiceTest {
    @Autowired
    private UserService userService;




    @Test
    public void addUser() throws Exception {

        UserDto userDto = UserDto.builder()
                .userId("tjddbs6262")
                .email("sungyuun@naver.com")
                .password("tjddbs6262")
                .phone("01089114554")
                .role("admin")
                .userName("김성윤")
                .regDate(new java.sql.Date(new java.util.Date().getTime()))
                .build();

        userService.addUser(userDto);
    }



    @Override
    @Test
    public void getUser() throws Exception {
        UserDto userDto = UserDto.builder()
                .userId("tjddbs6262")
                .email("sungyuun@naver.com")
                .password("tjddbs6262")
                .phone("01089114554")
                .role("admin")
                .userName("김성윤")
                .regDate(new java.sql.Date(new java.util.Date().getTime()))
                .build();

        userDto = userService.getUser(userDto);
        System.out.println("hello"+userDto.getUserId());
        assertEquals(userDto.getUserId(), "tjddbs6262");
    }

    @Override
    @Test
    public void getUserList() throws Exception {
        Pageable page = PageRequest.of(0, 10);
        List<User> totalPage = userService.getUserList(page);
        for(User user : totalPage) {
            System.out.println(user.getUserId());
        }
    }

    @Override
    public void updateUser() throws Exception {

    }

    @Override
    public void checkDuplication() throws Exception {

    }
}
