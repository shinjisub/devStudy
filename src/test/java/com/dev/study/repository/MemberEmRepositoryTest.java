package com.dev.study.repository;

import com.dev.study.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class MemberEmRepositoryTest {

    @Autowired
    private MemberEmRepository notAnnotionRepository;

    @Autowired
    private MemberEmAnnotionRepository annotionRepository;

    @Autowired
    private MemberJpaRepository jpaRepository;



    @Test
    public void notAnnotionSave() {
        //### Insert
        Member member = Member.builder()
                .name("Not홍길동")
                .age(29)
                .addr1("경기도 부천시 지양로 158번길 19")
                .addr2("34473")
                .build();
        notAnnotionRepository.saved(member);
        Member findMember = notAnnotionRepository.findById(member.getId());

        //### 검증
        Assertions.assertThat("Not홍길동").isEqualTo(member.getName());
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
    }

    @Test
    public void annotionSave() {
        //### Insert
        Member member = Member.builder()
                .name("홍길동")
                .age(29)
                .addr1("경기도 부천시 지양로 158번길 19")
                .addr2("34473")
                .build();
        notAnnotionRepository.saved(member);
        Member findMember = notAnnotionRepository.findById(member.getId());

        //### 검증
        Assertions.assertThat("홍길동").isEqualTo(member.getName());
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
    }

    @Test
    public void jpaSave() {
        Member member = Member.builder()
                .name("Spring Data JPA 홍길동")
                .age(29)
                .addr1("경기도 부천시 지양로 158번길 19")
                .addr2("34473")
                .build();
        jpaRepository.save(member);

        //### 검증
        Optional<Member> findMember = jpaRepository.findById(member.getId());
        Assertions.assertThat(member.getName()).isEqualTo(findMember.get().getName());
        Assertions.assertThat(member.getId()).isEqualTo(findMember.get().getId());
    }

}