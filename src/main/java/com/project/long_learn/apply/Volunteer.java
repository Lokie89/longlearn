package com.project.long_learn.apply;

import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Group;

/**
 * 지원자
 * 신상정보와 지원한 그룹 ID
 */
public class Volunteer implements Apply {
    private final Member member;
    private final VolunteerRole volunteerRole;

    public Volunteer(Member member, VolunteerRole volunteerRole) {
        this.member = member;
        this.volunteerRole = volunteerRole;
    }

    public Volunteer(Volunteer volunteer) {
        // 불변 유지 위해 값 복사함
        this.member = new Member(volunteer.member);
        this.volunteerRole = volunteer.volunteerRole;
    }

    @Override
    public void apply(Group group) {
        int appliedGroupId = group.involve(this);
        member.participate(appliedGroupId);
    }

    @Override
    public void refrain(Group group) {
        int appliedGroupId = group.except(this);
        member.absent(appliedGroupId);
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
