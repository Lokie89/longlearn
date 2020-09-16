package com.project.long_learn.group;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerSet;

public abstract class Study implements Group<Volunteer> {

    private final VolunteerSet volunteerSet = new VolunteerSet();
    private int studyId;

    public Study(int studyId) {
        this.studyId = studyId;
    }

    @Override
    public void involve(Volunteer volunteer) {
        volunteerSet.add(volunteer);
        volunteer.apply(studyId);
    }

    @Override
    public void except(Volunteer volunteer) {
        volunteer.refrain(studyId);
        volunteerSet.remove(volunteer);
    }

    @Override
    public boolean isContain(Volunteer volunteer) {
        return volunteerSet.contains(volunteer);
    }


    public boolean isContainTeacher() {
        return volunteerSet.isContainTeachers();
    }


}
