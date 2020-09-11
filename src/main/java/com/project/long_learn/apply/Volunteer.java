package com.project.long_learn.apply;

import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Group;

/**
 * 지원자
 * 신상정보와 지원한 그룹 ID
 */
public class Volunteer implements Apply {
    private Member member;
    private int appliedGroupId = 0;

    public Volunteer() {
    }

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
}
