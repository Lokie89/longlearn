package com.project.long_learn.group;

import java.time.LocalDate;
import java.util.Set;

public class StudyInformation {
    private final LocalDate start;
    private final LocalDate end;
    private final Set<StudyDay> studyDay;
    private final StudyLocation location;
    private final String description;
    private final int minStudent;
    private final int maxStudent;

    private static class Builder {
        private final LocalDate start;
        private final LocalDate end;
        private final Set<StudyDay> studyDay;
        private final StudyLocation location;

        private String description;
        private int minStudent;
        private int maxStudent;

        Builder(LocalDate start, LocalDate end, Set<StudyDay> studyDay, StudyLocation location) {
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
