package com.clone.insta.service;

import com.clone.insta.domain.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void join() {
        //given
        UserInfo user = new UserInfo();
        user.setName("spring");

        /*private String email;
        private String password="";;
        private String phone="";
        private String title="";
        private String website="";
        private String profileImgUrl="";*/

        //when
        Long saveId = userService.join(user);
        //then
        UserInfo findMember = userService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(user.getName()).isEqualTo(findMember.getName());
    }
}
