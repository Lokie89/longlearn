package com.project.long_learn.condition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StudyDays {

    private Set<StudyDay> studyDays;

    public StudyDays(Set<StudyDay> studyDays) {
        this.studyDays = studyDays;
    }

    public StudyDays(StudyDay... studyDay) {
        studyDays = new HashSet<>();
        studyDays.addAll(Arrays.asList(studyDay));
    }

    public boolean isStudyDaysNull() {
        return Objects.isNull(studyDays)
                || studyDays.isEmpty()
                || hasStudyDayNull();
    }

    private boolean hasStudyDayNull() {
        return studyDays.stream()
                .filter(StudyDay::isStudyDayNull)
                .findAny()
                .isPresent()
                ;
    }

    public boolean contains(StudyDays studyDays){
        return this.studyDays.containsAll(studyDays.studyDays);
    }
}
