package com.project.long_learn.condition;

import com.project.long_learn.apply.VolunteerRole;

import java.util.Comparator;

public class VolunteerCondition implements Condition {

    private VolunteerRole volunteerRole;
    private Boolean participated;

    private VolunteerCondition(VolunteerRole volunteerRole, boolean participated) {
        this.volunteerRole = volunteerRole;
        this.participated = participated;
    }

    public static VolunteerCondition of(VolunteerRole volunteerRole, boolean participated) {
        return new VolunteerCondition(volunteerRole, participated);
    }

    public static VolunteerCondition of(VolunteerRole volunteerRole) {
        return new VolunteerCondition(volunteerRole, false);
    }

    @Override
    public boolean isSatisfiedCondition(Condition condition) {
        if (!(condition instanceof VolunteerCondition)) {
            return false;
        }
        VolunteerCondition vc = (VolunteerCondition) condition;
        return this.volunteerRole.equals(vc.volunteerRole) && this.participated == vc.participated;
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
        PARTICIPATION {
            @Override
            public int compare(VolunteerCondition o1, VolunteerCondition o2) {
                return o1.participated.compareTo(o2.participated);
            }
        },
        ;
    }
}
