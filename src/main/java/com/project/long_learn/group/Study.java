package com.project.long_learn.group;

import com.project.long_learn.alignable.VolunteerSet;
import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.Condition;
import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.VolunteerCondition;
import com.project.long_learn.condition.exception.StudyStudentArrangeException;
import com.project.long_learn.condition.exception.StudyTeacherArrangeException;
import com.project.long_learn.confirm.Confirm;
import com.project.long_learn.domain.Member;

import java.util.Comparator;

public class Study implements Group<Volunteer>, Confirm<Volunteer> {

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
        final int passedStudent = volunteerSet.copy().filter(VolunteerCondition.of(VolunteerRole.STUDENT, true)).size();
        if (!studyCondition.isSatisfiedStudentArrange(passedStudent)) {
            throw new StudyStudentArrangeException();
        }
    }

    private void validatePassedTeacher() {
        final int passedTeacher = volunteerSet.copy().filter(VolunteerCondition.of(VolunteerRole.TEACHER, true)).size();
        if (!studyCondition.isSatisfiedTeacherArrange(passedTeacher)) {
            throw new StudyTeacherArrangeException();
        }
    }

    @Override
    public void involve(Volunteer volunteer) {
        validateAddVolunteer(volunteer);
        validateRecruitment();
        volunteerSet.add(volunteer);
        volunteer.apply(studyId);
    }

    private void validateAddVolunteer(Volunteer volunteer) {
        if (volunteerSet.contains(volunteer)) {
            throw new AlreadyApplyVolunteerException();
        }
    }

    private void validateRecruitment() {
        if (!studyCondition.isSatisfiedRecruitment()) {
            throw new LateApplyStudyException();
        }
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

    @Override
    public void pass(Volunteer volunteer) {
        validateAppliedVolunteer(volunteer);
        volunteer.pass(studyId);
    }

    private void validateAppliedVolunteer(Volunteer volunteer) {
        if (!volunteerSet.contains(volunteer)) {
            throw new NotAppliedVolunteerException();
        }
    }

    @Override
    public void fail(Volunteer volunteer) {
        validateAppliedVolunteer(volunteer);
        volunteer.fail(studyId);
    }

    public boolean isMaster(Member member) {
        return studyCondition.isMaster(member);
    }

    public enum StudyComparator implements Comparator<Study> {
        START {
            @Override
            public int compare(Study o1, Study o2) {
                return o1.studyCondition.compareStart(o2.studyCondition);
            }
        },
        END {
            @Override
            public int compare(Study o1, Study o2) {
                return o1.studyCondition.compareEnd(o2.studyCondition);
            }
        },
        LOCATION {
            @Override
            public int compare(Study o1, Study o2) {
                return o1.studyCondition.compareLocation(o2.studyCondition);
            }
        },
        MINSTUDENT {
            @Override
            public int compare(Study o1, Study o2) {
                return o1.studyCondition.compareMinStudent(o2.studyCondition);
            }
        },
        MAXSTUDENT {
            @Override
            public int compare(Study o1, Study o2) {
                return o1.studyCondition.compareMaxStudent(o2.studyCondition);
            }
        },
        COSTPERCLASS {
            @Override
            public int compare(Study o1, Study o2) {
                return o1.studyCondition.compareCostPerClass(o2.studyCondition);
            }
        },
        RECRUITMENTLIMIT {
            @Override
            public int compare(Study o1, Study o2) {
                return o1.studyCondition.compareRecruitmentLimit(o2.studyCondition);
            }
        },
        ;


    }

}
