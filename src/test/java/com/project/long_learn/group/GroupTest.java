package com.project.long_learn.group;

import com.project.long_learn.volunteer.GroupVolunteer;
import com.project.long_learn.volunteer.StudyGroupVolunteer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class GroupTest {

    @Test
    public void takeTest() {
        GroupVolunteer studyGroupVolunteer = new StudyGroupVolunteer();
        Group studyGroup = new StudyGroup();

        studyGroup.take(studyGroupVolunteer);

        assertTrue(studyGroup.contains(studyGroupVolunteer));

    }
}
