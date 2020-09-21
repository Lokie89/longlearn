package com.project.long_learn.condition;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public class StudyDay {

    private final DayOfWeek week;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public StudyDay(DayOfWeek week, LocalTime startTime, LocalTime endTime) {
        this.week = week;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public StudyDay(DayOfWeek week) {
        this.week = week;
        this.startTime = LocalTime.MIN;
        this.endTime = LocalTime.MAX;
    }

    public boolean isStudyDayNull() {
        return Objects.isNull(week) && Objects.isNull(startTime) && Objects.isNull(endTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StudyDay)) {
            return false;
        }
        StudyDay studyDay = (StudyDay) obj;
        return week.equals(studyDay.week) && startTime.equals(studyDay.startTime) && endTime.equals(studyDay.endTime);
    }

    public boolean contains(StudyDay condition) {
        return week.equals(condition.week) && isBeginBetweenTimes(condition);
    }

    private boolean isBeginBetweenTimes(StudyDay condition) {
        LocalTime conditionStartTime = condition.startTime;
        LocalTime conditionEndTime = condition.endTime;

        return (conditionStartTime.equals(this.startTime) || conditionStartTime.isBefore(this.startTime))
                && (this.endTime.equals(conditionEndTime) || this.endTime.isBefore(conditionEndTime));
    }

    @Override
    public int hashCode() {
        return week.hashCode() + startTime.hashCode() + endTime.hashCode();
    }
}
