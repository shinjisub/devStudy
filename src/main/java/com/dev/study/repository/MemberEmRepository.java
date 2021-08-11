package com.dev.study.repository;

import com.dev.study.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class MemberEmRepository {

//    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    //### 객체주입
    public MemberEmRepository(EntityManagerFactory entityManagerFactory) {
        em = entityManagerFactory.createEntityManager();
        et = em.getTransaction();
        et.begin();
    }

    public void saved(Member member) {
        em.persist(member);
    }

    public Member findById(long id) {
        return em.createQuery("select m from Member m where m.id = :memberId", Member.class).setParameter("memberId", id).getSingleResult();
    }
}
