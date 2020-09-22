package com.project.long_learn.scene;

import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.StudyDays;
import com.project.long_learn.condition.StudyLocation;
import com.project.long_learn.group.Study;
import com.project.long_learn.grouplist.GroupList;
import com.project.long_learn.grouplist.StudyList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Scene1Test {
    // SCENE #1 Test
    GroupList studyList;

    @BeforeEach
    void setUp() {
        List<Study> groupList = new ArrayList<>();
        StudyCondition.Builder dumpBuilder = new StudyCondition.Builder()
                .start(2020,9,22)
                .end(2020,9,22)
                .description("Dump Study")
                .location(StudyLocation.of("강남"))
                .costPerClass(15000)
                .minStudent(4)
                .maxStudent(10)
                .minTeacher(0)
                .maxTeacher(5)
                .recruitmentLimit(2020,9,21,00,00)
                .studyDay(StudyDay.of(DayOfWeek.SUNDAY), StudyDay.of(DayOfWeek.TUESDAY));

        for (int i = 0; i < 100; i++) {
            groupList.add(new Study(i, dumpBuilder.build()));
        }

        Study flowerStudy = new Study(101,
                new StudyCondition.Builder()
                        .start(2020,9,30)
                        .end(2020, 11, 30)
                        .costPerClass(10000)
                        .recruitmentLimit(2020,9,28,00,00)
                        .description("꽃꽂이 클래스")
                        .minTeacher(1)
                        .location(StudyLocation.of("강남역"))
                        .studyDay(StudyDay.of(DayOfWeek.MONDAY, 19, 00, 21, 00), StudyDay.of(DayOfWeek.TUESDAY, 19, 00, 20, 00))
                        .build());

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
                .location(StudyLocation.of("강남"))
                .minTeacher(1)
                .studyDay(StudyDay.of(DayOfWeek.MONDAY, 19, 00, 21, 00), StudyDay.of(DayOfWeek.TUESDAY, 19, 00, 20, 00))
                .build();
        Assertions.assertTrue(studyList.size() == 101);
        Assertions.assertTrue(studyList.filter(filterCondition).size() == 1);
    }

    @Test
    void scene1_2(){
        StudyCondition filterCondition
                = new StudyCondition.Builder()
                .description("꽃꽂이")
                .build();
        Assertions.assertTrue(studyList.size() == 101);
        Assertions.assertTrue(studyList.filter(filterCondition).size() == 1);
    }

    @Test
    void scene1_3(){
        StudyCondition filterCondition
                = new StudyCondition.Builder()
                .studyDay(StudyDay.of(DayOfWeek.MONDAY, 19, 00, 21, 00), StudyDay.of(DayOfWeek.TUESDAY, 19, 00, 20, 00))
                .build();
        Assertions.assertTrue(studyList.size() == 101);
        Assertions.assertTrue(studyList.filter(filterCondition).size() == 1);
    }

    @Test
    void scene1_4(){
        StudyCondition filterCondition
                = new StudyCondition.Builder()
                .location(StudyLocation.of("강남역"))
                .build();
        Assertions.assertTrue(studyList.size() == 101);
        Assertions.assertTrue(studyList.filter(filterCondition).size() == 1);
    }
}
