package com.project.long_learn.domain.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberTest {

    @Test
    public void 리포팅() {
        Member member1 = new Member.Builder().name("이름").build();
        member1.report();
        member1.report();
        Member member2 = new Member.Builder().name("이름").reporting(2).build();
        assertEquals(member2, member1);
    }
}
