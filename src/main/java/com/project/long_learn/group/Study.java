package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerSet;

import java.util.LinkedHashSet;

public abstract class Study implements Group {

    private final VolunteerSet volunteerSet = new VolunteerSet(new LinkedHashSet<>());
    private int studyId;

    public Study(int studyId) {
        this.studyId = studyId;
    }

    @Override
    public int involve(Volunteer volunteer) {
        volunteerSet.add(volunteer);
        return getStudyId();
    }

    @Override
    public int except(Volunteer volunteer) {
        volunteerSet.remove(volunteer);
        return getStudyId();
    }

    @Override
    public boolean isContain(Volunteer volunteer) {
        return volunteerSet.contains(volunteer);
    }

    protected int getStudyId(){
        return studyId;
    }
}
