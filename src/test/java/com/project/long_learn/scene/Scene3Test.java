package com.project.long_learn.scene;

import com.project.long_learn.alignable.Alignable;
import com.project.long_learn.alignable.StudyList;
import com.project.long_learn.condition.*;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import com.project.long_learn.text.Message;
import com.project.long_learn.text.Text;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Scene3Test {
    Member stockStudyMaster = new Member(67);
    Study stockStudy = new Study(5, new StudyCondition.EssentialBuilder(
            stockStudyMaster,
            2020, 10, 13,
            2020, 11, 13,
            2020, 10, 12, 5, 30,
            new StudyDays(StudyDay.of(DayOfWeek.SUNDAY)),
            new Locations(Location.of("강남"))
    )
            .maxTeacher(1)
            .minStudent(5)
            .maxStudent(5)
            .description("주식 프로그래밍 스터디 입니다.")
            .costPerClass(5000));

    Study diveStudy = new Study(95, new StudyCondition.EssentialBuilder(
            new Member(77),
            LocalDate.of(2020, 11, 1),
            LocalDate.of(2020, 11, 30),
            LocalDateTime.of(2020, 10, 30, 8, 30),
            new StudyDays(StudyDay.of(DayOfWeek.SATURDAY)),
            new Locations(Location.of("성남"))
    )
            .maxTeacher(3)
            .minStudent(10)
            .maxStudent(15)
            .description("스쿠버 다이빙 스터디입니다.")
            .costPerClass(50000));

    Study skiStudy = new Study(178, new StudyCondition.EssentialBuilder(
            new Member(8744),
            2020, 11, 30,
            2020, 12, 30,
            2020, 11, 15, 0, 0,
            new StudyDays(StudyDay.of(DayOfWeek.FRIDAY)),
            new Locations(Location.of("용인"))
    )
            .maxTeacher(3)
            .minStudent(6)
            .maxStudent(9)
            .description("스키 스터디입니다.")
            .costPerClass(45000));


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
        Assertions.assertEquals(studyList.size(), 2);
        studyList.filter(new StudyCondition.Builder().locations(Location.of("강남"), Location.of("성남")).build());
        Assertions.assertEquals(studyList.size(), 2);
        studyList.filter(new StudyCondition.Builder().description("주식").build());
        Assertions.assertEquals(studyList.size(), 1);
        Member member = new Member(957114);
        Text message = new Message(member, stockStudyMaster, "주식 관련 프로그래밍이라고 하셨는데 프로그래밍은 어떤 걸 말씀하시는 건가요?");
        message.text();
    }
}
