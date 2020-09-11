package com.project.long_learn.group;

import com.project.long_learn.apply.VolunteerSet;

import java.util.HashSet;

public class LectureStudy extends Study {
    private VolunteerSet volunteerSet;

    public LectureStudy() {
        // 순서 상관 없을 거 같아서
        this.volunteerSet = new VolunteerSet(new HashSet<>());
    }
}
