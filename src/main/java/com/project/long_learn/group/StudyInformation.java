package com.project.long_learn.group;

public class StudyInformation {

    private static class Builder {

        public StudyInformation build() {
            return new StudyInformation(this);
        }
    }

    private StudyInformation(Builder builder) {

    }
}
