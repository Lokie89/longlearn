package com.project.long_learn.group;

import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.StudyDays;
import com.project.long_learn.condition.StudyLocation;
import com.project.long_learn.grouplist.StudyList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudyConditionTest {

    List<Study> studyList;

    StudyCondition.Builder defaultBuilder = new StudyCondition.Builder().start(LocalDate.EPOCH).end(LocalDate.now()).studyDay(new StudyDays(StudyDay.of(DayOfWeek.FRIDAY))).location(new StudyLocation(1, 1, "강남")).recruitmentLimit(LocalDateTime.now().plusDays(2));

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
        groupList.sort(StudyCondition.StudyInformationComparator.MINSTUDENT);
    }

    @Test
    void essentialStudyException() {

        final StudyCondition.Builder builder = new StudyCondition.Builder();
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(null).end(null).studyDay(null).location(null).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(null).end(null).studyDay(null).location(null).start(LocalDate.now()).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(null).end(null).studyDay(null).location(null).end(LocalDate.now()).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(null).end(null).studyDay(null).location(null).studyDay(new StudyDays(StudyDay.of(DayOfWeek.FRIDAY))).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(null).end(null).studyDay(null).location(null).location(new StudyLocation(1,1,"d")).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(null).end(null).studyDay(null).location(null).start(LocalDate.now()).end(LocalDate.now()).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(null).end(null).studyDay(null).location(null).start(LocalDate.EPOCH).end(LocalDate.now()).build()));
        Assertions.assertThrows(StudyEssentialFieldNotSatisfiedException.class, () -> new Study(3, builder.start(null).end(null).studyDay(null).location(null).start(LocalDate.EPOCH).end(LocalDate.now()).build()));
    }

}
