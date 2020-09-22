package com.project.long_learn.apply;

import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.StudyDays;
import com.project.long_learn.condition.StudyLocation;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class VolunteerTest {

    Volunteer volunteer = new Volunteer(new Member(3), VolunteerRole.TEACHER);
    StudyCondition.Builder defaultBuilder = new StudyCondition.Builder().start(2020, 8, 18).end(2020,9,22).studyDay(new StudyDays(StudyDay.of(DayOfWeek.FRIDAY))).location(StudyLocation.of("강남"));
    Study study = new Study(6, defaultBuilder.location(StudyLocation.of("강남")).minTeacher(3).recruitmentLimit(2020,8,10,00,00).build());

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