package com.dev.study.repository;

import com.dev.study.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberEmAnnotionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void saved(Member member) {
        entityManager.persist(member);
    }

    public Member findByid(long id) {
        return entityManager.createQuery("select m from Member m where m.id = :memberId", Member.class).setParameter("memberId", id).getSingleResult();
    }

}
