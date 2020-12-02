package com.project.long_learn;

import com.project.long_learn.group.Group;
import com.project.long_learn.group.StudyGroup;
import com.project.long_learn.volunteer.GroupVolunteer;
import com.project.long_learn.volunteer.StudyGroupVolunteer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class VolunteerTest {

    @Test
    public void applyTest() {
        GroupVolunteer studyGroupVolunteer = new StudyGroupVolunteer();
        Group studyGroup = new StudyGroup();

        studyGroup.take(studyGroupVolunteer);

        assertTrue(studyGroup.contains(studyGroupVolunteer));

    }
}
