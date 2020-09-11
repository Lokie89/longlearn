package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudyTest {

    Study study = new DebateStudy(5);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void involve() {
        study.involve(new Volunteer(new Member(3)));
    }

    @Test
    void debateStudyTest(){

    }
}