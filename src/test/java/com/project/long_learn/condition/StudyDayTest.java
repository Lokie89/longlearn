package com.project.long_learn.condition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;

class StudyDayTest {
    @Test
    void studyDayTest() {
        StudyDays studyDays = new StudyDays(StudyDay.of(DayOfWeek.MONDAY, 5, 00, 9, 00), StudyDay.of(DayOfWeek.TUESDAY, 5, 00, 9, 00));
        Assertions.assertTrue(studyDays.available(new StudyDays(StudyDay.of(DayOfWeek.MONDAY, LocalTime.of(5, 00), LocalTime.of(10, 00)), StudyDay.of(DayOfWeek.TUESDAY, LocalTime.of(5, 00), LocalTime.of(10, 00)))));
        Assertions.assertTrue(studyDays.available(new StudyDays(StudyDay.of(DayOfWeek.MONDAY, LocalTime.of(5, 00), LocalTime.of(10, 00)), StudyDay.of(DayOfWeek.TUESDAY, LocalTime.of(5, 00), LocalTime.of(10, 00)), StudyDay.of(DayOfWeek.WEDNESDAY, LocalTime.of(5, 00), LocalTime.of(10, 00)))));

    }

}