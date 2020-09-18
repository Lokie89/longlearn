package com.project.long_learn.group;

import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.grouplist.StudyList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudyConditionTest {

    List<Study> studyList;

    StudyCondition.Builder defaultBuilder = new StudyCondition.Builder().start(LocalDate.now()).end(LocalDate.now()).studyDay(new StudyDays(new StudyDay(DayOfWeek.FRIDAY, LocalTime.NOON))).location(new StudyLocation(1,1,"강남"));
    Study sortStudy = new Study(2, defaultBuilder.minStudent(3).build());

    StudyCondition defaultStudyCondition = defaultBuilder.build();

    @BeforeEach
    void setUp() {
        studyList = new ArrayList<>();
        studyList.add(new Study(1, defaultBuilder.description("안녕").build()));
        studyList.add(sortStudy);
        studyList.add(new Study(3, defaultStudyCondition));
        studyList.add(new Study(4, defaultStudyCondition));
        studyList.add(new Study(5, defaultStudyCondition));
        studyList.add(new Study(6, defaultStudyCondition));
        studyList.add(new Study(7, defaultStudyCondition));
        studyList.add(new Study(8, defaultStudyCondition));
        studyList.add(new Study(9, defaultStudyCondition));
        studyList.add(new Study(10, defaultStudyCondition));
        studyList.add(new Study(11, defaultStudyCondition));
        studyList.add(new Study(12, defaultStudyCondition));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void filterTest() {
        StudyList groupList = new StudyList(studyList);
        groupList.filter(new StudyCondition.Builder().description("안녕").build());
        assertTrue(groupList.size() == 1);
    }

    @Test
    void filterTest2() {
        StudyList groupList = new StudyList(studyList);
        groupList.filter(defaultBuilder.minStudent(2).build());
        assertEquals(groupList.size(), 1);
    }

    @Test
    void sortTest1() {
        StudyList groupList = new StudyList(studyList);
        groupList.sort(StudyCondition.StudyInformationComparator.MINSTUDENT);
    }

}