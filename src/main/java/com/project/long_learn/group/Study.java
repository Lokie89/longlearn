package com.project.long_learn.club;

import com.project.long_learn.Member;

public class Study implements Club {
    private int studyId;

    @Override
    public int involve(Member member) {
        member.participate(studyId);
        return studyId;
    }
}
