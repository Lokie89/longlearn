package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.StudyDays;
import com.project.long_learn.condition.StudyLocation;
import com.project.long_learn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

class StudyTest {

    StudyCondition.Builder defaultBuilder = new StudyCondition.Builder().start(LocalDate.now()).end(LocalDate.now()).studyDay(new StudyDays(new StudyDay(DayOfWeek.FRIDAY, LocalTime.NOON))).location(new StudyLocation(1, 1, "강남"));
    Study study = new Study(5, defaultBuilder.maxStudent(3).build());

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
    void cannotApplyStudyException() {
        Volunteer volunteer1 = new Volunteer(new Member(1), VolunteerRole.STUDENT);
        Volunteer volunteer2 = new Volunteer(new Member(2), VolunteerRole.STUDENT);
        Volunteer volunteer3 = new Volunteer(new Member(3), VolunteerRole.STUDENT);
        Volunteer volunteer4 = new Volunteer(new Member(4), VolunteerRole.STUDENT);

        study.involve(volunteer1);
        study.involve(volunteer2);
        study.involve(volunteer3);
        Assertions.assertThrows(CannotApplyStudyException.class, () -> study.involve(volunteer4));
        study.except(volunteer1);
        study.involve(volunteer4);
    }

    @Test
    void alreadyApplyVolunteerException() {
        Volunteer volunteer1 = new Volunteer(new Member(1), VolunteerRole.STUDENT);
        Volunteer volunteer2 = new Volunteer(new Member(1), VolunteerRole.STUDENT);

        study.involve(volunteer1);
        Assertions.assertThrows(AlreadyApplyVolunteerException.class, () -> study.involve(volunteer2));

        study.except(volunteer1);
        study.involve(volunteer2);

        Assertions.assertThrows(AlreadyApplyVolunteerException.class, () -> study.involve(volunteer2));
    }

    @Test
    void enoughTeacherTest(){
        Study study = new Study(5, defaultBuilder.maxStudent(3).minTeacher(1).build());
        Volunteer volunteer1 = new Volunteer(new Member(1), VolunteerRole.TEACHER);

        Volunteer volunteer2 = new Volunteer(new Member(2), VolunteerRole.TEACHER);

        study.involve(volunteer1);
        Assertions.assertThrows(CannotApplyStudyException.class, () -> study.involve(volunteer2));
    }
}