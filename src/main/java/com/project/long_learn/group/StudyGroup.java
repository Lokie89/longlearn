package com.project.long_learn.group;

import com.project.long_learn.volunteer.GroupVolunteer;

import java.util.LinkedHashSet;
import java.util.Set;

public class StudyGroup implements Group {

    private final Set<GroupVolunteer> volunteers = new LinkedHashSet<>();

    @Override
    public boolean contains(GroupVolunteer groupVolunteer) {
        return volunteers.contains(groupVolunteer);
    }

    @Override
    public void take(GroupVolunteer groupVolunteer) {
        volunteers.add(groupVolunteer);
    }
}
