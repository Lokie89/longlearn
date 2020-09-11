package com.project.long_learn.apply;

import java.util.Set;

public class VolunteerSet {
    private Set<Volunteer> volunteers;

    public VolunteerSet(Set<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }

    public void add(Volunteer volunteer) {
        volunteers.add(volunteer);
    }

    public boolean contains(Volunteer volunteer){
        return volunteers.contains(volunteer);
    }

}
