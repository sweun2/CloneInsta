package com.clone.insta.service;

import com.clone.insta.domain.UserInfo;
import com.clone.insta.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Long join(UserInfo userInfo) {
        //중복 이름 제거
        validateDuplicateMember(userInfo);
        userRepository.save(userInfo);
        return userInfo.getId();
    }

    private void validateDuplicateMember(UserInfo member) {
        userRepository.findByName(member.getName()).ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    /**
     * 전체회원 조회
     */
    public List<UserInfo> findMembers(){
        return userRepository.findAll();
    }

    public Optional<UserInfo> findOne(Long memberId){
        return userRepository.findById(memberId);
    }


}
