package com.project.long_learn.grouplist;

import com.project.long_learn.condition.Condition;
import com.project.long_learn.group.Study;

import java.util.List;
import java.util.stream.Collectors;

public class StudyList implements GroupList {

    private List<Study> studyList;

    public StudyList(List<Study> studyList) {
        this.studyList = studyList;
    }

    @Override
    public StudyList filter(Condition condition) {
        studyList = studyList.stream()
                .filter(study -> study.isSatisfiedInformation(condition))
                .collect(Collectors.toList());
        return this;
    }

    @Override
    public StudyList sort(Condition condition) {
        return null;
    }
}
