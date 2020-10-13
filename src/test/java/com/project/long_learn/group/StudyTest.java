package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.*;
import com.project.long_learn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

class StudyTest {

    StudyCondition.EssentialBuilder defaultBuilder = new StudyCondition.EssentialBuilder(
            new Member(1),
            2120, 10, 21,
            2120, 11, 21,
            2120, 9, 21, 00, 00,
            new StudyDays(StudyDay.of(DayOfWeek.FRIDAY)),
            new Locations(Location.of("강남"))
    );
    Study study = new Study(5, defaultBuilder.maxStudent(3));

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