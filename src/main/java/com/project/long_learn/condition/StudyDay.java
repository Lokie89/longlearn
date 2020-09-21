package com.project.long_learn.condition;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public class StudyDay {

    private final DayOfWeek week;
    private final LocalTime startTime;
    private final LocalTime endTime;

    private StudyDay(DayOfWeek week, LocalTime startTime, LocalTime endTime) {
        this.week = week;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static StudyDay of(DayOfWeek week) {
        return new StudyDay(week, LocalTime.MIN, LocalTime.MAX);
    }

    public static StudyDay of(DayOfWeek week, int startHour, int startMinute, int endHour, int endMinute) {
        return new StudyDay(week, LocalTime.of(startHour, startMinute), LocalTime.of(endHour, endMinute));
    }

    public static StudyDay of(DayOfWeek week, LocalTime startTime, LocalTime endTime) {
        return new StudyDay(week, startTime, endTime);
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
