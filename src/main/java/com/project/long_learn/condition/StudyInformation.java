package com.project.long_learn.condition;

import com.project.long_learn.group.StudyDay;
import com.project.long_learn.group.StudyLocation;

import java.time.LocalDate;
import java.util.Set;

public class StudyInformation implements Condition {

    private final LocalDate start;
    private final LocalDate end;
    private final Set<StudyDay> studyDays;
    private final StudyLocation location;
    private final String description;
    private final int minStudent;
    private final int maxStudent;

    public static class Builder {

        private LocalDate start;
        private LocalDate end;
        private Set<StudyDay> studyDays;
        private StudyLocation location;

        private String description;
        private int minStudent;
        private int maxStudent;

        public Builder start(LocalDate start) {
            this.start = start;
            return this;
        }

        public Builder end(LocalDate end) {
            this.end = end;
            return this;
        }

        public Builder studyDay(Set<StudyDay> studyDays) {
            this.studyDays = studyDays;
            return this;
        }

        public Builder location(StudyLocation location) {
            this.location = location;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder minStudent(int minStudent) {
            this.minStudent = minStudent;
            return this;
        }

        public Builder maxStudent(int maxStudent) {
            this.maxStudent = maxStudent;
            return this;
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
                && (info.studyDays == null || studyDays.equals(info.studyDays))
                && (info.location == null || location.equals(info.location))
                && (info.description == null || (description != null && description.contains(info.description)))
                && (info.minStudent == 0 || minStudent > info.minStudent)
                && (info.maxStudent == 0 || maxStudent < info.maxStudent)
                ;

    }

    private StudyInformation(Builder builder) {
        this.start = builder.start;
        this.end = builder.end;
        this.studyDays = builder.studyDays;
        this.location = builder.location;
        this.description = builder.description;
        this.minStudent = builder.minStudent;
        this.maxStudent = builder.maxStudent;
    }
}
