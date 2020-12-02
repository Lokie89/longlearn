package com.project.long_learn;

import com.project.long_learn.group.Group;
import com.project.long_learn.group.StudyGroup;
import com.project.long_learn.volunteer.StudyGroupVolunteer;
import com.project.long_learn.volunteer.Volunteer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class VolunteerTest {

    @Test
    public void applyTest() {
        Volunteer studyVolunteer = new StudyGroupVolunteer();
        Group studyGroup = new StudyGroup();

        studyGroup.take(studyVolunteer);

        assertTrue(studyGroup.contains(studyVolunteer));

    }
}
