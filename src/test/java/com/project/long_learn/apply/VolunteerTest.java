package com.project.long_learn.apply;

import com.project.long_learn.condition.StudyInformation;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import com.project.long_learn.group.StudyLocation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class VolunteerTest {

    Volunteer volunteer = new Volunteer(new Member(3), VolunteerRole.TEACHER);
    Study study = new Study(6, new StudyInformation.Builder(LocalDate.now(), LocalDate.now(), new HashSet<>(), new StudyLocation()).build());

    @BeforeEach
    void setUp() {
        study.involve(volunteer);
        study.isContain(volunteer);
        assertTrue(study.isContainTeacher());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void apply() {
    }

    @Test
    void refrain() {
        study.except(volunteer);
        assertFalse(study.isContainTeacher());
    }
}