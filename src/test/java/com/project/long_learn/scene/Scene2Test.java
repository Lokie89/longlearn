package com.project.long_learn.scene;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.StudyLocation;
import com.project.long_learn.condition.VolunteerCondition;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

public class Scene2Test {
    // SCENE #2 Test
    Study study;

    @BeforeEach
    void setUp() {
        study = new Study(6, new StudyCondition.Builder()
                .recruitmentLimit(2020, 9, 20, 00, 00)
                .start(2020, 9, 30)
                .end(2020, 10, 30)
                .costPerClass(5000)
                .minTeacher(1)
                .minStudent(6)
                .maxStudent(8)
                .location(StudyLocation.of("홍대역 땡땡스터디룸"))
                .day(StudyDay.of(DayOfWeek.MONDAY, 19, 00, 21, 00), StudyDay.of(DayOfWeek.TUESDAY, 19, 00, 21, 00))
                .description("책은 땡땡쿠버네티스로 하겠습니다.\n 첫 수업은 맛보기 입니다.")
                .build());
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void scene2_1() {
        Volunteer student1 = new Volunteer(new Member(1), VolunteerCondition.of(VolunteerRole.STUDENT));
        Volunteer student2 = new Volunteer(new Member(2), VolunteerCondition.of(VolunteerRole.STUDENT));
        Volunteer student3 = new Volunteer(new Member(3), VolunteerCondition.of(VolunteerRole.STUDENT));
        Volunteer student4 = new Volunteer(new Member(4), VolunteerCondition.of(VolunteerRole.STUDENT));
        Volunteer student5 = new Volunteer(new Member(5), VolunteerCondition.of(VolunteerRole.STUDENT));
        Volunteer student6 = new Volunteer(new Member(6), VolunteerCondition.of(VolunteerRole.STUDENT));
        Volunteer student7 = new Volunteer(new Member(7), VolunteerCondition.of(VolunteerRole.STUDENT));
        Volunteer student8 = new Volunteer(new Member(8), VolunteerCondition.of(VolunteerRole.STUDENT));
        Volunteer student9 = new Volunteer(new Member(9), VolunteerCondition.of(VolunteerRole.STUDENT));
        Volunteer teacher1 = new Volunteer(new Member(10), VolunteerCondition.of(VolunteerRole.TEACHER));
        Volunteer teacher2 = new Volunteer(new Member(11), VolunteerCondition.of(VolunteerRole.TEACHER));

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
