package com.project.long_learn.condition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StudyDays {

    private Set<StudyDay> studyDaySet;

    public StudyDays(Set<StudyDay> studyDaySet) {
        this.studyDaySet = studyDaySet;
    }

    public StudyDays(StudyDay... studyDay) {
        studyDaySet = new HashSet<>();
        studyDaySet.addAll(Arrays.asList(studyDay));
    }

    public boolean isStudyDaysNull() {
        return Objects.isNull(studyDaySet)
                || studyDaySet.isEmpty()
                || hasStudyDayNull();
    }

    private boolean hasStudyDayNull() {
        return studyDaySet.stream()
                .filter(StudyDay::isStudyDayNull)
                .findAny()
                .isPresent()
                ;
    }

    // 스터디를 필터링 하기 위한 메서드 ( 지정된 StudyDay 에 내가 원하는 시간 날짜로 검색하기 )
    public boolean available(StudyDays condition) {
        return this.studyDaySet
                .stream()
                .filter((studyDay) ->
                        condition.studyDaySet
                                .stream()
                                .filter((conditionStudyDay) ->
                                        studyDay.contains(conditionStudyDay)
                                ).count() > 0
                ).count() == this.studyDaySet.size();
    }
}
