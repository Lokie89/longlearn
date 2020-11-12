package com.project.long_learn.alignable;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.condition.Condition;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class VolunteerSet implements Alignable<Volunteer> {
    private Set<Volunteer> volunteers;

    public VolunteerSet() {
        volunteers = new LinkedHashSet<>();
    }

    private VolunteerSet(Set<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }

    public void add(Volunteer volunteer) {
        volunteers.add(volunteer);
    }

    public boolean contains(Volunteer volunteer) {
        return volunteers.contains(volunteer);
    }

    public void remove(Volunteer volunteer) {
        volunteers.remove(volunteer);
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
    public Alignable sort(Comparator<Volunteer> comparator) {
        volunteers = volunteers
                .stream()
                .sorted(comparator)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return this;
    }

    public Alignable copy() {
        return new VolunteerSet(volunteers);
    }

    @Override
    public void receive(long textId) {
        volunteers.stream().forEach(volunteer -> volunteer.receive(textId));
    }
}
