package com.project.long_learn.group;

import com.project.long_learn.volunteer.Volunteer;

import java.util.LinkedHashSet;
import java.util.Set;

public class Study implements Group {

    private final Set<Volunteer> volunteers = new LinkedHashSet<>();

    @Override
    public boolean contains(Volunteer volunteer) {
        return false;
    }

    @Override
    public void take(Volunteer volunteer) {
        volunteers.add(volunteer);
    }
}
