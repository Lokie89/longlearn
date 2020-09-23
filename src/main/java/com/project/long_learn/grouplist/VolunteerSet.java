package com.project.long_learn.grouplist;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.condition.Condition;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class VolunteerSet implements GroupList {
    private final Set<Volunteer> volunteers = new LinkedHashSet<>();

    public void add(Volunteer volunteer) {
        volunteers.add(volunteer);
    }

    public boolean contains(Volunteer volunteer) {
        return volunteers.contains(volunteer);
    }

    public void remove(Volunteer volunteer) {
        volunteers.remove(volunteer);
    }

    public boolean enoughTeacher(int minTeacher) {
        return volunteers.stream()
                .filter(Volunteer::isTeacher)
                .count() >= minTeacher;
    }

    @Override
    public int size() {
        return volunteers.size();
    }

    @Override
    public GroupList filter(Condition condition) {
        return null;
    }

    @Override
    public GroupList sort(Comparator comparator) {
        return null;
    }
}
