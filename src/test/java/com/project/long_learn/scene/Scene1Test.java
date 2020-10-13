package com.project.long_learn.scene;

import com.project.long_learn.alignable.Alignable;
import com.project.long_learn.alignable.StudyList;
import com.project.long_learn.condition.*;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Scene1Test {
    // SCENE #1 Test
    Alignable studyList;

    @BeforeEach
    void setUp() {
        List<Study> groupList = new ArrayList<>();
        StudyCondition.EssentialBuilder dumpBuilder = new StudyCondition.EssentialBuilder(
                new Member(1),
                LocalDate.of(2120, 10, 21),
                LocalDate.of(2120, 11, 21),
                LocalDateTime.of(2120, 9, 21, 00, 00),
                new StudyDays(StudyDay.of(DayOfWeek.SUNDAY), StudyDay.of(DayOfWeek.TUESDAY)),
                new Locations(Location.of("강남"))
        )
                .description("Dump Study")
                .costPerClass(15000)
                .minStudent(4)
                .maxStudent(10)
                .minTeacher(0)
                .maxTeacher(5);

        for (int i = 0; i < 100; i++) {
            groupList.add(new Study(i, dumpBuilder));
        }

        Study flowerStudy = new Study(101,
                new StudyCondition.EssentialBuilder(
                        new Member(3),
                        2120, 10, 28,
                        2120, 11, 28,
                        2120, 9, 28, 00, 00,
                        new StudyDays(StudyDay.of(DayOfWeek.MONDAY, 19, 00, 21, 00), StudyDay.of(DayOfWeek.TUESDAY, 19, 00, 20, 00)),
                        new Locations(Location.of("강남역"))
                )
                        .costPerClass(10000)
                        .description("꽃꽂이 클래스")
                        .minTeacher(1)
                        .maxTeacher(1));

        groupList.add(flowerStudy);
        studyList = new StudyList(groupList);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void scene1_1() {
        StudyCondition filterCondition
                = new StudyCondition.Builder()
                .description("꽃꽂이")
                .locations(Location.of("강남"))
                .minTeacher(1)
                .day(StudyDay.of(DayOfWeek.MONDAY, 19, 00, 21, 00), StudyDay.of(DayOfWeek.TUESDAY, 19, 00, 20, 00))
                .build();
        Assertions.assertTrue(studyList.size() == 101);
        Assertions.assertTrue(studyList.filter(filterCondition).size() == 1);
    }

    @Test
    void scene1_2() {
        StudyCondition filterCondition
                = new StudyCondition.Builder()
                .description("꽃꽂이")
                .build();
        Assertions.assertTrue(studyList.size() == 101);
        Assertions.assertTrue(studyList.filter(filterCondition).size() == 1);
    }

    @Test
    void scene1_3() {
        StudyCondition filterCondition
                = new StudyCondition.Builder()
                .day(StudyDay.of(DayOfWeek.MONDAY, 19, 00, 21, 00), StudyDay.of(DayOfWeek.TUESDAY, 19, 00, 20, 00))
                .build();
        Assertions.assertTrue(studyList.size() == 101);
        Assertions.assertTrue(studyList.filter(filterCondition).size() == 1);
    }

    @Test
    void scene1_4() {
        StudyCondition filterCondition
                = new StudyCondition.Builder()
                .locations(Location.of("강남역"))
                .build();
        Assertions.assertTrue(studyList.size() == 101);
        Assertions.assertTrue(studyList.filter(filterCondition).size() == 1);
    }
}
