package com.project.long_learn.alignable;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.Condition;
import com.project.long_learn.condition.VolunteerCondition;

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
                .filter(volunteer -> volunteer.isSatisfiedCondition(VolunteerCondition.of(VolunteerRole.TEACHER)))
                .count() >= minTeacher;
    }

    public void pass(Volunteer volunteer){
        volunteer.pass();
    }

    public void fail(Volunteer volunteer){
        volunteer.fail();
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
