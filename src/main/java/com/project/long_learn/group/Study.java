package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerSet;
import com.project.long_learn.condition.Condition;
import com.project.long_learn.condition.StudyInformation;

import java.util.Comparator;

public class Study implements Group<Volunteer> {

    private final VolunteerSet volunteerSet = new VolunteerSet();
    private int studyId;
    private StudyInformation studyInformation;

    public Study(int studyId, StudyInformation studyInformation) {
        this.studyId = studyId;
        this.studyInformation = studyInformation;
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
        return this.studyInformation.isSatisfiedCondition(condition);
    }

    public int compareInformation(Study study, Comparator comparator) {
        return this.studyInformation.compareCondition(study.studyInformation, comparator);
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
