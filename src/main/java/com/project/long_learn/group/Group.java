package com.project.long_learn.group;

import com.project.long_learn.volunteer.GroupVolunteer;

public interface Group {
    boolean contains(GroupVolunteer volunteer);
    void take(GroupVolunteer volunteer);
}
