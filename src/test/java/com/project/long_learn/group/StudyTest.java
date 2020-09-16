package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.StudyInformation;
import com.project.long_learn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

class StudyTest {

    Study study = new Study(5, new StudyInformation.Builder(LocalDate.now(), LocalDate.now(), new HashSet<>(), new StudyLocation()).build());

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void involve() {
        study.involve(new Volunteer(new Member(3), VolunteerRole.STUDENT));
    }

    @Test
    void debateStudyTest() {

    }
}