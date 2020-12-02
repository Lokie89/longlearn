package com.project.long_learn.group;

import com.project.long_learn.volunteer.GroupVolunteer;
import com.project.long_learn.volunteer.Volunteer;

public interface Group {
    boolean contains(GroupVolunteer volunteer);
    void take(GroupVolunteer volunteer);
}
