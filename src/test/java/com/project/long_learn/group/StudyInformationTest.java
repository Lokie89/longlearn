package com.project.long_learn.group;

import com.project.long_learn.condition.StudyInformation;
import com.project.long_learn.grouplist.StudyList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudyInformationTest {

    List<Study> studyList;

    Study sortStudy = new Study(2, new StudyInformation.Builder().minStudent(3).maxStudent(2).build());

    @BeforeEach
    void setUp() {
        studyList = new ArrayList<>();
        studyList.add(new Study(1, new StudyInformation.Builder().description("안녕").build()));
        studyList.add(sortStudy);
        studyList.add(new Study(3, new StudyInformation.Builder().build()));
        studyList.add(new Study(4, new StudyInformation.Builder().build()));
        studyList.add(new Study(5, new StudyInformation.Builder().build()));
        studyList.add(new Study(6, new StudyInformation.Builder().build()));
        studyList.add(new Study(7, new StudyInformation.Builder().build()));
        studyList.add(new Study(8, new StudyInformation.Builder().build()));
        studyList.add(new Study(9, new StudyInformation.Builder().build()));
        studyList.add(new Study(10, new StudyInformation.Builder().build()));
        studyList.add(new Study(11, new StudyInformation.Builder().build()));
        studyList.add(new Study(12, new StudyInformation.Builder().build()));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void filterTest() {
        StudyList groupList = new StudyList(studyList);
        groupList.filter(new StudyInformation.Builder().description("안녕").build());
        assertTrue(groupList.size() == 1);
    }

    @Test
    void filterTest2() {
        StudyList groupList = new StudyList(studyList);
        groupList.filter(new StudyInformation.Builder().minStudent(2).build());
        assertEquals(groupList.size(),1);
    }

    @Test
    void sortTest1() {
        StudyList groupList = new StudyList(studyList);
        groupList.sort(StudyInformation.StudyInformationComparator.MINSTUDENT);
        assertTrue(groupList.get(11).equals(sortStudy));
    }

}