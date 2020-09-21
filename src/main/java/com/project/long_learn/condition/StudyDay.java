package com.project.long_learn.condition;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public class StudyDay {

    private final DayOfWeek week;
    private final LocalTime time;

    public StudyDay(DayOfWeek week, LocalTime time) {
        this.week = week;
        this.time = time;
    }

    public boolean isStudyDayNull() {
        return Objects.isNull(week) && Objects.isNull(time);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StudyDay)) {
            return false;
        }
        StudyDay studyDay = (StudyDay) obj;
        return week.equals(studyDay.week) && time.equals(studyDay.time);
    }

    @Override
    public int hashCode() {
        return week.hashCode() + time.hashCode();
    }
}
