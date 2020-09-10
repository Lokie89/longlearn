package com.project.long_learn.apply;

import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Group;

public class Volunteers implements Apply {
    private Member member;
    private int applyNumber;


    @Override
    public void apply(Group group) {
        applyNumber = group.involve(member);
    }

    @Override
    public boolean isApplied() {
        return applyNumber > 0;
    }
}
