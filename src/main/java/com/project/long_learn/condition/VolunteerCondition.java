package com.project.long_learn.condition;

import com.project.long_learn.apply.VolunteerRole;

import java.util.Comparator;

public class VolunteerCondition implements Condition {

    private VolunteerRole volunteerRole;
    private Boolean passed;

    private VolunteerCondition(VolunteerRole volunteerRole, boolean passed) {
        this.volunteerRole = volunteerRole;
        this.passed = passed;
    }

    public static VolunteerCondition of(VolunteerRole volunteerRole, boolean passed) {
        return new VolunteerCondition(volunteerRole, passed);
    }

    public static VolunteerCondition of(VolunteerRole volunteerRole) {
        return new VolunteerCondition(volunteerRole, false);
    }

    public void pass(){
        passed = true;
    }

    public void fail(){
        passed = false;
    }

    @Override
    public boolean isSatisfiedCondition(Condition condition) {
        if (!(condition instanceof VolunteerCondition)) {
            return false;
        }
        VolunteerCondition vc = (VolunteerCondition) condition;
        return this.volunteerRole.equals(vc.volunteerRole) && this.passed == vc.passed;
    }

    @Override
    public int compareCondition(Condition condition, Comparator comparator) {
        if (!(condition instanceof VolunteerCondition)) {
            return 0;
        }
        VolunteerCondition vc = (VolunteerCondition) condition;
        return comparator.compare(this, vc);
    }

    public enum VolunteerConditionComparator implements Comparator<VolunteerCondition> {
        ROLE {
            @Override
            public int compare(VolunteerCondition o1, VolunteerCondition o2) {
                return o1.volunteerRole.compareTo(o2.volunteerRole);
            }
        },
        PASSED {
            @Override
            public int compare(VolunteerCondition o1, VolunteerCondition o2) {
                return o1.passed.compareTo(o2.passed);
            }
        },
        ;
    }
}
