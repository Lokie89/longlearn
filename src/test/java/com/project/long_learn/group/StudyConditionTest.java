package com.project.long_learn.group;

import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyInformation;
import com.project.long_learn.grouplist.StudyList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudyConditionTest {

    List<Study> studyList;

    Study sortStudy = new Study(2, new StudyInformation(LocalDate.now(), LocalDate.now(), new HashSet<>(), new StudyLocation()).minStudent(3));

    StudyInformation defaultStudyInformation = new StudyInformation(LocalDate.now(), LocalDate.now(), new HashSet<>(), new StudyLocation());

    @BeforeEach
    void setUp() {
        studyList = new ArrayList<>();
        studyList.add(new Study(1, defaultStudyInformation.description("안녕")));
        studyList.add(sortStudy);
        studyList.add(new Study(3, defaultStudyInformation));
        studyList.add(new Study(4, defaultStudyInformation));
        studyList.add(new Study(5, defaultStudyInformation));
        studyList.add(new Study(6, defaultStudyInformation));
        studyList.add(new Study(7, defaultStudyInformation));
        studyList.add(new Study(8, defaultStudyInformation));
        studyList.add(new Study(9, defaultStudyInformation));
        studyList.add(new Study(10, defaultStudyInformation));
        studyList.add(new Study(11, defaultStudyInformation));
        studyList.add(new Study(12, defaultStudyInformation));
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
        groupList.filter(new StudyCondition.Builder().minStudent(2).build());
        assertEquals(groupList.size(), 1);
    }

    @Test
    void sortTest1() {
        StudyList groupList = new StudyList(studyList);
        groupList.sort(StudyCondition.StudyInformationComparator.MINSTUDENT);
    }

}