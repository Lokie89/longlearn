package com.project.long_learn.condition;

import com.project.long_learn.group.StudyDay;
import com.project.long_learn.group.StudyLocation;

import java.time.LocalDate;
import java.util.Set;

public class StudyInformation extends StudyCondition.Builder {

    public StudyInformation(LocalDate start, LocalDate end, Set<StudyDay> studyDays, StudyLocation location) {
        validateStudyInformation(start, end, studyDays, location);
        start(start).end(end).studyDay(studyDays).location(location);
    }

    private void validateStudyInformation(LocalDate start, LocalDate end, Set<StudyDay> studyDays, StudyLocation location) {

        throw new RuntimeException();
    }

}
