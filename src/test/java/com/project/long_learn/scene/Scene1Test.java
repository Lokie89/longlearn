package com.project.long_learn.scene;

import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.group.*;
import com.project.long_learn.grouplist.GroupList;
import com.project.long_learn.grouplist.StudyList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Scene1Test {
    // SCENE #1 Test
    GroupList studyList;

    @BeforeEach
    void setUp() {
        List<Study> groupList = new ArrayList<>();
        StudyCondition.Builder dumpBuilder = new StudyCondition.Builder()
                .start(LocalDate.of(2020, 9, 10))
                .end(LocalDate.of(2020, 10, 10))
                .description("Dump Study")
                .location(new StudyLocation(1, 1, "강남"))
                .costPerClass(15000)
                .minStudent(4)
                .maxStudent(10)
                .minTeacher(0)
                .maxTeacher(5)
                .recruitmentLimit(LocalDateTime.of(2020, 9, 25, 0, 0))
                .studyDay(new StudyDays(new StudyDay(DayOfWeek.SUNDAY, LocalTime.NOON), new StudyDay(DayOfWeek.TUESDAY, LocalTime.of(19, 30))));

        for (int i = 0; i < 100; i++) {
            groupList.add(new Study(i, dumpBuilder.build()));
        }

        Study flowerStudy = new Study(101,
                new StudyCondition.Builder()
                        .start(LocalDate.of(2020, 9, 30))
                        .end(LocalDate.of(2020, 11, 30))
                        .costPerClass(10000)
                        .recruitmentLimit(LocalDateTime.of(2020, 9, 22, 0, 0))
                        .description("꽃꽂이 클래스")
                        .minTeacher(1)
                        .location(new StudyLocation(127.3534, 39.78144,"강남역"))
                        .studyDay(new StudyDays(new StudyDay(DayOfWeek.MONDAY,LocalTime.of(19,00)),new StudyDay(DayOfWeek.TUESDAY,LocalTime.of(19,00))))
                        .build());

        groupList.add(flowerStudy);
        studyList = new StudyList(groupList);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void scene1() {
        StudyCondition filterCondition
                = new StudyCondition.Builder()
                .description("꽃꽂이")
                .location(new StudyLocation("강남"))
                .minTeacher(1)
                .studyDay(new StudyDays(new StudyDay(DayOfWeek.MONDAY,LocalTime.of(19,00)),new StudyDay(DayOfWeek.TUESDAY,LocalTime.of(19,00))))
        .build();
        Assertions.assertTrue(studyList.size()==101);
        Assertions.assertTrue(studyList.filter(filterCondition).size()==1);
    }
}
