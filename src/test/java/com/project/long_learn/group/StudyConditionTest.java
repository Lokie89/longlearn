package com.project.long_learn.group;

import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.StudyLocation;
import com.project.long_learn.grouplist.StudyList;
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

    StudyCondition.Builder defaultBuilder = new StudyCondition.Builder().start(1970,01,01).end(1970,01,02).studyDay(StudyDay.of(DayOfWeek.FRIDAY)).location(StudyLocation.of("강남")).recruitmentLimit(1969,01,01,00,00);

    StudyCondition defaultStudyCondition = defaultBuilder.build();

    @BeforeEach
    void setUp() {
        studyList = new ArrayList<>();
        studyList.add(new Study(1, defaultBuilder.description("안녕").build()));
        studyList.add(new Study(2, defaultBuilder.description(null).minStudent(3).build()));
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
        groupList.filter(new StudyCondition.Builder().minStudent(2).build());
        assertEquals(groupList.size(), 1);
    }

    @Test
    void sortTest1() {
        StudyList groupList = new StudyList(studyList);
        groupList.sort(StudyCondition.StudyConditionComparator.MINSTUDENT);
    }

    @Test
    void essentialStudyException() {

        final StudyCondition.Builder builder = new StudyCondition.Builder();
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(1970,01,01).end(1970,01,02).studyDay().location(null).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(1970,01,01).end(1970,01,02).studyDay().location(null).start(2020,9,22).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(1970,01,01).end(1970,01,02).studyDay().location(null).end(2020,9,22).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(1970,01,01).end(1970,01,02).studyDay().location(null).studyDay(StudyDay.of(DayOfWeek.FRIDAY)).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(1970,01,01).end(1970,01,02).studyDay().location(null).location(StudyLocation.of(1,1)).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(1970,01,01).end(1970,01,02).studyDay().location(null).start(2020,9,22).end(2020,9,22).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(1970,01,01).end(1970,01,02).studyDay().location(null).start(2020,9,21).end(2020,9,22).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(1970,01,01).end(1970,01,02).studyDay().location(null).start(2020,9,21).end(2020,9,22).build()));
    }

}
