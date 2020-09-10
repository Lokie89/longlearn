package com.project.long_learn.group;

import com.project.long_learn.domain.Member;

public class Study implements Group {
    private int studyId;

    @Override
    public int involve(Member member) {
        member.participate(studyId);
        return studyId;
    }
}
