package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

class StudyTest {

    StudyCondition.Builder defaultBuilder = new StudyCondition.Builder().start(LocalDate.now()).end(LocalDate.now()).studyDay(new StudyDays(new StudyDay(DayOfWeek.FRIDAY, LocalTime.NOON))).location(new StudyLocation(1,1,"강남"));
    Study study = new Study(5, defaultBuilder.build());

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