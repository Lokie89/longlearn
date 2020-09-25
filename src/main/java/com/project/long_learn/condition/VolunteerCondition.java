package com.project.long_learn.condition;

import com.project.long_learn.apply.VolunteerRole;

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

    public void pass() {
        passed = true;
    }

    public void fail() {
        passed = false;
    }

    @Override
    public boolean isSatisfiedCondition(Condition condition) {
        if (!(condition instanceof VolunteerCondition)) {
            return false;
        }
        VolunteerCondition vc = (VolunteerCondition) condition;
        return (vc.volunteerRole == null || this.volunteerRole.equals(vc.volunteerRole))
                && this.passed == vc.passed;
    }

    public int compareRole(VolunteerCondition volunteerCondition) {
        return this.volunteerRole.compareTo(volunteerCondition.volunteerRole);
    }

    public int comparePassed(VolunteerCondition volunteerCondition) {
        return Boolean.compare(this.passed, volunteerCondition.passed);
    }

}
