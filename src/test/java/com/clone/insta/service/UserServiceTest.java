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
        UserInfo member = new UserInfo();
        member.setName("spring");
        //when
        Long saveId = userService.join(member);
        //then
        UserInfo findMember = userService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }
}
