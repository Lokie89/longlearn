package com.project.long_learn.apply;

import java.util.LinkedHashSet;
import java.util.Set;

public class VolunteerSet {
    private final Set<Volunteer> volunteers = new LinkedHashSet<>();

    public void add(Volunteer volunteer) {
        Volunteer copiedVolunteer = new Volunteer(volunteer);
        volunteers.add(copiedVolunteer);
    }

    public boolean contains(Volunteer volunteer) {
        return volunteers.contains(volunteer);
    }

    public int size() {
        return volunteers.size();
    }

    public void remove(Volunteer volunteer) {
        volunteers.remove(volunteer);
    }

    public boolean isContainTeachers() {
        return volunteers.stream()
                .filter(Volunteer::isTeacher)
                .count() > 0
                ;
    }
}
