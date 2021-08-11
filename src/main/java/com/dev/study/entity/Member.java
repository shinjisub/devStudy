package com.dev.study.entity;

import lombok.Builder;
import lombok.Getter;
import javax.persistence.*;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private int age;
    private String addr1;
    private String addr2;


    @Builder
    public Member(String name, int age, String addr1, String addr2) {
        this.name = name;
        this.age = age;
        this.addr1 = addr1;
        this.addr2 = addr2;
    }

    public Member() {
    }
}
