package com.project.long_learn.group;

import com.project.long_learn.volunteer.Volunteer;

public class Study implements Group {
    @Override
    public boolean contains(Volunteer volunteer) {
        return false;
    }
}
