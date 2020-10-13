package com.project.long_learn.apply;

import com.project.long_learn.condition.*;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;


class VolunteerTest {

    Volunteer volunteer = new Volunteer(new Member(3), VolunteerCondition.of(VolunteerRole.TEACHER));
    StudyCondition.EssentialBuilder defaultBuilder = new StudyCondition.EssentialBuilder(new Member(78), 2120, 10, 1, 2120, 11, 1, 2120, 9, 30, 0, 0, new StudyDays(StudyDay.of(DayOfWeek.FRIDAY)), new Locations(Location.of("강남")));
    Study study = new Study(6, defaultBuilder.minTeacher(3).maxTeacher(6));

    @BeforeEach
    void setUp() {
        study.involve(volunteer);
        Assertions.assertTrue(study.isContain(volunteer));
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
        Assertions.assertFalse(study.isContain(volunteer));
    }
}