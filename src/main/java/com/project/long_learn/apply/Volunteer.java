package com.project.long_learn.apply;

import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Group;

/**
 * 지원자
 * 신상정보와 지원한
 */
public class Volunteer implements Apply {
    private Member member;
    private int appliedId;


    @Override
    public void apply(Group group) {
        appliedId = group.involve(member);
    }

    @Override
    public boolean isApplied() {
        return appliedId > 0;
    }
}
