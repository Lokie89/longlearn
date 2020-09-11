package com.project.long_learn.apply;

import com.project.long_learn.group.Group;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class VolunteerTest {

    Apply volunteer = new Volunteer();
    Group study = new Study();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void apply() {
        volunteer.apply(study);
        assertTrue(volunteer.isApplied());
    }
}