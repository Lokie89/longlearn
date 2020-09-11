package com.project.long_learn.group;

import com.project.long_learn.apply.VolunteerSet;
import com.project.long_learn.domain.Member;

import java.util.LinkedHashSet;

public abstract class Study implements Group {

    private VolunteerSet volunteerSet;
    private int studyId;

    public Study(){
        volunteerSet = new VolunteerSet(new LinkedHashSet<>());
    }

    @Override
    public int involve(Member member) {
        member.participate(studyId);
        return studyId;
    }
}
