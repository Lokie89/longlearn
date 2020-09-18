package com.project.long_learn.apply;

import com.project.long_learn.domain.Member;

/**
 * 지원자
 * 신상정보와 지원한 그룹 ID
 */
public class Volunteer implements Apply {
    private Member member;
    private final VolunteerRole volunteerRole;

    public Volunteer(Member member, VolunteerRole volunteerRole) {
        this.member = member;
        this.volunteerRole = volunteerRole;
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

    public boolean isTeacher() {
        return volunteerRole.equals(VolunteerRole.TEACHER);
    }
}
