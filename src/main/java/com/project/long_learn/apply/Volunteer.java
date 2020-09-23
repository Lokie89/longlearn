package com.project.long_learn.apply;

import com.project.long_learn.condition.Condition;
import com.project.long_learn.condition.VolunteerCondition;
import com.project.long_learn.domain.Member;

import java.util.Comparator;

/**
 * 지원자
 * 신상정보와 지원한 그룹 ID
 */
public class Volunteer implements Apply {
    private Member member;
    private Condition volunteerCondition;

    public Volunteer(Member member, VolunteerCondition volunteerCondition) {
        this.volunteerCondition = volunteerCondition;
        this.member = member;
    }

    @Override
    public void apply(int appliedId) {
        member.participate(appliedId);
    }

    @Override
    public void refrain(int appliedId) {
        member.absent(appliedId);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Volunteer)) {
            return false;
        }
        Volunteer volunteer = (Volunteer) obj;
        return member.equals(volunteer.member);
    }

    @Override
    public int hashCode() {
        return member.hashCode();
    }

    public boolean isSatisfiedCondition(Condition condition) {
        return this.volunteerCondition.isSatisfiedCondition(condition);
    }

    public int compareCondition(Volunteer volunteer, Comparator comparator) {
        return this.volunteerCondition.compareCondition(volunteer.volunteerCondition, comparator);
    }

}
