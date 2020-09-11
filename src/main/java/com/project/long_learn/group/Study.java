package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerSet;

import java.util.LinkedHashSet;

public abstract class Study implements Group {

    private VolunteerSet volunteerSet;
    private int studyId;

    public Study(int studyId) {
        this.studyId = studyId;
        volunteerSet = new VolunteerSet(new LinkedHashSet<>());
    }

    @Override
    public int involve(Volunteer volunteer) {
        volunteerSet.add(volunteer);
        return studyId;
    }
}
