package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.StudyLocation;
import com.project.long_learn.condition.VolunteerCondition;
import com.project.long_learn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

class StudyTest {

    StudyCondition.Builder defaultBuilder = new StudyCondition.Builder().start(2120, 10, 21).end(2120, 11, 21).day(StudyDay.of(DayOfWeek.FRIDAY)).location(StudyLocation.of("강남")).recruitmentLimit(2120, 9, 21, 00, 00).master(new Member(1));
    Study study = new Study(5, defaultBuilder.maxStudent(3).build());

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void involve() {
        study.involve(new Volunteer(new Member(3), VolunteerCondition.of(VolunteerRole.STUDENT)));
    }

    @Test
    void alreadyApplyVolunteerException() {
        Volunteer volunteer1 = new Volunteer(new Member(1), VolunteerCondition.of(VolunteerRole.STUDENT));
        Volunteer volunteer2 = new Volunteer(new Member(1), VolunteerCondition.of(VolunteerRole.STUDENT));

        study.involve(volunteer1);
        Assertions.assertThrows(AlreadyApplyVolunteerException.class, () -> study.involve(volunteer2));

        study.except(volunteer1);
        study.involve(volunteer2);

        Assertions.assertThrows(AlreadyApplyVolunteerException.class, () -> study.involve(volunteer2));
    }

}