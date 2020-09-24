package com.project.long_learn.apply;

import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.StudyLocation;
import com.project.long_learn.condition.VolunteerCondition;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;


class VolunteerTest {

    Volunteer volunteer = new Volunteer(new Member(3), VolunteerCondition.of(VolunteerRole.TEACHER));
    StudyCondition.Builder defaultBuilder = new StudyCondition.Builder().start(2120, 10, 1).end(2120,11,1).day(StudyDay.of(DayOfWeek.FRIDAY)).location(StudyLocation.of("강남"));
    Study study = new Study(6, defaultBuilder.location(StudyLocation.of("강남")).minTeacher(3).maxTeacher(6).recruitmentLimit(2120,9,24,00,00).master(new Member(1)).build());

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