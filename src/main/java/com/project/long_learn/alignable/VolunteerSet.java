package com.project.long_learn.alignable;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.condition.Condition;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class VolunteerSet implements Alignable {
    private Set<Volunteer> volunteers = new LinkedHashSet<>();

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
    public Alignable filter(Condition condition) {
        volunteers = volunteers
                .stream()
                .filter((volunteer) -> volunteer.isSatisfiedCondition(condition))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return this;
    }

    @Override
    public Alignable sort(Comparator comparator) {
        volunteers = volunteers
                .stream()
                .sorted((o1, o2) -> o1.compareCondition(o2, comparator))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return this;
    }
}