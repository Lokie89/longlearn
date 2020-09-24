package com.project.long_learn.alignable;

import com.project.long_learn.condition.Condition;
import com.project.long_learn.group.Study;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudyList implements Alignable {

    private List<Study> studyList;

    public StudyList(List<Study> studyList) {
        this.studyList = studyList;
    }

    @Override
    public Alignable filter(Condition condition) {
        studyList = studyList.stream()
                .filter(study -> study.isSatisfiedCondition(condition))
                .collect(Collectors.toList());
        return this;
    }

    @Override
    public Alignable sort(Comparator comparator) {
        studyList.sort((o1, o2) -> o1.compareCondition(o2, comparator));
        return this;
    }

    @Override
    public int size() {
        return studyList.size();
    }

    @Override
    public Alignable copy() {
        return new StudyList(studyList);
    }
}
