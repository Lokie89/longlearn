package com.project.long_learn.group;

import com.project.long_learn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudyTest {

    Group study = new Study();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void involve() {
        study.involve(new Member());
    }
}