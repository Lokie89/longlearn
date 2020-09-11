package com.project.long_learn.apply;

import com.project.long_learn.domain.Member;
import com.project.long_learn.group.LectureStudy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class VolunteerTest {

    Apply volunteer = new Volunteer(new Member(3));

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void apply() {
        volunteer.apply(new LectureStudy(6));
        assertTrue(volunteer.isApplied());
    }
}