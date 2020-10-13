package com.project.long_learn.group;

import com.project.long_learn.condition.*;
import com.project.long_learn.alignable.StudyList;
import com.project.long_learn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudyConditionTest {

    List<Study> studyList;

    StudyCondition.EssentialBuilder defaultBuilder = new StudyCondition.EssentialBuilder(new Member(1),2120, 10, 24,2120, 11, 24,2120, 9, 24, 00, 00,new StudyDays(StudyDay.of(DayOfWeek.FRIDAY)),new Locations(Location.of("강남")));


    @BeforeEach
    void setUp() {
        studyList = new ArrayList<>();
        studyList.add(new Study(1, defaultBuilder.description("안녕")));
        studyList.add(new Study(2, defaultBuilder.description(null).minStudent(3).maxStudent(50)));
        studyList.add(new Study(3, defaultBuilder));
        studyList.add(new Study(4, defaultBuilder));
        studyList.add(new Study(5, defaultBuilder));
        studyList.add(new Study(6, defaultBuilder));
        studyList.add(new Study(7, defaultBuilder));
        studyList.add(new Study(8, defaultBuilder));
        studyList.add(new Study(9, defaultBuilder));
        studyList.add(new Study(10, defaultBuilder));
        studyList.add(new Study(11, defaultBuilder));
        studyList.add(new Study(12, defaultBuilder));
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
        groupList.filter(new StudyCondition.Builder().minStudent(4).build());
        assertEquals(groupList.size(), 0);
    }

    @Test
    void sortTest1() {
        StudyList groupList = new StudyList(studyList);
        groupList.sort(Study.StudyComparator.MINSTUDENT);
    }

}
