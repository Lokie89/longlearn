package com.project.long_learn.apply;

import com.project.long_learn.domain.Member;
import com.project.long_learn.group.LectureStudy;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class VolunteerTest {

    Apply volunteer = new Volunteer(new Member(3), VolunteerRole.TEACHER);
    Study study = new LectureStudy(6);

    @BeforeEach
    void setUp() {
        volunteer.apply(study);
        study.isContain(volunteer);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void apply() {
    }

    @Test
    void refrain(){
        volunteer.refrain(study);
    }
}