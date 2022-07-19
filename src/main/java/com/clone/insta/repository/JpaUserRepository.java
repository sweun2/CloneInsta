package com.clone.insta.repository;


import com.clone.insta.domain.UserInfo;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public UserInfo save(UserInfo userInfo){
        em.persist(userInfo);
        return userInfo;
    }
    @Override

    public Optional<UserInfo> findByName(String name){
        List<UserInfo> result = em.createQuery("select m from UserInfo m where m.name = :name", UserInfo.class).setParameter("name", name).getResultList();
        return result.stream().findAny();
    }
    @Override
    public List<UserInfo> findAll(){
        return em.createQuery("select m from UserInfo m", UserInfo.class).getResultList();
    }
    @Override
    public Optional<UserInfo> findById(Long id){
        List<UserInfo> result = em.createQuery("select m from UserInfo m where m.id = :id", UserInfo.class).setParameter("id", id).getResultList();
        return result.stream().findAny();
    }
}
