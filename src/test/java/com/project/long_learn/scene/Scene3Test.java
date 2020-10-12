package com.project.long_learn.scene;

import com.project.long_learn.alignable.Alignable;
import com.project.long_learn.alignable.StudyList;
import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.Location;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;

public class Scene3Test {
    Member stockStudyMaster = new Member(67);
    Study stockStudy = new Study(5, new StudyCondition.Builder()
            .recruitmentLimit(2020, 10, 12, 5, 30)
            .master(stockStudyMaster)
            .maxTeacher(1)
            .minStudent(5)
            .maxStudent(5)
            .location(Location.of("강남"))
            .description("주식 프로그래밍 스터디 입니다.")
            .costPerClass(5000)
            .start(2020,10,13)
            .end(2020,11,13)
            .day(StudyDay.of(DayOfWeek.SUNDAY))
            .build());

    Study diveStudy = new Study(95, new StudyCondition.Builder()
            .recruitmentLimit(2020, 10, 30, 8, 30)
            .start(2020,11,1)
            .end(2020,11,30)
            .master(new Member(77))
            .maxTeacher(3)
            .minStudent(10)
            .maxStudent(15)
            .location(Location.of("성남"))
            .description("스쿠버 다이빙 스터디입니다.")
            .costPerClass(50000)
            .day(StudyDay.of(DayOfWeek.SATURDAY))
            .build());

    Study skiStudy = new Study(178, new StudyCondition.Builder()
            .recruitmentLimit(2020, 11, 15, 0, 0)
            .master(new Member(8744))
            .start(2020,11,30)
            .end(2020,12,30)
            .maxTeacher(3)
            .minStudent(6)
            .maxStudent(9)
            .location(Location.of("용인"))
            .description("스키 스터디입니다.")
            .costPerClass(45000)
            .day(StudyDay.of(DayOfWeek.FRIDAY))
            .build());


    Alignable<Study> studyList = new StudyList(new ArrayList<>(Arrays.asList(stockStudy, diveStudy, skiStudy)));

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void scene3_1() {
        studyList.filter(new StudyCondition.Builder().day(StudyDay.of(DayOfWeek.SATURDAY), StudyDay.of(DayOfWeek.SUNDAY)).build());
        Assertions.assertEquals(studyList.size(),2);
        studyList.filter(new StudyCondition.Builder().location(Location.of("강남")).build());
        Assertions.assertEquals(studyList.size(),1);
        Member member = new Member(957114);
        member.text(stockStudy,"주식 프로그래밍은 어떻게 하는 건가요?");
        member.text(stockStudyMaster,"주식 프로그래밍은 어떻게 하는 건가요?");

    }
}
