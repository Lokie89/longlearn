package com.project.long_learn;

import static org.junit.jupiter.api.Assertions.*;

import com.project.long_learn.group.Group;
import com.project.long_learn.volunteer.Member;
import com.project.long_learn.volunteer.Volunteer;
import org.junit.jupiter.api.Test;


public class VolunteerTest {

    @Test
    public void applyTest() {
        Volunteer member = new Member();
        Group study = new Study();

        member.apply(study);

        assertTrue(study.contains(member));

    }
}
