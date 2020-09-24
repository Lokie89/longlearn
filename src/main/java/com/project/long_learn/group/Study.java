package com.project.long_learn.group;

import com.project.long_learn.alignable.VolunteerSet;
import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.Condition;
import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.VolunteerCondition;
import com.project.long_learn.condition.exception.StudyStudentArrangeException;
import com.project.long_learn.condition.exception.StudyTeacherArrangeException;

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

    public void expireApplication() {
        validateStudy();
    }

    private void validateStudy() {
        validatePassedVolunteer();
    }

    private void validatePassedVolunteer() {
        validatePassedStudent();
        validatePassedTeacher();
    }

    private void validatePassedStudent() {
        final int passedStudent = volunteerSet.filter(VolunteerCondition.of(VolunteerRole.STUDENT, true)).size();
        if (!studyCondition.isSatisfiedStudentArrange(passedStudent)) {
            throw new StudyStudentArrangeException();
        }
    }

    private void validatePassedTeacher() {
        final int passedTeacher = volunteerSet.filter(VolunteerCondition.of(VolunteerRole.TEACHER, true)).size();
        if (!studyCondition.isSatisfiedTeacherArrange(passedTeacher)) {
            throw new StudyTeacherArrangeException();
        }
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


    public boolean isSatisfiedCondition(Condition condition) {
        return this.studyCondition.isSatisfiedCondition(condition);
    }

    public int compareCondition(Study study, Comparator comparator) {
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
