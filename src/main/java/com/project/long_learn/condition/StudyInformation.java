package com.project.long_learn.group;

import com.project.long_learn.condition.Condition;

import java.time.LocalDate;
import java.util.Set;

public class StudyInformation implements Condition {

    private final LocalDate start;
    private final LocalDate end;
    private final Set<StudyDay> studyDay;
    private final StudyLocation location;
    private final String description;
    private final int minStudent;
    private final int maxStudent;

    public static class Builder {

        private final LocalDate start;
        private final LocalDate end;
        private final Set<StudyDay> studyDay;
        private final StudyLocation location;

        private String description;
        private int minStudent;
        private int maxStudent;

        public Builder(LocalDate start, LocalDate end, Set<StudyDay> studyDay, StudyLocation location) {
            this.start = start;
            this.end = end;
            this.studyDay = studyDay;
            this.location = location;
        }

        public void description(String description) {
            this.description = description;
        }

        public void minStudent(int minStudent) {
            this.minStudent = minStudent;
        }

        public void maxStudent(int maxStudent) {
            this.maxStudent = maxStudent;
        }

        public StudyInformation build() {
            return new StudyInformation(this);
        }

    }

    @Override
    public boolean isSatisfiedCondition(Condition condition) {
        if (!(condition instanceof StudyInformation)) {
            return false;
        }
        StudyInformation info = (StudyInformation) condition;
        return (info.start == null || start.equals(info.start))
                && (info.end == null || end.equals(info.end))
                && (info.studyDay == null || studyDay.equals(info.studyDay))
                && (info.location == null || location.equals(info.location))
                && (info.description == null || description.equals(info.description))
                && (info.minStudent == 0 || minStudent > info.minStudent)
                && (info.maxStudent == 0 || maxStudent < info.maxStudent)
                ;

    }

    private StudyInformation(Builder builder) {
        this.start = builder.start;
        this.end = builder.end;
        this.studyDay = builder.studyDay;
        this.location = builder.location;
        this.description = builder.description;
        this.minStudent = builder.minStudent;
        this.maxStudent = builder.maxStudent;
    }
}
