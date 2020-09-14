package com.project.long_learn.apply;

import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Group;

/**
 * 지원자
 * 신상정보와 지원한 그룹 ID
 */
public class Volunteer implements Apply {
    private final Member member;
    private int appliedGroupId = 0;
    private final VolunteerRole volunteerRole;

    public Volunteer(Member member, VolunteerRole volunteerRole) {
        this.member = member;
        this.volunteerRole = volunteerRole;
    }

    @Override
    public void apply(Group group) {
        appliedGroupId = group.involve(this);
        member.participate(appliedGroupId);
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

    public boolean isTeacher() {
        return volunteerRole.equals(VolunteerRole.TEACHER);
    }
}
