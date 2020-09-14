package com.project.long_learn.apply;

import java.util.Set;

public class VolunteerSet {
    private final Set<Volunteer> volunteers;

    public VolunteerSet(Set<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }

    public void add(Volunteer volunteer) {
        volunteers.add(volunteer);
    }

    public boolean contains(Volunteer volunteer) {
        return volunteers.contains(volunteer);
    }

    public boolean contains(VolunteerSet volunteerSet) {
        return volunteers.stream()
                .filter(volunteer -> volunteerSet.contains(volunteer))
                .count() > 0;
    }

}
