package com.project.long_learn.group;

import com.project.long_learn.apply.VolunteerSet;

import java.util.HashSet;

public class LectureStudy extends Study {
    private VolunteerSet teacherSet;

    public LectureStudy(int studyId) {
        // 순서 상관 없을 거 같아서
        super(studyId);
        this.teacherSet = new VolunteerSet(new HashSet<>());
    }

}
