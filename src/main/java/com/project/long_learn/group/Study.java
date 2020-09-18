package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerSet;
import com.project.long_learn.condition.Condition;
import com.project.long_learn.condition.StudyCondition;

import java.util.Comparator;

public class Study implements Group<Volunteer> {

    private final VolunteerSet volunteerSet = new VolunteerSet();
    private int studyId;
    private StudyCondition studyCondition;

    public Study(int studyId, StudyCondition studyCondition) {
        this.studyId = studyId;
        studyCondition.validateEssentialField();
        this.studyCondition = studyCondition;
    }

    @Override
    public void involve(Volunteer volunteer) {
        volunteerSet.add(volunteer);
        volunteer.apply(studyId);
    }

    @Override
    public void except(Volunteer volunteer) {
        volunteer.refrain(studyId);
        volunteerSet.remove(volunteer);
    }

    @Override
    public boolean isContain(Volunteer volunteer) {
        return volunteerSet.contains(volunteer);
    }


    public boolean isContainTeacher() {
        return volunteerSet.isContainTeachers();
    }

    public boolean isSatisfiedInformation(Condition condition) {
        return this.studyCondition.isSatisfiedCondition(condition);
    }

    public int compareInformation(Study study, Comparator comparator) {
        return this.studyCondition.compareCondition(study.studyCondition, comparator);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Study)) {
            return false;
        }
        Study study = (Study) obj;
        return studyId == study.studyId;
    }

    @Override
    public int hashCode() {
        return studyId;
    }

}
