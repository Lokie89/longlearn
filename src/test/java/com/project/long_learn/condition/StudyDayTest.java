package com.project.long_learn.condition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;

class StudyDayTest {
    @Test
    void studyDayTest() {
        StudyDays studyDays = new StudyDays(new StudyDay(DayOfWeek.MONDAY, LocalTime.of(5, 00), LocalTime.of(9, 00)), new StudyDay(DayOfWeek.TUESDAY, LocalTime.of(5, 00), LocalTime.of(9, 00)));
        Assertions.assertTrue(studyDays.available(new StudyDays(new StudyDay(DayOfWeek.MONDAY, LocalTime.of(5, 00), LocalTime.of(10, 00)), new StudyDay(DayOfWeek.TUESDAY, LocalTime.of(5, 00), LocalTime.of(10, 00)))));
        Assertions.assertTrue(studyDays.available(new StudyDays(new StudyDay(DayOfWeek.MONDAY, LocalTime.of(5, 00), LocalTime.of(10, 00)), new StudyDay(DayOfWeek.TUESDAY, LocalTime.of(5, 00), LocalTime.of(10, 00)),new StudyDay(DayOfWeek.WEDNESDAY, LocalTime.of(5, 00), LocalTime.of(10, 00)))));

    }

}