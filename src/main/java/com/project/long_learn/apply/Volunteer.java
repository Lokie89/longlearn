package com.project.long_learn.apply;

import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Group;

/**
 * 지원자
 * 신상정보와 지원한 그룹 ID
 */
public abstract class Volunteer implements Apply {
    private Member member;
    private int appliedGroupId = 0;

    public Volunteer(Member member) {
        this.member = member;
    }

    @Override
    public void apply(Group group) {
        appliedGroupId = group.involve(member);
    }

    @Override
    public boolean isApplied() {
        return appliedGroupId > 0;
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
}
