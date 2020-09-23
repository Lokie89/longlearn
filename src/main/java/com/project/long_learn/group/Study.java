package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.alignable.VolunteerSet;
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
        validateAddVolunteer(volunteer);
        validateAddCondition();
        validateLectureStudy(volunteer);
        validateEnoughTeacher(volunteer);
        volunteerSet.add(volunteer);
        volunteer.apply(studyId);
    }

    private void validateAddVolunteer(Volunteer volunteer) {
        if (volunteerSet.contains(volunteer)) {
            throw new AlreadyApplyVolunteerException();
        }
    }

    private void validateAddCondition() {
        if (isFullVolunteerStudyCondition()) {
            throw new CannotApplyStudyException();
        }
    }

    private boolean isFullVolunteerStudyCondition() {
        return studyCondition.getMax() != 0 && vacancy() == 0;
    }

    private void validateEnoughTeacher(Volunteer volunteer) {
        if (volunteer.isTeacher() && enoughTeacher()) {
            throw new CannotApplyStudyException();
        }
    }

    private void validateLectureStudy(Volunteer volunteer) {
        if (!enoughTeacher() && !volunteer.isTeacher()
                && studyCondition.isLectureStudy()
                && !isVacantForTeacher()) {
            throw new CannotApplyStudyException();
        }
    }

    private boolean isVacantForTeacher() {
        return vacancy() > studyCondition.getMinTeacher();
    }

    private boolean enoughTeacher() {
        return volunteerSet.enoughTeacher(studyCondition.getMinTeacher());
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

    public boolean isVacant() {
        return vacancy() > 0;
    }

    public int vacancy() {
        final int max = studyCondition.getMax();
        if (max == 0) {
            return max;
        }
        return max - volunteerSet.size();
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
