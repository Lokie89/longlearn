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
    private VolunteerCondition volunteerCondition;

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
        return this.volunteerCondition.isSatisfiedCondition(condition)
                || this.member.isSatisfiedCondition(condition);
    }

    public void pass(int confirmId) {
        volunteerCondition.pass();
        member.pass(confirmId);
    }

    public void fail(int confirmId) {
        volunteerCondition.fail();
        member.fail(confirmId);
    }

    public enum VolunteerComparator implements Comparator<Volunteer> {
        ROLE {
            @Override
            public int compare(Volunteer o1, Volunteer o2) {
                return o1.volunteerCondition.compareRole(o2.volunteerCondition);
            }
        },
        PASSED {
            @Override
            public int compare(Volunteer o1, Volunteer o2) {
                return o1.volunteerCondition.comparePassed(o2.volunteerCondition);
            }
        },
        ID {
            @Override
            public int compare(Volunteer o1, Volunteer o2) {
                return o1.member.compareId(o2.member);
            }
        },
        REPORTED {
            @Override
            public int compare(Volunteer o1, Volunteer o2) {
                return o1.member.compareReported(o2.member);
            }
        },
        NAME {
            @Override
            public int compare(Volunteer o1, Volunteer o2) {
                return o1.member.compareName(o2.member);
            }
        },
        ;
    }

}
