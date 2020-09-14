package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerSet;

import java.util.HashSet;

public class LectureStudy extends Study {
        // 순서 상관 없을 거 같아서
    private final VolunteerSet teacherSet = new VolunteerSet(new HashSet<>());

    public LectureStudy(int studyId) {
        super(studyId);
    }

    @Override
    public int involve(Volunteer volunteer) {
        return super.involve(volunteer);
    }
}
