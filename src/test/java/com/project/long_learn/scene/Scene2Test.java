package com.project.long_learn.scene;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.StudyLocation;
import com.project.long_learn.condition.VolunteerCondition;
import com.project.long_learn.condition.exception.StudyStudentArrangeException;
import com.project.long_learn.condition.exception.StudyTeacherArrangeException;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

public class Scene2Test {
    // SCENE #2 Test
    Study study;
    Volunteer student1;
    Volunteer student2;
    Volunteer student3;
    Volunteer student4;
    Volunteer student5;
    Volunteer student6;
    Volunteer student7;
    Volunteer student8;
    Volunteer student9;
    Volunteer teacher1;
    Volunteer teacher2;

    @BeforeEach
    void setUp() {
        study = new Study(6, new StudyCondition.Builder()
                .recruitmentLimit(2120, 9, 20, 00, 00)
                .start(2120, 9, 30)
                .end(2120, 10, 30)
                .costPerClass(5000)
                .minTeacher(1)
                .maxTeacher(1)
                .minStudent(6)
                .maxStudent(8)
                .location(StudyLocation.of("홍대역 땡땡스터디룸"))
                .day(StudyDay.of(DayOfWeek.MONDAY, 19, 00, 21, 00), StudyDay.of(DayOfWeek.TUESDAY, 19, 00, 21, 00))
                .description("책은 땡땡쿠버네티스로 하겠습니다.\n 첫 수업은 맛보기 입니다.")
                .master(new Member(1))
                .build());

        student1 = new Volunteer(new Member(1), VolunteerCondition.of(VolunteerRole.STUDENT));
        student2 = new Volunteer(new Member(2), VolunteerCondition.of(VolunteerRole.STUDENT));
        student3 = new Volunteer(new Member(3), VolunteerCondition.of(VolunteerRole.STUDENT));
        student4 = new Volunteer(new Member(4), VolunteerCondition.of(VolunteerRole.STUDENT));
        student5 = new Volunteer(new Member(5), VolunteerCondition.of(VolunteerRole.STUDENT));
        student6 = new Volunteer(new Member(6), VolunteerCondition.of(VolunteerRole.STUDENT));
        student7 = new Volunteer(new Member(7), VolunteerCondition.of(VolunteerRole.STUDENT));
        student8 = new Volunteer(new Member(8), VolunteerCondition.of(VolunteerRole.STUDENT));
        student9 = new Volunteer(new Member(9), VolunteerCondition.of(VolunteerRole.STUDENT));
        teacher1 = new Volunteer(new Member(10), VolunteerCondition.of(VolunteerRole.TEACHER));
        teacher2 = new Volunteer(new Member(11), VolunteerCondition.of(VolunteerRole.TEACHER));

        study.involve(student1);
        study.involve(student2);
        study.involve(student3);
        study.involve(student4);
        study.involve(student5);
        study.involve(student6);
        study.involve(student7);
        study.involve(student8);
        study.involve(student9);
        study.involve(teacher1);
        study.involve(teacher2);

        study.pass(student1);
        study.pass(student2);
        study.pass(student3);
        study.pass(student4);
        study.pass(student5);
        study.pass(student6);
        study.pass(student7);
        study.pass(student8);
        study.pass(student9);
        study.pass(teacher1);
        study.pass(teacher2);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void scene2_1() {
        Assertions.assertThrows(StudyStudentArrangeException.class, () -> study.expireApplication());
        study.fail(student2);
        study.fail(student3);
        Assertions.assertThrows(StudyTeacherArrangeException.class, () -> study.expireApplication());
        study.fail(teacher1);
        study.expireApplication();
    }

    @Test
    void scene2_2() {
    }

    @Test
    void scene2_3() {
    }

    @Test
    void scene2_4() {
    }
}
